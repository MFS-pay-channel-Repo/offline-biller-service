package com.offline.billerservice.controller;

import com.offline.billerservice.domain.Madrasa;
import com.offline.billerservice.service.MadrasaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class MadrasaController {
    @Autowired
    MadrasaService madrasaService;

    @PostMapping("/billing/offline/madrasa/add")
    public Madrasa saveMadrasa(@RequestBody Madrasa madrasa){
        return madrasaService.save(madrasa);
    }
}
