package com.offline.billerservice.dto;

import lombok.Data;

import java.util.ArrayList;

@Data
public class BillerCoreTransactionRequest {
    private String TransactionTypeKeyWord;
    private String Amount;
    private String FromAccount;
    private String ToAccount;
    private String PIN;
    private String Channel;
    ArrayList<TransactionKeyValue> TransactionRecordReplacerValues = new ArrayList<TransactionKeyValue>();
}
