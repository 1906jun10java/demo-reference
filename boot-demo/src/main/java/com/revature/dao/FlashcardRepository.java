package com.revature.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.Flashcard;
import com.revature.beans.FlashcardTopic;

@Repository
public interface FlashcardRepository extends JpaRepository<Flashcard, Integer> {
	
	// other choices besides JpaRepository as parent type - also have CrudRepository (supertype)
	// and PagingAndSortingRepository

	// method name pattern matching
	public List<Flashcard> getByTopic(FlashcardTopic ft);
}
