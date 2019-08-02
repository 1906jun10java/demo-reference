package com.revature.dao;

import java.util.List;

import com.revature.beans.Flashcard;

public interface FlashcardDAO {
	
	public List<Flashcard> allFlashcards();
	public Flashcard getFlashcardById(int id);
	public void createFlashcard(Flashcard flashcard);

}
