package com.buy.bankingservice.adapter.in.web.dto;

import java.math.BigDecimal;

public record BankTransferRequest(String from, String to, BigDecimal amount) {

}
