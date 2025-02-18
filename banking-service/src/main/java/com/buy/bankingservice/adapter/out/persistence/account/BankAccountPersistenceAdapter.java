package com.buy.bankingservice.adapter.out.persistence.account;

import com.buy.bankingservice.application.port.out.FindBankAccountPort;
import com.buy.bankingservice.application.port.out.SaveAccountPort;
import com.buy.bankingservice.domain.BankAccount;
import lombok.RequiredArgsConstructor;
import org.buy.common.PersistenceAdapter;

@PersistenceAdapter
@RequiredArgsConstructor
public class BankAccountPersistenceAdapter implements FindBankAccountPort, SaveAccountPort {

    private final AccountRepository accountRepository;

    @Override
    public AccountEntity findByAccount(BankAccount.AccountNumber accountNumber) {
        AccountEntity entity = accountRepository.findByAccountNumber(accountNumber.getAccountNumber())
                .orElseThrow(() -> new IllegalArgumentException("Account not found"));

        if (entity == null) {
            throw new NullPointerException("account not found");
        }

        return entity;
    }

    @Override
    public void save(AccountEntity entity) {
        accountRepository.save(entity);
    }
}
