package com.offline.billerservice.controller;

import com.offline.billerservice.dao.EntityInfo;
import com.offline.billerservice.dto.LocationRequestParam;
import com.offline.billerservice.dto.MadrasaRequest;
import com.offline.billerservice.dto.MadrasaResponse;
import com.offline.billerservice.service.UtilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UtilityController {

    @Autowired
    UtilityService utilityService;

    @PostMapping("/billing/offline/districts")
    public EntityInfo[] getDistricts(){
        return utilityService.getDistricts();
    }

    @PostMapping("/billing/offline/thanas")
    public EntityInfo[]  getThanas(@RequestBody LocationRequestParam locationRequestParam){
        return utilityService.getThanas(locationRequestParam.getRequested_param());
    }

    @PostMapping("/billing/offline/union")
    public EntityInfo[]  getUnions(@RequestBody LocationRequestParam locationRequestParam){
        return utilityService.getUnions(locationRequestParam.getRequested_param());
    }

    @PostMapping("/billing/offline/area")
    public EntityInfo[]  getAreas(@RequestBody LocationRequestParam locationRequestParam){
        return utilityService.getArea(locationRequestParam.getRequested_param());
    }

    @PostMapping("/billing/offline/madrasas")
    public MadrasaResponse[] getMadrasas(@RequestBody MadrasaRequest madrasaRequest){
        return utilityService.getMadrasaList(madrasaRequest);
    }
}
