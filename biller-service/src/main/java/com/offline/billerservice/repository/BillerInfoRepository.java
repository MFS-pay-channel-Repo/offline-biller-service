package com.offline.billerservice.repository;

import com.offline.billerservice.domain.BillerInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface BillerInfoRepository extends JpaRepository<BillerInfo, BigInteger> {
}
