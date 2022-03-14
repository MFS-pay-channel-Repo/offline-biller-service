package com.offline.billerservice.enumeration;

public enum APIInfo {
    JSON_VALUE("application/json"),
    PAYMENT_CODE("MPAY");
    private String url;
    public String getValue() {
        return url;
    }
    APIInfo(String url_){
        this.url = url_;
    }
}
