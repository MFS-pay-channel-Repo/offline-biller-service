package com.offline.billerservice.service;

import com.offline.billerservice.domain.BillerInfo;
import com.offline.billerservice.dto.BillPaymentInput;
import com.offline.billerservice.dto.BillPaymentResponse;
import com.offline.billerservice.dto.BillerCorePaymentResponse;
import com.offline.billerservice.dto.BillerCoreTransactionRequest;
import org.springframework.stereotype.Service;

@Service
public interface BillerInfoService {
//    public void saveBillerInfoLog(BillerInfo billerInfo);
    public BillPaymentResponse makePayment(BillPaymentInput input);
    public BillerCorePaymentResponse getPaymentResponse(BillPaymentInput input);
    public BillerCoreTransactionRequest generateCoreTransactionRequestFromInput(BillPaymentInput input);
}
