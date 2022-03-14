package com.offline.billerservice.dto;

import lombok.Data;

@Data
public class BillerCorePaymentResponse {
    private String TxCode;
    private String Code;
    private String Message;
    private String TxId;
}
