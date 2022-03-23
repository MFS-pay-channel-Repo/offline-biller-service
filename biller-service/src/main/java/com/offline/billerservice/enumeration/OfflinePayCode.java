package com.offline.billerservice.enumeration;

public enum OfflinePayCode {
    ZAKAT_CODE("2377");
    private String code;
    public String getValue() {
        return code;
    }
    OfflinePayCode(String code_){
        this.code = code_;
    }
}
