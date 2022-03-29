package com.offline.billerservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "offline_madrasa")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Madrasa {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private BigInteger id;

    @Column(name="madrasa_name")
    private String madrasaName;

    @Column(name="madrasa_code")
    private String madrasaCode;

    @Column(name="madrasa_type")
    private String madrasaType;

    @Column(name="madrasa_merchant_no")
    private String madrasaMerchantNumber;

    @Column(name="madrasa_address")
    private String madrasaAddress;

    @Column(name="district")
    private String district;

    @Column(name="thana")
    private String thana;

    @Column(name="union_")
    private String union;

    @Column(name="area")
    private String area;

    @Column(name="established_date")
    private String establishedDate;

    @Column(name="eiin")
    private String eiin;
}
