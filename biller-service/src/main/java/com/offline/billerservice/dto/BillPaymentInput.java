package com.offline.billerservice.dto;

import lombok.Data;

@Data
public class BillPaymentInput {
    public String billerCode;
    public String paymentChannel;
    public String accountNumber;
    public String pin;
    public String fee;
    public String notificationNumber;
    public String key1;
    public String key2;
    public String key3;
    public String key4;
    public String key5;
    public String key6;
    public String key7;
}
