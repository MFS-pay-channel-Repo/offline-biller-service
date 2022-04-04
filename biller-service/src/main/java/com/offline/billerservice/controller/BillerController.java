package com.offline.billerservice.controller;

import com.offline.billerservice.dto.BillPaymentInput;
import com.offline.billerservice.dto.BillPaymentResponse;
import com.offline.billerservice.dto.MadrasaResponse;
import com.offline.billerservice.service.BillerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
public class BillerController {
    @Autowired
    BillerInfoService billerInfoService;

    @ResponseBody
    @GetMapping("/billing/offline/zakat")
    public MadrasaResponse getZakatList(){

        return null;
    }
    @ResponseBody
    @PostMapping("/billing/offline/payment")
    public BillPaymentResponse billPaymentResponse(@Valid @RequestBody BillPaymentInput billPaymentInput,
                                                   HttpServletRequest request){
        return billerInfoService.makePayment(billPaymentInput);
    }

//    @GetMapping("/billing/offline/transaction_fee")
//    pu


    @GetMapping("/test")
    public String testInfo(){
        return "test";
    }
}
