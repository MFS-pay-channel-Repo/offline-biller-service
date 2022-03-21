package com.offline.billerservice;

import com.offline.billerservice.service.BillerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class BillerServiceApplication {

	@Autowired
	BillerInfoService billerInfoService;
	public static void main(String[] args) {
		SpringApplication.run(BillerServiceApplication.class, args);
//		generateTransactionReferenceId

	}

}
