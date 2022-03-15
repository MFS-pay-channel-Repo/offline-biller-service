package com.offline.billerservice.repository;

import com.offline.billerservice.domain.Zakat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface ZakatRepository extends JpaRepository<Zakat, BigInteger> {
}
