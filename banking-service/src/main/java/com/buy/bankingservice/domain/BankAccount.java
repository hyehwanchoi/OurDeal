package com.buy.bankingservice.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class BankAccount {

    private String accountId;
    private String accountNumber;
    private BigDecimal balance;

    public static BankAccount generateAccount(AccountId accountId, AccountNumber accountNumber, Balance balance) {

        return new BankAccount(accountId.accountId, accountNumber.accountNumber, balance.balance);
    }

    @Value
    public static class AccountId {
        String accountId;

        public AccountId(String value) {
            this.accountId = value;
        }
    }

    @Value
    public static class AccountNumber {
        String accountNumber;

        public AccountNumber(String value) {
            this.accountNumber = value;
        }
    }

    @Value
    public static class Balance {
        BigDecimal balance;

        public Balance(BigDecimal value) {
            this.balance = value;
        }
    }
}
