package com.rev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BootService3Application {

	public static void main(String[] args) {
		SpringApplication.run(BootService3Application.class, args);
	}

}
