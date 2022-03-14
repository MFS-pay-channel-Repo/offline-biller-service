package com.offline.billerservice.config;

import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
public class OkHttpClientConfig {
    @Value("${ok.http.connect-timeout}")
    private Integer connectTimeout;
    @Value("${ok.http.read-timeout}")
    private Integer readTimeout;
    @Value("${ok.http.write-timeout}")
    private Integer writeTimeout;

    @Bean
    public OkHttpClient OkHttpClientConfig(){
        return new OkHttpClient.Builder()
                .connectTimeout(connectTimeout, TimeUnit.SECONDS)
                .build();
    }
}
