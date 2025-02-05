package org.buy.loginservice.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Users {

    private Long id;
    private String username;
    private String password;

    public static Users generateUsers(UsersId usersId, UsersPassword usersPassword, UsersUserName usersUserName) {

        return new Users(usersId.userId, usersPassword.userPassword, usersUserName.userUsername);
    }

    public record UsersId(Long userId) {
    }

    public record UsersPassword(String userPassword) {
    }

    public record UsersUserName(String userUsername) {
    }
}
