package com.offline.billerservice.controller;

import com.offline.billerservice.dto.BillPaymentInput;
import com.offline.billerservice.dto.BillPaymentResponse;
import com.offline.billerservice.service.BillerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class BillerController {
    @Autowired
    BillerInfoService billerInfoService;

    @ResponseBody
    @PostMapping("/billing/offline/payment")
    public BillPaymentResponse billPaymentResponse(@Valid @RequestBody BillPaymentInput billPaymentInput){
        BillPaymentResponse response = new BillPaymentResponse();

        return response;
    }
}
