package com.offline.billerservice.service;

import com.offline.billerservice.dao.EntityInfo;
import com.offline.billerservice.dto.MadrasaRequest;
import com.offline.billerservice.dto.MadrasaResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Tuple;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class UtilityServiceImpl implements UtilityService{
    @Autowired
    EntityManager entityManager;

    @Override
    public EntityInfo[] getDistricts() {
        List<EntityInfo> entityInfos = new ArrayList<EntityInfo>();
        List<Tuple>  resultList= entityManager.createNativeQuery("SELECT distinct(district) from offline_madrasa",Tuple.class)
                .getResultList();
        Long cnt = Long.valueOf(0);
        for(Tuple object: resultList){
            EntityInfo entityInfo = new EntityInfo();
            entityInfo.setId(++cnt);
            entityInfo.setUuid(UUID.randomUUID().toString());
            entityInfo.setName(object.get("district").toString());
            entityInfos.add(entityInfo);
        }
        EntityInfo[] entityResults = new EntityInfo[entityInfos.size()];
        entityInfos.toArray(entityResults);
        return entityResults;
    }

    @Override
    public EntityInfo[] getThanas(String district_name) {
        List<EntityInfo> entityInfos = new ArrayList<EntityInfo>();
        List<Tuple> resultList = entityManager.createNativeQuery("SELECT distinct(thana) as thana from offline_madrasa\n" +
                "where district ='"+district_name+"'",Tuple.class)
                .getResultList();
        Long cnt = Long.valueOf(0);
        for(Tuple object: resultList){
            EntityInfo entityInfo = new EntityInfo();
            entityInfo.setId(++cnt);
            entityInfo.setUuid(UUID.randomUUID().toString());
            entityInfo.setName(object.get("thana").toString());
            entityInfos.add(entityInfo);
        }
        EntityInfo[] entityResults = new EntityInfo[entityInfos.size()];
        entityInfos.toArray(entityResults);
        return entityResults;
    }

    @Override
    public EntityInfo[] getUnions(String thana_name) {
        List<EntityInfo> entityInfos = new ArrayList<EntityInfo>();
        List<Tuple> resultList = entityManager.createNativeQuery("SELECT distinct(union_) from offline_madrasa\n" +
                "where thana ='"+thana_name+"'",Tuple.class)
                .getResultList();
        Long cnt = Long.valueOf(0);
        for(Tuple object: resultList){
            EntityInfo entityInfo = new EntityInfo();
            entityInfo.setId(++cnt);
            entityInfo.setUuid(UUID.randomUUID().toString());
            entityInfo.setName(object.get("union_").toString());
            entityInfos.add(entityInfo);
        }
        EntityInfo[] entityResults = new EntityInfo[entityInfos.size()];
        entityInfos.toArray(entityResults);
        return entityResults;
    }

    @Override
    public EntityInfo[] getArea(String union) {
        List<EntityInfo> entityInfos = new ArrayList<EntityInfo>();
        List<Tuple> resultList = entityManager.createNativeQuery("SELECT distinct(area) from offline_madrasa\n" +
                "where union_ ='"+union+"'",Tuple.class)
                .getResultList();
        Long cnt = Long.valueOf(0);
        for(Tuple object: resultList){
            EntityInfo entityInfo = new EntityInfo();
            entityInfo.setId(++cnt);
            entityInfo.setUuid(UUID.randomUUID().toString());
            entityInfo.setName(object.get("area").toString());
            entityInfos.add(entityInfo);
        }
        EntityInfo[] entityResults = new EntityInfo[entityInfos.size()];
        entityInfos.toArray(entityResults);
        return entityResults;
    }

    @Override
    public MadrasaResponse[] getMadrasaList(MadrasaRequest madrasaRequest) {
        List<MadrasaResponse> madrasaResponseList = new ArrayList<>();
        List<Tuple> resultList = entityManager.createNativeQuery("SELECT madrasa_code as madrasa_code," +
                "madrasa_name as madrasa_name,\n" +
                "madrasa_type as madrasa_type,\n"+
                "established_date as established_date,\n"+
                "eiin as eiin\n"+
                " from offline_madrasa\n" +
                "where area = '"+ madrasaRequest.getArea()+"' and thana='"+madrasaRequest.getThana()+"'",Tuple.class)
                .getResultList();
        Long cnt = Long.valueOf(0);
        for(Tuple tuple: resultList){
            MadrasaResponse madrasaResponse = new MadrasaResponse();
            log.debug("{}",tuple);
            madrasaResponse.setId(++cnt);
            madrasaResponse.setUuid(UUID.randomUUID().toString());
            madrasaResponse.setCode(tuple.get("madrasa_code").toString());
            madrasaResponse.setMadrasa_name(tuple.get("madrasa_name").toString());
            madrasaResponse.setMadrasa_type(tuple.get("madrasa_type").toString());
            madrasaResponse.setEstablished_date(tuple.get("established_date").toString());
            madrasaResponse.setEiin(tuple.get("eiin").toString());
            madrasaResponseList.add(madrasaResponse);
        }
        MadrasaResponse[] finalMadrasaResponse = new MadrasaResponse[madrasaResponseList.size()];
        madrasaResponseList.toArray(finalMadrasaResponse);
        return finalMadrasaResponse;
    }
}
