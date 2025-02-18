package com.buy.bankingservice.application.port.in;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.buy.common.SelfValidating;

@Getter
@Builder
@EqualsAndHashCode(callSuper = true)
public class BankAccountCommand extends SelfValidating<BankAccountCommand> {

    private final String bankAccountNumber;

    public BankAccountCommand(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;

        this.validatorSelf();
    }
}
