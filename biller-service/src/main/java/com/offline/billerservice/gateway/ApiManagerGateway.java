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
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;

import java.util.ArrayList;

@Service
public class ApiManagerGateway {

    @Value("${tcash-core}")
    private String tcashUrl;

//    private final Request request;
//    public ApiManagerGateway(OkHttpClient.Builder builder){
//
//    }
    @Autowired
    OkHttpClient okHttpClient;

    @Autowired
    Gson gson;

    private BillerCoreTransactionRequest generateCoreTransactionRequest(){
        BillerCoreTransactionRequest billerCoreTransactionRequest = new BillerCoreTransactionRequest();
//        "TransactionTypeKeyWord": "MPAY",
        billerCoreTransactionRequest.setTransactionTypeKeyWord(APIInfo.PAYMENT_CODE.getValue());
        billerCoreTransactionRequest.setAmount("500");
        billerCoreTransactionRequest.setFromAccount(CommonConstant.formatNumber("8801727262490"));
        billerCoreTransactionRequest.setToAccount(CommonConstant.formatNumber("8801812345205"));
        billerCoreTransactionRequest.setPIN("MTIzNA==");
        billerCoreTransactionRequest.setChannel("app");

        ArrayList<TransactionKeyValue> transactionKeyValues = new ArrayList<>();
        transactionKeyValues.add(new TransactionKeyValue("ToUserNumber",CommonConstant.formatNumber("8801812345205")));
        transactionKeyValues.add(new TransactionKeyValue("Purpose","test"));

        return billerCoreTransactionRequest;
    }
    public BillerCorePaymentResponse paymentUnified(BillerCoreTransactionRequest request){
        BillerCorePaymentResponse response = new BillerCorePaymentResponse();
        MediaType mediaType = MediaType.parse(APIInfo.JSON_VALUE.getValue());
        RequestBody requestBody = RequestBody.create(mediaType,gson.toJson(request));

        try {
           Request request_ = new Request.Builder()
                    .url(tcashUrl+CoreUrl.GenericPayment.getUrl())
                    .method("POST",requestBody)
                    .addHeader("Content-Type", APIInfo.JSON_VALUE.getValue())
                    .build();
            ResponseBody responseBody = okHttpClient.newCall(request_).execute().body();
           response = gson.fromJson(CommonConstant.formatString(responseBody.string()), BillerCorePaymentResponse.class);
        } catch (Exception e) {
            response.setCode(CommonConstant.HTTP_5XX_ERROR);
            response.setMessage(CommonConstant.API_REQUEST_FAIL);
        }

        return response;
    }

}
