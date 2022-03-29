package com.offline.billerservice.dto;

import lombok.Data;

@Data
public class MadrasaResponse {
    private Long id;
    private String uuid;
    private String code;
    private String madrasa_name;
    private String madrasa_type;
    private String established_date;
    private String eiin;
}
