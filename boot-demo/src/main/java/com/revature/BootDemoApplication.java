package com.revature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient // another version, framework-independent, which is EnableDiscoveryClient
@SpringBootApplication
public class BootDemoApplication {
	
	// note: the base package for component scanning is the current one! 
	// @SpringBootApplication is a combination of several other annotations, including @Configuration and @ComponentScan
	
	public static void main(String[] args) {
		SpringApplication.run(BootDemoApplication.class, args);
	}

}
