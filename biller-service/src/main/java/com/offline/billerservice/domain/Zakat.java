package com.offline.billerservice.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "offline_zakat")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Zakat {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private BigInteger id;

    @Column(name="division_name")
    private String divisionName;

    @Column(name="district_name")
    private String districtName;

    @Column(name="thana_name")
    private String thanaName;

    @Column(name="union_name")
    private String unionName;

    @Column(name="area")
    private String area;

    @Column(name="madrasa_code")
    private String madrasaCode;

    @Column(name="madrasa_type")
    private String madrasaType;

    @Column(name="madrasa_name")
    private String madrasaName;

    @Column(name="transaction_id")
    private String transactionId;

    @Column(name="insertion_time")
    private String insertionTime;

    @Column(name="established_date")
    private String establishedDate;

    @Column(name="eiin")
    private String eiin;


}
