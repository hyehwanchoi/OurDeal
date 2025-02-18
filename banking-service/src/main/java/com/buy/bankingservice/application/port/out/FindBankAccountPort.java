package com.buy.bankingservice.application.port.out;

import com.buy.bankingservice.adapter.out.persistence.account.AccountEntity;
import com.buy.bankingservice.domain.BankAccount;

public interface FindBankAccountPort {

    AccountEntity findByAccount(BankAccount.AccountNumber accountNumber);
}
