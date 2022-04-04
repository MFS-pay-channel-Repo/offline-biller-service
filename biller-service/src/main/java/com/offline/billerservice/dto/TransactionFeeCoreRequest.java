package com.offline.billerservice.dto;

import lombok.Data;

@Data
public class TransactionFeeCoreRequest {
    private String WalletNumber;
    private String TransactionType;
    private String Amount;
    private String ReceiverCode;
}
