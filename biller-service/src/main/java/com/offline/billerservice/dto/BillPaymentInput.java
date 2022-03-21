package com.offline.billerservice.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class BillPaymentInput {
    private String billerCode;
    private String paymentChannel;
    private String accountNumber;
    private String pin;
    private String fee;
    private String notificationNumber;
    private String key1;
    private String key2;
    private String key3;
    private String key4;
    private String key5;
    private String key6;
    private String key7;
}
