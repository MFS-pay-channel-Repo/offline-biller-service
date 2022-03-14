package com.offline.billerservice.util;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public final class CommonConstant {

    public static final String SUCCESS_CODE = "000";
    public static final String TIMEOUT_CODE = "100";
    public static final String API_REQUEST_FAIL = "501";
    public static final String HTTP_4XX_ERROR = "Invalid request, Unable to process at this moment. Please try after sometime";
    public static final String HTTP_5XX_ERROR = "Internal processing error, Unable to process at this moment. Please try after sometime.";
    public static final String TIMEOUT_ERROR = "Request processing failed due to system delay. Please try after sometime.";


    public static String formatNumber(String accountNo) {
        if (accountNo.startsWith("88")) {

        } else if (accountNo.startsWith("+88")) {
            accountNo = accountNo.substring(1);
        } else {
            StringBuilder sb = new StringBuilder(accountNo);
            sb.insert(0, "88");
            accountNo = sb.toString();
        }
        return accountNo;
    }
    public static String formatString(String response){
        response = (((((response.replace("\"[", "[")).replace("]\"", "]")).replace(",   \\u000d\\u000a\\u0009", "")).replace(",\\u000d\\u000a\\u0009", "")).replace("\\u000d\\u000a", "")).replace("\\", "").replace("u0009", "");
        return response;
    }
}
