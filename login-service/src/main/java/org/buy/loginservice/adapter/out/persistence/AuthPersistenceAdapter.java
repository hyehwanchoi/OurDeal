package org.buy.loginservice.adapter.out.persistence;

import lombok.RequiredArgsConstructor;
import org.buy.common.PersistenceAdapter;
import org.buy.loginservice.application.port.out.FindUserPort;
import org.buy.loginservice.domain.Users;

@PersistenceAdapter
@RequiredArgsConstructor
public class AuthPersistenceAdapter implements FindUserPort {

    private final UserRepository userRepository;

    @Override
    public UserEntity findByUsername(Users.UsersUserName usersUserName) {

        return userRepository.findByUsername(usersUserName.get);
    }
}
