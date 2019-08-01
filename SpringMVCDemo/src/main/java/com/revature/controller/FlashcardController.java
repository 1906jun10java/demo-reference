package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Flashcard;
import com.revature.service.FlashcardService;

@RestController
@RequestMapping(value="/flashcard")
public class FlashcardController {
	
	private FlashcardService flashcardService;
	
	@Autowired // setter injection
	public void setFlashcardService(FlashcardService flashcardService) {
		this.flashcardService = flashcardService;
	}
	
	@RequestMapping(value="/all", method=RequestMethod.GET)
	public ResponseEntity<List<Flashcard>> getAllFlashcards() {
		return new ResponseEntity<>(flashcardService.allFlashcards(), HttpStatus.OK);
	}
	
	@PostMapping // we could also do RequestMapping with RequestMethod.POST
	public ResponseEntity<String> addFlashcard(@RequestBody Flashcard flashcard) {
		ResponseEntity<String> resp = null;
		try {
			flashcardService.createFlashcard(flashcard);
			resp = new ResponseEntity<>("FLASHCARD CREATED SUCCESSFULLY", HttpStatus.OK);
		} catch (Exception e) {
			resp = new ResponseEntity<>("FAILED TO CREATE FLASHCARD", HttpStatus.BAD_REQUEST);
		}
		return resp;
	}

}
