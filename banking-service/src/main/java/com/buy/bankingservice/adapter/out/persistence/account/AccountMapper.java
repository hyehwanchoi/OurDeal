package com.buy.bankingservice.adapter.out.persistence.account;

import com.buy.bankingservice.domain.BankAccount;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {

    public BankAccount mapToDomainEntity(AccountEntity entity) {

        return BankAccount.generateAccount(new BankAccount.AccountId(entity.getId() + ""),
                new BankAccount.AccountNumber(entity.getAccountNumber()), new BankAccount.Balance(entity.getBalance()));
    }
}
