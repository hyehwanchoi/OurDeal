package com.buy.bankingservice.adapter.in.web.api;

import com.buy.bankingservice.application.port.in.BankAccountCommand;
import com.buy.bankingservice.application.port.in.FindBankAccountUseCase;
import com.buy.bankingservice.domain.BankAccount;
import lombok.RequiredArgsConstructor;
import org.buy.common.WebAdapter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequestMapping("/api/accounts")
@RequiredArgsConstructor
public class BankAccountApi {

    private final FindBankAccountUseCase findBankAccountUseCase;

    @GetMapping("/{bankAccountNumber}")
    public BankAccount findBankAccount(@PathVariable String bankAccountNumber) {

        BankAccountCommand command = BankAccountCommand.builder().bankAccountNumber(bankAccountNumber).build();

        return findBankAccountUseCase.findBankAccount(command);
    }
}
