package org.buy.loginservice.adapter.out.persistence;

import lombok.extern.slf4j.Slf4j;
import org.buy.loginservice.domain.User;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserMapper {

    public User mapToDomainEntity(UserEntity userEntity) {
        log.info("userEntity {}", userEntity);

        return User.generateUser(new User.UserId(userEntity.getId() + ""),
                new User.UserUsername(userEntity.getUsername()),
                new User.UserPassword(userEntity.getPassword()));
    }
}
