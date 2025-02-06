package org.buy.loginservice.adapter.out.persistence;

import org.buy.loginservice.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<User> findByUsername(User.UserUsername username);
}
