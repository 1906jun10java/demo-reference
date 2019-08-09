package com.rev.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rev.model.AnimalSound;

@RestController
@RequestMapping("/sounds")
public class SoundController {

	
	@GetMapping("/getem")
	public AnimalSound getSound() {
		System.out.println("rawr");
		AnimalSound as=new AnimalSound("ringdingadingading",100.0);
		return as;
	}
}
