package org.buy.loginservice.adapter.in.web;

import lombok.RequiredArgsConstructor;
import org.buy.loginservice.adapter.in.web.dto.LoginRequest;
import org.buy.loginservice.adapter.in.web.dto.LoginResponse;
import org.buy.loginservice.application.port.in.LoginUseCase;
import org.buy.loginservice.domain.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class LoginApi {

    private final LoginUseCase loginUseCase;

    @GetMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        Optional<User> user = loginUseCase.login(request.getUsername(), request.getPassword());

        if (user.isPresent()) {
            LoginResponse result = LoginResponse.of("Login success", user.get().getUsername());
            return ResponseEntity.ok(result);
        } else {
            LoginResponse result = LoginResponse.of("Invalid credentials", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
        }
    }
}
