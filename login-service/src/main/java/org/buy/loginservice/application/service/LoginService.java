package org.buy.loginservice.application.service;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.buy.common.UseCase;
import org.buy.loginservice.adapter.out.persistence.UserEntity;
import org.buy.loginservice.adapter.out.persistence.UserMapper;
import org.buy.loginservice.adapter.out.security.JwtTokenProvider;
import org.buy.loginservice.application.port.in.FindUserCommand;
import org.buy.loginservice.application.port.in.GoogleLoginCommand;
import org.buy.loginservice.application.port.in.LoginUseCase;
import org.buy.loginservice.application.port.out.FindUserPort;
import org.buy.loginservice.domain.User;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collections;

@Slf4j
@UseCase
@RequiredArgsConstructor
public class LoginService implements LoginUseCase {

    private final static String GOOGLE_CLIENT_ID = "1";

    private final FindUserPort findUserPort;
    private final UserMapper userMapper;

    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public String login(FindUserCommand findUserCommand) {
        UserEntity userEntity = findUserPort.findByUsername(new User.UserUsername(findUserCommand.getUsername()));

        if (userEntity == null) {
            throw new RuntimeException("User not found");
        }

        // 입력된 평문 비밀번호와 DB에 저장된 암호화된 비밀번호 비교
        if (!passwordEncoder.matches(findUserCommand.getPassword(), userEntity.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        User user = userMapper.mapToDomainEntity(userEntity);
        log.info("user {}", user.toString());

        return jwtTokenProvider.generateToken(user);
    }

    @Override
    public String googleLogin(GoogleLoginCommand googleLoginCommand) {
        String googleToken = googleLoginCommand.getGoogleToken();

        GoogleIdToken.Payload payload = validateGoogleToken(googleToken);

        if (payload == null) {
            throw new RuntimeException("Invalid Google token");
        }

        String email = payload.getEmail();
        String name = (String) payload.get("name");
        User user = User.generateUser(
                new User.UserId(email),
                new User.UserUsername(email),
                new User.UserPassword("")
        );

        return jwtTokenProvider.generateToken(user);
    }

    private GoogleIdToken.Payload validateGoogleToken(String googleTokenString) {
        try {
            GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(
                    new NetHttpTransport(), new JacksonFactory()
            )
                    .setAudience(Collections.singletonList(GOOGLE_CLIENT_ID))
                    .build();

            GoogleIdToken googleToken = verifier.verify(googleTokenString);
            if (googleToken != null) {
                return googleToken.getPayload();
            } else {
                return null;
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }
}
