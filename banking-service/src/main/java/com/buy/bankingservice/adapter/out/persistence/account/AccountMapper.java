package com.buy.bankingservice.adapter.out.persistence.account;

import com.buy.bankingservice.domain.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {

    public Account mapToDomainEntity(AccountEntity entity) {

        return Account.generateAccount(new Account.AccountId(entity.getId() + ""),
                new Account.AccountNumber(entity.getAccountNumber()), new Account.Balance(entity.getBalance()));
    }
}
