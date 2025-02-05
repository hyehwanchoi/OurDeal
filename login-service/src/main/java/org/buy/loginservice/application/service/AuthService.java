package org.buy.loginservice.application.service;

import lombok.RequiredArgsConstructor;
import org.buy.common.UseCase;
import org.buy.loginservice.adapter.out.persistence.UserRepository;
import org.buy.loginservice.application.port.in.AuthUseCase;

@UseCase
@RequiredArgsConstructor
public class AuthService implements AuthUseCase {

    private final UserRepository userRepository;

    @Override
    public boolean authenticate(String username, String password) {

        return userRepository.findByUsername(username)
                .filter(user -> user.getPassword().equals(password))
                .isPresent();
    }
}
