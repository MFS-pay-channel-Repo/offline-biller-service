package com.offline.billerservice.service;

//import com.google.gson.JsonObject;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.offline.billerservice.domain.BillerInfo;
import com.offline.billerservice.dto.*;
import com.offline.billerservice.gateway.ApiManagerGateway;
import com.offline.billerservice.repository.BillerInfoRepository;
//import jdk.nashorn.internal.parser.JSONParser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

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
       BillerCorePaymentResponse response = getPaymentResponse(input);
       BillPaymentResponse paymentResponse = new BillPaymentResponse();
        return paymentResponse;
    }

    @Override
    public BillerCorePaymentResponse getPaymentResponse(BillPaymentInput input) {

        BillerCoreTransactionRequest request = generateCoreTransactionRequestFromInput(input);
        log.info("{}",request);
        logBillerInfo(request,input.getBillerCode(),input.getKey1());
        BillerCorePaymentResponse response = apiManagerGateway.paymentUnified(request);
        logBillerInfo(response,input.getBillerCode(),input.getKey1());
        log.info("{}",response);
        return response;
    }

    @Override
    public BillerCoreTransactionRequest generateCoreTransactionRequestFromInput(BillPaymentInput input) {
        BillerCoreTransactionRequest request = new BillerCoreTransactionRequest();
        request.setTransactionTypeKeyWord("MPAY");
        request.setAmount(input.getFee());
        request.setFromAccount(input.getAccountNumber());
        //key 1 to Account
        request.setToAccount(input.getKey1());
        request.setPIN(input.getPin());
        request.setChannel(input.getPaymentChannel());
        ArrayList<TransactionKeyValue> transactionRecordReplacerValues = new ArrayList<TransactionKeyValue>();
        TransactionKeyValue transactionKeyValueForUserNumber = new TransactionKeyValue("ToUserNumber",input.getKey1());
        transactionRecordReplacerValues.add(transactionKeyValueForUserNumber);
        //Purpose key 2
        TransactionKeyValue transactionKeyValueForPurpose = new TransactionKeyValue("Purpose",input.getKey2());
        transactionRecordReplacerValues.add(transactionKeyValueForPurpose);
        return request;
    }
}
