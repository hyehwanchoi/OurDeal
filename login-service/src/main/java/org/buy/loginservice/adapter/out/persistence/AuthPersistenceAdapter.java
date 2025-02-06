package org.buy.loginservice.adapter.out.persistence;

import lombok.RequiredArgsConstructor;
import org.buy.common.PersistenceAdapter;
import org.buy.loginservice.application.port.out.FindUserPort;
import org.buy.loginservice.domain.User;

import java.util.Optional;

@PersistenceAdapter
@RequiredArgsConstructor
public class AuthPersistenceAdapter implements FindUserPort {

    private final UserRepository userRepository;

    @Override
    public Optional<UserEntity> findByUsername(User.UserUsername userUserName) {

        return userRepository.findByUsername(userUserName);
    }
}
