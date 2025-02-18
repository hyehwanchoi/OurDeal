package com.buy.bankingservice.application.port.in;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.buy.common.SelfValidating;

import java.math.BigDecimal;

@Builder
@Getter
@EqualsAndHashCode(callSuper = true)
public class BankTransferCommand extends SelfValidating<BankTransferCommand> {

    @NotNull
    private final String from;

    @NotNull
    private final String to;

    @NotNull
    private final BigDecimal amount;

    public BankTransferCommand(String from, String to, BigDecimal amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;

        this.validatorSelf();
    }
}
