package com.offline.billerservice.service;

//import com.google.gson.JsonObject;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.offline.billerservice.domain.BillerInfo;
import com.offline.billerservice.dto.*;
import com.offline.billerservice.enumeration.OfflinePayCode;
import com.offline.billerservice.enumeration.TransactionType;
import com.offline.billerservice.gateway.ApiManagerGateway;
import com.offline.billerservice.repository.BillerInfoRepository;
//import jdk.nashorn.internal.parser.JSONParser;
import com.offline.billerservice.util.CommonConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Slf4j
@Service
public class BillerInfoServiceImpl implements BillerInfoService {
    @Autowired
    ApiManagerGateway apiManagerGateway;

    @Autowired
    BillerInfoRepository billerInfoRepository;

    @Autowired
    Gson gson;

//    @Override
    private void saveBillerInfoLog(BillerInfo billerInfo) {
        billerInfoRepository.save(billerInfo);
    }
    private BillerInfo logBillerInfo(Object object, String billerCode, String merchantNumber){

        BillerInfo billerInfo = new BillerInfo();
        billerInfo.setBillerCode(billerCode);
        billerInfo.setBillerIsOffline(true);
        billerInfo.setMerchantNumber(merchantNumber);
        try {
            JsonObject jsonObject = new JsonObject();
            billerInfo.setBillerDetails(gson.toJson(object).toString());
        }catch (Exception ex){

        }
        billerInfoRepository.save(billerInfo);
        return billerInfo;
    }


    @Override
    public BillPaymentResponse makePayment(BillPaymentInput input) {
       BillerCorePaymentResponse response = makeZakatPaymentDoLogAndResponse(input);
       BillPaymentResponse paymentResponse = new BillPaymentResponse();

        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setResponseCode(response.getStatusCode().equals("200") ? "000":"103");
        baseResponse.setResponseMessage(response.getMessage());
        baseResponse.setTransactionId(response.getTransactionId());
        paymentResponse.setResponse(baseResponse);
        paymentResponse.setDateTime(String.valueOf(Calendar.getInstance().getTime()));
        paymentResponse.setBillAmount(input.getFee());
        return paymentResponse;
    }

    @Override
    public BillerCorePaymentResponse makeZakatPaymentDoLogAndResponse(BillPaymentInput input) {

        BillerCoreTransactionRequest request = generateCoreZakatTransactionRequest(input);
        log.info("{}",request);
        logBillerInfo(request,input.getBillerCode(),input.getKey1());
        BillerCorePaymentResponse response = apiManagerGateway.zakatOfflinePayment(request);
        logBillerInfo(response,input.getBillerCode(),input.getKey1());
        log.info("{}",response);
        return response;
    }
    private String generateRandomString(int length){
        StringBuilder resultBuilder = new StringBuilder(length);
        String alphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789";
//                + "abcdefghijklmnopqrstuvxyz";
        for(int i = 0; i < length;i++){
            int indx = (int) (alphaNumericString.length() * Math.random());

            resultBuilder.append(alphaNumericString.charAt(indx));
        }
        return resultBuilder.toString();
    }
    private  String generateTransactionReferenceId(String service_name){
        String result = "";
        DateFormat dateFormat = new SimpleDateFormat("yyMMddHHmmss");
        String formattedTime = dateFormat.format(Calendar.getInstance().getTime());
        result = service_name+ formattedTime;
        result += generateRandomString(5);

        return result;

    }
    @Override
    public BillerCoreTransactionRequest generateCoreZakatTransactionRequest(BillPaymentInput input) {
        BillerCoreTransactionRequest request = new BillerCoreTransactionRequest();
        request.setSenderWalletNumber(CommonConstant.formatNumber(input.getAccountNumber()));
        request.setReceiverCode(OfflinePayCode.ZAKAT_CODE.getValue());
        request.setTransactionReferenceId(generateTransactionReferenceId(input.getKey3()));
        request.setTransactionType(TransactionType.ZAKAT_CODE.getValue());
        request.setChannel("app");
        request.setAmount(input.getKey2());
        request.setPin(input.getPin());
        request.setPurpose(input.getKey7());
        return request;
    }
}
