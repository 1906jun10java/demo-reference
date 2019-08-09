package com.rev.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class myController {

	//@Value will grab a value from the configuration or create it if it
	//doesnt exist
	@Value("${message: You dont have a message}")
	private String configMessage;
	
	@GetMapping("/api")
	public String getTheMessage() {
		return configMessage;
	}
}
