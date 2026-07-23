package com.coforge.serviceregistery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SbMsaServiceRegisteryApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbMsaServiceRegisteryApplication.class, args);
	}

}
