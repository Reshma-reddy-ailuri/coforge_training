package com.coforge.ems;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

// starting point of application
// this is the annotation to specify that this is your main class.
@SpringBootApplication 
@EnableDiscoveryClient
@EnableFeignClients 
public class SbEmsApplication { //Entry point

	public static void main(String[] args) {
		SpringApplication.run(SbEmsApplication.class, args);
	}

}
