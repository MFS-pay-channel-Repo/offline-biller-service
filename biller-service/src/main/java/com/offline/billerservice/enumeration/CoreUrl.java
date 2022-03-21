package com.offline.billerservice.enumeration;

public enum CoreUrl{
    GenericPayment("/GenericPayment"),
    OfflinePayment("/GenericTxt/DirectPayment");
    private String url;
    CoreUrl(String envUrl) {
        this.url = envUrl;
    }

    public String getUrl() {
        return url;
    }
}
