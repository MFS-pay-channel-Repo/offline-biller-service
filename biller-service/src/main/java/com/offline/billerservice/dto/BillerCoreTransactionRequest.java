package com.offline.billerservice.dto;

import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

import javax.validation.constraints.NotEmpty;
import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class BillerCoreTransactionRequest {
    private String SenderWalletNumber;
    private String ReceiverCode;
    private String TransactionReferenceId;
    private String TransactionType;
    private String Channel;
    private String Amount;
    private String pin;
    private String purpose;
}
