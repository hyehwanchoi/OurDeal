package org.buy.loginservice.application.port.in;

import javax.security.auth.login.FailedLoginException;

public interface LoginUseCase {

    String login(FindUserCommand findUserCommand);

    String googleLogin(GoogleLoginCommand googleLoginCommand) throws FailedLoginException;
}
