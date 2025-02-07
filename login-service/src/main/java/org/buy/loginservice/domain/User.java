package org.buy.loginservice.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class User {

    private String userId;
    private String username;
    private String password;

    public static User generateUser(UserId userId, UserPassword userPassword, UserUsername userUserName) {

        return new User(userId.userId, userPassword.password, userUserName.username);
    }

    @Value
    public static class UserId {
        String userId;

        public UserId(String value) {
            this.userId = value;
        }
    }

    @Value
    public static class UserPassword {
        String password;

        public UserPassword(String value) {
            this.password = value;
        }
    }

    @Value
    public static class UserUsername {
        String username;

        public UserUsername(String value) {
            this.username = value;
        }

    }
}
