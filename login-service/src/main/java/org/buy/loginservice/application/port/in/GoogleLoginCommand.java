package org.buy.loginservice.application.port.in;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.buy.common.SelfValidating;

@Getter
@Builder
@EqualsAndHashCode(callSuper = true)
public class GoogleLoginCommand extends SelfValidating<GoogleLoginCommand> {

    private String googleToken;

    public GoogleLoginCommand(String googleToken) {
        this.googleToken = googleToken;

        this.validatorSelf();
    }
}
