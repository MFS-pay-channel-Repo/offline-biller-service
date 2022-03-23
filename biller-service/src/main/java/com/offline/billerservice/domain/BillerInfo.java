package com.offline.billerservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Blob;

@Entity
@Table(name = "biller_info")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillerInfo {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private BigInteger id;

    @Column(name="biller_code")
    private String billerCode;

    @Column(name="biller_is_offline")
    private Boolean billerIsOffline;

    @Column(name="merchant_number")
    private String merchantNumber;

    @Column(name="biller_details")
    private String billerDetails;

    @Column(name="biller_subcategory")
    private String billerSubcategory;
}
