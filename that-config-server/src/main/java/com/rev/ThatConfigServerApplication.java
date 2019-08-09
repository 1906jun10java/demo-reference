package com.rev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ThatConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThatConfigServerApplication.class, args);
	}

}
