package com.revature.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.beans.Flashcard;

@Repository(value="flashcardDAO")
@Transactional
public class FlashcardDAOImpl implements FlashcardDAO {
	
	private SessionFactory sessionFactory;
	
	@Autowired //constructor injection
	public FlashcardDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Flashcard> allFlashcards() {
		Session s = sessionFactory.getCurrentSession();
		System.out.println("in Flashcard dao");
		return s.createQuery("from Flashcard").getResultList();
	}

	@Override
	public Flashcard getFlashcardById(int id) {
		return sessionFactory.getCurrentSession().get(Flashcard.class, id);
	}

	@Override
	public void createFlashcard(Flashcard flashcard) {
		sessionFactory.getCurrentSession().persist(flashcard);
	}

}
