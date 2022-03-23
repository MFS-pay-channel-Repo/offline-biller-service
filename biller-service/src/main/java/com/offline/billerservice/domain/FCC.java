package com.offline.billerservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "offline_fcc")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FCC {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private BigInteger id;

    @Column(name="institution_code")
    private String institutionCode;

    @Column(name="fee_type")
    private Integer feeType;

    @Column(name="remarks")
    private String remarks;

    @Column(name="transaction_id")
    private String transactionId;

    @Column(name = "insertion_time")
    private String insertionTime;
}
