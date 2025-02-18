package com.buy.bankingservice.adapter.in.web.api;

import com.buy.bankingservice.adapter.in.web.dto.BankTransferRequest;
import com.buy.bankingservice.application.port.in.BankTransferCommand;
import com.buy.bankingservice.application.port.in.BankTransferUseCase;
import com.buy.bankingservice.domain.BankAccount;
import lombok.RequiredArgsConstructor;
import org.buy.common.WebAdapter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequestMapping("/api/banking")
@RequiredArgsConstructor
public class BankTransferApi {

    private final BankTransferUseCase bankTransferUseCase;

    @PostMapping("/transfer")
    public BankAccount transfer(@RequestBody BankTransferRequest request) {

        BankTransferCommand command = BankTransferCommand.builder()
                .from(request.from())
                .to(request.to())
                .amount(request.amount()).build();

        return bankTransferUseCase.transfer(command);
    }
}
