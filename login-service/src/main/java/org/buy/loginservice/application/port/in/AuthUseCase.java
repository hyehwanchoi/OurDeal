package org.buy.loginservice.application.port.in;

public interface AuthUseCase {

    boolean authenticate(String username, String password);
}
