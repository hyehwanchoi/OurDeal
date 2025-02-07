package org.buy.loginservice.application.service;

import lombok.RequiredArgsConstructor;
import org.buy.common.UseCase;
import org.buy.loginservice.adapter.out.persistence.UserEntity;
import org.buy.loginservice.adapter.out.persistence.UserMapper;
import org.buy.loginservice.application.port.in.FindUserCommand;
import org.buy.loginservice.application.port.in.LoginUseCase;
import org.buy.loginservice.application.port.out.FindUserPort;
import org.buy.loginservice.domain.User;

@UseCase
@RequiredArgsConstructor
public class LoginService implements LoginUseCase {

    private final FindUserPort findUserPort;
    private final UserMapper userMapper;

    @Override
    public User login(FindUserCommand findUserCommand) {
        UserEntity userEntity = findUserPort.findByUsername(new User.UserUsername(findUserCommand.getUsername()));

        return userMapper.mapToDomainEntity(userEntity);
    }
}
