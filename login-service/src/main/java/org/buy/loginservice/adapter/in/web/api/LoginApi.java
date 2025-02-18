package org.buy.loginservice.adapter.in.web.api;

import lombok.RequiredArgsConstructor;
import org.buy.common.WebAdapter;
import org.buy.loginservice.adapter.in.web.dto.GoogleLoginRequest;
import org.buy.loginservice.adapter.in.web.dto.JwtResponse;
import org.buy.loginservice.adapter.in.web.dto.LoginRequest;
import org.buy.loginservice.application.port.in.FindUserCommand;
import org.buy.loginservice.application.port.in.GoogleLoginCommand;
import org.buy.loginservice.application.port.in.LoginUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.FailedLoginException;

@WebAdapter
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class LoginApi {

    private final LoginUseCase loginUseCase;

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody LoginRequest request) {
        FindUserCommand findUserCommand = FindUserCommand.builder()
                .username(request.getUsername())
                .password(request.getPassword())
                .build();

        String token = loginUseCase.login(findUserCommand);

        return ResponseEntity.ok(new JwtResponse(token));
    }

    @PostMapping("/google")
    public ResponseEntity<JwtResponse> googleLogin(@RequestBody GoogleLoginRequest request) throws FailedLoginException {

        GoogleLoginCommand googleLoginCommand = GoogleLoginCommand.builder()
                .googleToken(request.getGoogleToken()).build();

        String token = loginUseCase.googleLogin(googleLoginCommand);

        return ResponseEntity.ok(new JwtResponse(token));
    }
}
