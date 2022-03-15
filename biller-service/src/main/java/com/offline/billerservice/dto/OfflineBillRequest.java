package com.offline.billerservice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
public class OfflineBillRequest {
    @NotNull
    private String billerCode;
    @NotNull
    private Double billAmount;
    private String institutionCode;
    @NotNull
    private String customerNumber;
    @NotNull
    private String walletNumber;
    @NotNull
    private String pin;

}
