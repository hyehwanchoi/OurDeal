package com.buy.bankingservice.adapter.out.persistence.account;

import com.buy.bankingservice.application.port.out.FindAccountPort;
import com.buy.bankingservice.application.port.out.SaveAccountPort;
import com.buy.bankingservice.domain.Account;
import lombok.RequiredArgsConstructor;
import org.buy.common.PersistenceAdapter;

@PersistenceAdapter
@RequiredArgsConstructor
public class AccountPersistenceAdapter implements FindAccountPort, SaveAccountPort {

    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    @Override
    public AccountEntity findByAccount(Account.AccountNumber accountNumber) {
        AccountEntity entity = accountRepository.findByAccountNumber(accountNumber.getAccountNumber())
                .orElseThrow(() -> new IllegalArgumentException("Account not found"));

        if (entity == null) {
            throw new NullPointerException("account not found");
        }

//        return accountMapper.mapToDomainEntity(entity);
        return entity;
    }

    @Override
    public void save(AccountEntity entity) {
        accountRepository.save(entity);
    }
}
