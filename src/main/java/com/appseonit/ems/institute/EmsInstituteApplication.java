package com.appseonit.ems.institute;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EmsInstituteApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmsInstituteApplication.class, args);
	}

}
