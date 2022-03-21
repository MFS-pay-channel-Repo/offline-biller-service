package com.offline.billerservice.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class BaseResponse {
    private String responseCode;
    private String responseType;
    private String responseMessage;
    private String transactionId;

}
