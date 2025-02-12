package com.buy.bankingservice.application.port.out;

import com.buy.bankingservice.adapter.out.persistence.account.AccountEntity;
import com.buy.bankingservice.domain.Account;

public interface FindAccountPort {

    AccountEntity findByAccount(Account.AccountNumber accountNumber);
}
