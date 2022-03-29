package com.offline.billerservice.service;

import com.offline.billerservice.domain.Madrasa;
import com.offline.billerservice.repository.MadrasaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MadrasaServiceImpl implements MadrasaService {
    @Autowired
    MadrasaRepository madrasaRepository;

    @Override
    public Madrasa save(Madrasa madrasa) {
        return madrasaRepository.save(madrasa);
    }
}
