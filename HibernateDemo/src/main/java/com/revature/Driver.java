package com.revature;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.revature.beans.Book;
import com.revature.dao.BookDao;
import com.revature.dao.BookDaoImpl;
import com.revature.util.ConnectionUtil;

public class Driver {

	public static void main(String[] args) {

		// use this to get Sessions, which will do most of the work
		/*
		 * SessionFactory sf = ConnectionUtil.getSessionFactory(); Session s =
		 * sf.openSession(); System.out.println(s.getStatistics()); Transaction tx =
		 * s.beginTransaction(); s.save(new
		 * Book("Percy Jackson and the Lightning Thief", "Fantasy", "Ric", "Riordan"));
		 * tx.commit(); s.close();
		 */

		SessionFactory sf = ConnectionUtil.getSessionFactory();
		funWithGetAndLoad(sf);
	}

	static void funWithGetAndLoad(SessionFactory sf) {
		Session s = sf.openSession();

		// get a Book we know that we have
		Book b = s.get(Book.class, 2);
		System.out.println(b);

		// get a Book we don't have
		Book b2 = s.get(Book.class, 57);
		System.out.println(b2);

		// load a Book we know that we have
		Book b3 = s.load(Book.class, 2);
		System.out.println(b3); // forcing initialization of lazily fetched object, now it's fully usable

		// load a Book we don't have - ObjectNotFoundException
		// Book b4 = s.load(Book.class, 57);
		// System.out.println(b4);
		
		// load a Book we know that we have, but don't initialize it
		Book b5 = s.load(Book.class, 3);

		s.close();
		
		// access b3?
		System.out.println(b3.getTitle());
		// this is fine!
		
		// access b5?
		System.out.println(b5.getTitle());
	}

	static void funWithDaos() {
		BookDao bd = new BookDaoImpl();

		// bd.addBook(new Book("The Count of Monte Cristo","Fiction",
		// "Alexandre","Dumas"));

		Book bookToUpdate = bd.getBookById(2);

		bookToUpdate.setTitle("Percy Jackson and the Goblet of Zeus");

		bd.updateBook(bookToUpdate);

		List<Book> bookList = bd.getAllBooks();
		for (Book b : bookList) {
			System.out.println(b);
		}

	}

}
