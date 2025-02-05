package org.buy.loginservice.adapter.out.persistence;

import org.buy.loginservice.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByUsername(Users.UsersUserName username);
}
