package org.buy.loginservice.application.port.in;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.buy.common.SelfValidating;

@Getter
@Builder
@EqualsAndHashCode(callSuper = true)
public class FindUserCommand extends SelfValidating<FindUserCommand> {

    private final String username;
    private final String password;
}
