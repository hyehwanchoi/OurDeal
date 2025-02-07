package org.buy.loginservice.application.port.in;

import org.buy.loginservice.domain.User;

public interface LoginUseCase {

    User login(FindUserCommand findUserCommand);
}
