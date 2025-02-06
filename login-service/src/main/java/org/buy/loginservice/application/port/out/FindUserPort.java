package org.buy.loginservice.application.port.out;

import org.buy.loginservice.adapter.out.persistence.UserEntity;
import org.buy.loginservice.domain.User;

import java.util.Optional;

public interface FindUserPort {

    Optional<UserEntity> findByUsername(User.UserUsername usersId);
}
