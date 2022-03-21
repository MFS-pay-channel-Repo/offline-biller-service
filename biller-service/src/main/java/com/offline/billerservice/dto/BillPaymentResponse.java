package com.offline.billerservice.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class BillPaymentResponse {
    private BaseResponse response;
    private String dateTime;
    private String billAmount;
    private String billFee;
}
