package com.offline.billerservice.service;

import com.offline.billerservice.dao.EntityInfo;
import com.offline.billerservice.dto.MadrasaRequest;
import com.offline.billerservice.dto.MadrasaResponse;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface UtilityService {
    public EntityInfo[] getDistricts();
    public EntityInfo[] getThanas(String district_name);
    public EntityInfo[] getUnions(String thana_name);
    public EntityInfo[] getArea(String union);
    public MadrasaResponse[] getMadrasaList(MadrasaRequest madrasaRequest);
}
