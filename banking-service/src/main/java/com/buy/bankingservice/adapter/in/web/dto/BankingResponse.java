package com.buy.bankingservice.adapter.in.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor(staticName = "of")
public class BankingResponse {

    private final String from;
    private final String to;
    private final BigDecimal amount;
    private final String message;
}
