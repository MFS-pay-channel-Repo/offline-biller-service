package com.offline.billerservice.service;

import com.offline.billerservice.domain.Madrasa;
import org.springframework.stereotype.Service;

@Service
public interface MadrasaService {
    Madrasa save(Madrasa madrasa);
}
