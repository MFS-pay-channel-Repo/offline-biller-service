package com.offline.billerservice.repository;

import com.offline.billerservice.domain.Madrasa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface MadrasaRepository extends JpaRepository<Madrasa, BigInteger> {

}
