package com.offline.billerservice.enumeration;

public enum CoreUrl{
    GenericPayment("/GenericPayment");
    private String url;
    CoreUrl(String envUrl) {
        this.url = envUrl;
    }

    public String getUrl() {
        return url;
    }
}
