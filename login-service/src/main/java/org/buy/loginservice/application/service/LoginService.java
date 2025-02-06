package org.buy.loginservice.application.service;

import lombok.RequiredArgsConstructor;
import org.buy.common.UseCase;
import org.buy.loginservice.adapter.out.persistence.UserRepository;
import org.buy.loginservice.application.port.in.LoginUseCase;
import org.buy.loginservice.domain.User;

import java.util.Optional;

@UseCase
@RequiredArgsConstructor
public class LoginService implements LoginUseCase {

    private final UserRepository userRepository;

    @Override
    public Optional<User> login(String username, String password) {
        Optional<User> user = userRepository.findByUsername(new User.UserUsername(username));

        if (user.isPresent() && user.get().getPassword().equals(password)) {
            return user;
        }
        return Optional.empty();
    }
}
