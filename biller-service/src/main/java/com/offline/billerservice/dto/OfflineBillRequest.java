package com.offline.billerservice.dto;

import lombok.*;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
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
