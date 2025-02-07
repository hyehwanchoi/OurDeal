package org.buy.loginservice.adapter.out.persistence;

import org.buy.loginservice.domain.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User mapToDomainEntity(UserEntity userEntity) {

        return User.generateUser(new User.UserId(userEntity.getId() + ""),
                new User.UserPassword(userEntity.getPassword()),
                new User.UserUsername(userEntity.getUsername()));
    }
}
