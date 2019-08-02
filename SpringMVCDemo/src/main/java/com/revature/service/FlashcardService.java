package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Flashcard;
import com.revature.dao.FlashcardDAO;

@Service
public class FlashcardService {

	private FlashcardDAO flashcardDAO;

	@Autowired
	public FlashcardService(FlashcardDAO flashcardDAO) {
		this.flashcardDAO = flashcardDAO;
	}
	
	public List<Flashcard> allFlashcards() {
		return this.flashcardDAO.allFlashcards();
	}
	
	public Flashcard getFlashcardById(int id) {
		return this.flashcardDAO.getFlashcardById(id);
	}
	
	public void createFlashcard(Flashcard flashcard) {
		this.flashcardDAO.createFlashcard(flashcard);
	}

}
