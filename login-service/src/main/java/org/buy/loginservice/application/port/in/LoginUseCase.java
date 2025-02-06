package org.buy.loginservice.application.port.in;

import org.buy.loginservice.domain.User;

import java.util.Optional;

public interface LoginUseCase {

    Optional<User> login(String username, String password);
}
