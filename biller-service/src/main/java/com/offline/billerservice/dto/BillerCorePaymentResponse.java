package com.offline.billerservice.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class BillerCorePaymentResponse {
   private String message;
   private String transactionId;
   private String statusCode;
}
