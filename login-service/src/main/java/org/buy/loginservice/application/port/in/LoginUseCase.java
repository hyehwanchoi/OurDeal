package org.buy.loginservice.application.port.in;

public interface LoginUseCase {

    String login(FindUserCommand findUserCommand);
}
