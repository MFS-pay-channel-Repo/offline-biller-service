package com.offline.billerservice.gateway;


import com.google.gson.Gson;
import com.offline.billerservice.dto.BillerCorePaymentResponse;
import com.offline.billerservice.dto.BillerCoreTransactionRequest;
import com.offline.billerservice.dto.TransactionKeyValue;
import com.offline.billerservice.enumeration.APIInfo;
import com.offline.billerservice.enumeration.CoreUrl;
import com.offline.billerservice.util.CommonConstant;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class ApiManagerGateway {

    @Value("${tcash-core}")
    private String tcashUrl;

    @Value("${generic-core-bill}")
    private String genericCoreBill;

    @Autowired
    OkHttpClient okHttpClient;

    @Autowired
    Gson gson;

    public BillerCorePaymentResponse paymentUnified(BillerCoreTransactionRequest request){
        BillerCorePaymentResponse response = new BillerCorePaymentResponse();

        MediaType mediaType = MediaType.parse(APIInfo.JSON_VALUE.getValue());
        RequestBody requestBody = RequestBody.create(mediaType,gson.toJson(request));

        try {
           Request request_ = new Request.Builder()
                    .url(genericCoreBill+CoreUrl.OfflinePayment.getUrl())
                    .method("POST",requestBody)
                    .addHeader("Content-Type", APIInfo.JSON_VALUE.getValue())
                   .addHeader("UserId",request.getSenderWalletNumber())
                    .build();
            ResponseBody responseBody = okHttpClient.newCall(request_).execute().body();
           response = gson.fromJson(CommonConstant.formatString(responseBody.string()), BillerCorePaymentResponse.class);
        } catch (Exception e) {
            response.setStatusCode(CommonConstant.HTTP_5XX_ERROR);
            response.setMessage(CommonConstant.API_REQUEST_FAIL);
        }

        return response;
    }

}
