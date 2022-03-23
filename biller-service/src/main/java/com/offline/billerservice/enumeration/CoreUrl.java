package com.offline.billerservice.enumeration;

public enum CoreUrl{
    GENERIC_PAYMENT("/GenericPayment"),
    DIRECT_PAYMENT("/GenericTxt/DirectPayment"),
    OFFLINE_PAYMENT("/OffLineBillpay/OffLinePayment"),
    ZAKAT_PAYMENT("/ZakatPay/ZakatPayment");
    private String url;
    CoreUrl(String envUrl) {
        this.url = envUrl;
    }

    public String getUrl() {
        return url;
    }
}
