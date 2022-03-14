package com.offline.billerservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TransactionKeyValue {
    private String Key;
    private String Value;
}
