package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Flashcard;
import com.revature.client.FlashcardClient;

@RestController
public class FlashcardClientController {
	
	private FlashcardClient flashcardClient;
	
	@Autowired // constructor injection
	public FlashcardClientController(FlashcardClient flashcardClient) {
		this.flashcardClient = flashcardClient;
	}
	
	@GetMapping("/clientTest")
	public ResponseEntity<List<Flashcard>> testOutGettingFlashcards() {
		return new ResponseEntity<List<Flashcard>>(this.flashcardClient.getFlashcards(), HttpStatus.OK);
	}
	

}
