package org.buy.loginservice.application.port.out;

import org.buy.loginservice.adapter.out.persistence.UserEntity;
import org.buy.loginservice.domain.Users;

public interface FindUserPort {

    UserEntity findByUsername(Users.UsersUserName usersId);
}
