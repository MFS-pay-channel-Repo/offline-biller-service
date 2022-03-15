package com.offline.billerservice.dto;

import lombok.Data;

@Data
public class BillPaymentResponse {
    private BaseResponse response;
    private String dateTime;
    private String billAmount;
    private String billFee;
}
