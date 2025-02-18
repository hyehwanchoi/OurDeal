package com.buy.bankingservice.application.port.in;

import com.buy.bankingservice.domain.BankAccount;

public interface BankTransferUseCase {

    BankAccount transfer(BankTransferCommand command);
}
