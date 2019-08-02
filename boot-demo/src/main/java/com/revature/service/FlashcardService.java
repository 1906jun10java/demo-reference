package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Flashcard;
import com.revature.beans.FlashcardTopic;
import com.revature.dao.FlashcardRepository;

@Service
public class FlashcardService {

	private FlashcardRepository flashcardRepository;

	@Autowired
	public FlashcardService(FlashcardRepository flashcardRepository) {
		this.flashcardRepository = flashcardRepository;
	}
	
	public List<Flashcard> allFlashcards() {
		return this.flashcardRepository.findAll();
	}
	
	public Flashcard getFlashcardById(int id) {
		return this.flashcardRepository.getOne(id);
	}
	
	public void createFlashcard(Flashcard flashcard) {
		this.flashcardRepository.save(flashcard);
	}

	public List<Flashcard> getFlashcardsByTopics(FlashcardTopic topic) {
		return this.flashcardRepository.getByTopic(topic);
	}

}
