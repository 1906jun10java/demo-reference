package com.rev.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.rev.model.AnimalSound;

@RestController
@RequestMapping("/api")
public class FakeServiceApp {
	
	//this allows a microservice to send a http request to a restful service
	RestTemplate rt = new RestTemplate();
	
	@GetMapping("/fetchsounds")
	@HystrixCommand(fallbackMethod="backupHolla")
	public AnimalSound holla() {
		System.out.println("holla rawr");
		AnimalSound as = rt.getForObject("http://localhost:8765/animalSoundsgoHolla/sounds/getem",
				AnimalSound.class);
		return as;
	}
	
	public AnimalSound backupHolla() {
		System.out.println("in the endgame now");
		AnimalSound as = new AnimalSound("whaaaaaaaaa", 4000000.0);
		return as;
	}
	
	
}
