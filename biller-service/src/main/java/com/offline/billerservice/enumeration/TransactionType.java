package com.offline.billerservice.enumeration;

public enum TransactionType {
    ZAKAT_CODE("zakat");
    private String code;
    public String getValue() {
        return code;
    }
    TransactionType(String code_){
        this.code = code_;
    }
}
