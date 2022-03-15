package com.offline.billerservice.repository;

import com.offline.billerservice.domain.FCC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface FCCRepository extends JpaRepository<FCC, BigInteger> {
}
