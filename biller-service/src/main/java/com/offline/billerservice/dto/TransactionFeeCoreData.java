package com.offline.billerservice.dto;

import lombok.Data;

@Data
public class TransactionFeeCoreData {
    private Double transactionFee;
    private String transactionType;
    private String walletNumber;
    private String feePayee;
}
