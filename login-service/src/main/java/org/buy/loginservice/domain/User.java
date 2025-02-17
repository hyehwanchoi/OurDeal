package org.buy.loginservice.domain;

import lombok.*;

@ToString
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class User {

    private String userId;
    private String username;
    private String password;

    public static User generateUser(UserId userId, UserUsername userUserName, UserPassword userPassword) {

        return new User(userId.userId, userUserName.username, userPassword.password);
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
