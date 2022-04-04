package com.offline.billerservice.dto;

import lombok.Data;

@Data
public class TransactionFeeCoreResponse {
    private Integer statusCode;
    private String message;
    private TransactionFeeCoreResponse data;
}
