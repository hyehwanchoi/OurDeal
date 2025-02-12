package com.buy.bankingservice.application.service;

import com.buy.bankingservice.adapter.in.web.dto.BankingRequest;
import com.buy.bankingservice.adapter.in.web.dto.BankingResponse;
import com.buy.bankingservice.adapter.out.persistence.account.AccountEntity;
import com.buy.bankingservice.application.port.in.BankingUseCase;
import com.buy.bankingservice.application.port.out.FindAccountPort;
import com.buy.bankingservice.application.port.out.SaveAccountPort;
import com.buy.bankingservice.domain.Account;
import lombok.RequiredArgsConstructor;
import org.buy.common.UseCase;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@RequiredArgsConstructor
public class BankingService implements BankingUseCase {

    private final FindAccountPort findAccountPort;
    private final SaveAccountPort saveAccountPort;


    @Transactional
    @Override
    public BankingResponse transfer(BankingRequest request) {
        AccountEntity sender = findAccountPort.findByAccount(new Account.AccountNumber(request.getFrom()));
        AccountEntity receiver = findAccountPort.findByAccount(new Account.AccountNumber(request.getTo()));

        sender.withdraw(request.getAmount());
        receiver.deposit(request.getAmount());

        saveAccountPort.save(sender);
        saveAccountPort.save(receiver);

        return BankingResponse.of(request.getFrom(), request.getTo(), request.getAmount(), "success");
    }
}
