package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.beans.Flashcard;
import com.revature.beans.FlashcardTopic;

@Service
public class FlashcardService {

	private List<Flashcard> flashcards = new ArrayList<>();

	public FlashcardService() {
		flashcards.add(new Flashcard(1, "what is the answer to life, the universe, and everything?", "42",
				FlashcardTopic.THE_BEATLES, null));
	}
	
	public List<Flashcard> allFlashcards() {
		return this.flashcards;
	}
	
	public void createFlashcard(Flashcard flashcard) {
		flashcards.add(flashcard);
	}

}
