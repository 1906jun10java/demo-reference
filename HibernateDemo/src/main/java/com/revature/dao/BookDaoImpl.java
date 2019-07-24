package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.revature.beans.Book;
import com.revature.util.ConnectionUtil;

public class BookDaoImpl implements BookDao {
	
	private SessionFactory sf = ConnectionUtil.getSessionFactory();

	@Override
	public Book getBookById(int id) {
		Book b = null;
		try (Session s = sf.openSession()) {
			//Transaction tx = s.beginTransaction();
			b = s.get(Book.class, id); // CAN cast to book, but with this overloaded version it's not necessary.
			//tx.commit();
		}
		return b;
	}

	@Override
	public List<Book> getAllBooks() {
		List<Book> bookList = new ArrayList<>();
		// use a Query
		try(Session s = sf.openSession()) {
			// THIS IS HQL... REFERS TO JAVA CLASS Book
			bookList = s.createQuery("from Book").getResultList();
		}
		return bookList;
	}

	@Override
	public boolean addBook(Book book) {
		boolean added = false;
		try(Session s = sf.openSession()) {
			Transaction tx = s.beginTransaction();
			s.persist(book); // adds a new record, alternative to save() 
			tx.commit();
			added = true;
		}
		return added;
	}

	@Override
	public boolean updateBook(Book book) {
		boolean updated = false;
		try(Session s = sf.openSession()) {
			Transaction tx = s.beginTransaction();
			s.saveOrUpdate(book);
			tx.commit();
			updated = true;
		}
		return updated;
	}

	@Override
	public boolean deleteBook(Book book) {
		boolean deleted = false;
		try(Session s = sf.openSession()) {
			Transaction tx = s.beginTransaction();
			s.delete(book);
			tx.commit();
			deleted = true;
		}
		return deleted;
	}

}
