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

    @Column(name="division_id")
    private Integer divisionId;

    @Column(name="district_id")
    private Integer districtId;

    @Column(name="thana_id")
    private Integer thanaId;

    @Column(name="area")
    private String area;

    @Column(name="madrasa_code")
    private String madrasaCode;

    @Column(name="madrasa_name")
    private String madrasaName;

    @Column(name="transaction_id")
    private String transactionId;

    @Column(name="insertion_time")
    private String insertionTime;
}
