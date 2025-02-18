package com.buy.bankingservice.application.service;

import com.buy.bankingservice.adapter.out.persistence.account.AccountEntity;
import com.buy.bankingservice.adapter.out.persistence.account.AccountMapper;
import com.buy.bankingservice.application.port.in.BankAccountCommand;
import com.buy.bankingservice.application.port.in.FindBankAccountUseCase;
import com.buy.bankingservice.application.port.out.FindBankAccountPort;
import com.buy.bankingservice.domain.BankAccount;
import lombok.RequiredArgsConstructor;
import org.buy.common.UseCase;

@UseCase
@RequiredArgsConstructor
public class FindBankAccountService implements FindBankAccountUseCase {

    private final FindBankAccountPort findBankAccountPort;

    private final AccountMapper accountMapper;

    @Override
    public BankAccount findBankAccount(BankAccountCommand bankAccountCommand) {

        AccountEntity account = findBankAccountPort.findByAccount(new BankAccount.AccountNumber(bankAccountCommand.getBankAccountNumber()));

        return accountMapper.mapToDomainEntity(account);
    }
}
