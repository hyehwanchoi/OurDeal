package org.buy.loginservice.application.service;

import lombok.RequiredArgsConstructor;
import org.buy.common.UseCase;
import org.buy.loginservice.adapter.out.persistence.UserEntity;
import org.buy.loginservice.adapter.out.persistence.UserMapper;
import org.buy.loginservice.adapter.out.security.JwtTokenProvider;
import org.buy.loginservice.application.port.in.FindUserCommand;
import org.buy.loginservice.application.port.in.LoginUseCase;
import org.buy.loginservice.application.port.out.FindUserPort;
import org.buy.loginservice.domain.User;
import org.springframework.security.crypto.password.PasswordEncoder;

@UseCase
@RequiredArgsConstructor
public class LoginService implements LoginUseCase {

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
        
        return jwtTokenProvider.generateToken(user);
    }
}
