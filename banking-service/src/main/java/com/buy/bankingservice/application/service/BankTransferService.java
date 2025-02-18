package com.buy.bankingservice.application.service;

import com.buy.bankingservice.adapter.out.persistence.account.AccountEntity;
import com.buy.bankingservice.adapter.out.persistence.account.AccountMapper;
import com.buy.bankingservice.application.port.in.BankTransferCommand;
import com.buy.bankingservice.application.port.in.BankTransferUseCase;
import com.buy.bankingservice.application.port.out.FindBankAccountPort;
import com.buy.bankingservice.application.port.out.SaveAccountPort;
import com.buy.bankingservice.domain.BankAccount;
import lombok.RequiredArgsConstructor;
import org.buy.common.UseCase;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@RequiredArgsConstructor
public class BankTransferService implements BankTransferUseCase {

    private final FindBankAccountPort findBankAccountPort;
    private final SaveAccountPort saveAccountPort;

    private final AccountMapper accountMapper;


    @Transactional
    @Override
    public BankAccount transfer(final BankTransferCommand command) {
        AccountEntity sender = findBankAccountPort.findByAccount(new BankAccount.AccountNumber(command.getFrom()));
        AccountEntity receiver = findBankAccountPort.findByAccount(new BankAccount.AccountNumber(command.getTo()));

        sender.withdraw(command.getAmount());
        receiver.deposit(command.getAmount());

        saveAccountPort.save(sender);
        saveAccountPort.save(receiver);

        return accountMapper.mapToDomainEntity(sender);
    }
}
