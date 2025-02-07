package org.buy.loginservice.adapter.out.persistence;

import lombok.RequiredArgsConstructor;
import org.buy.common.PersistenceAdapter;
import org.buy.loginservice.application.port.out.FindUserPort;
import org.buy.loginservice.domain.User;

@PersistenceAdapter
@RequiredArgsConstructor
public class AuthPersistenceAdapter implements FindUserPort {

    private final UserRepository userRepository;

    @Override
    public UserEntity findByUsername(User.UserUsername username) {

        return userRepository.findByUsername(username.getUsername());
    }
}
