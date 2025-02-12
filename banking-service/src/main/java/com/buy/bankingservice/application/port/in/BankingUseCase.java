package com.buy.bankingservice.application.port.in;

import com.buy.bankingservice.adapter.in.web.dto.BankingRequest;
import com.buy.bankingservice.adapter.in.web.dto.BankingResponse;

public interface BankingUseCase {

    BankingResponse transfer(BankingRequest request);
}
