package com.offline.billerservice.dto;

import lombok.Data;

@Data
public class BaseResponse {
    private String responseCode;
    private String responseType;
    private String responseMessage;
    private String transactionId;

}
