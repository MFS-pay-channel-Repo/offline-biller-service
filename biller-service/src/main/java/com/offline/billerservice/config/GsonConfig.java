package com.offline.billerservice.config;

import com.google.gson.Gson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.Column;
import javax.validation.groups.ConvertGroup;

@Configuration
public class GsonConfig {
    @Bean
    public Gson GsonConfig(){return new Gson();}
}
