package com.buy.bankingservice.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

@Getter
@AllArgsConstructor
public class Transaction {

    private String transactionId;
    private String senderAccount;
    private String receiverAccount;
    private String amount;
    private String transactionTime;

    @Value
    public static class TransactionId {
        String transactionId;

        public TransactionId(String value) {
            this.transactionId = value;
        }
    }

    @Value
    public static class SenderAccount {
        String senderAccount;

        public SenderAccount(String value) {
            this.senderAccount = value;
        }
    }

    @Value
    public static class ReceiverAccount {
        String receiverAccount;

        public ReceiverAccount(String value) {
            this.receiverAccount = value;
        }
    }

    @Value
    public static class Amount {
        String amount;

        public Amount(String value) {
            this.amount = value;
        }
    }

    @Value
    public static class TransactionTime {
        String transactionTime;

        public TransactionTime(String value) {
            this.transactionTime = value;
        }
    }
}
