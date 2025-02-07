package org.buy.loginservice.adapter.in.web;

import lombok.RequiredArgsConstructor;
import org.buy.loginservice.adapter.in.web.dto.LoginRequest;
import org.buy.loginservice.application.port.in.FindUserCommand;
import org.buy.loginservice.application.port.in.LoginUseCase;
import org.buy.loginservice.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class LoginApi {

    private final LoginUseCase loginUseCase;

    @GetMapping("/login")
    public ResponseEntity<User> login(@RequestBody LoginRequest request) {
        FindUserCommand findUserCommand = FindUserCommand.builder().username(request.getUsername()).build();

        User user = loginUseCase.login(findUserCommand);

        return ResponseEntity.ok(user);
    }
}
