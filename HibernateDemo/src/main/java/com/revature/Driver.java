package com.revature;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.revature.beans.Book;
import com.revature.beans.Genre;
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
		//funWithGetAndLoad(sf);
		//funWithSaveAndPersist(sf);
		//funWithUpdateAndMerge(sf);
		
		funWithMultiplicity(sf);
	}
	
	static void funWithMultiplicity(SessionFactory sf) {
		
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		
		Book b = new Book("A House for Mr. Biswas", new Genre("Fiction"), "V.S.", "Naipaul");
		s.persist(b);
		
		tx.commit();
		s.close();
		
		BookDao bd = new BookDaoImpl();
		for (Book b1 : bd.getAllBooks()) {
			System.out.println(b1);
		}
	}
	
	static void funWithUpdateAndMerge(SessionFactory sf) {
		Session s1 = sf.openSession();
		Transaction tx1 = s1.beginTransaction();
		
		// give it the persistent identity of a book I know exists (but this object is transient)
		Book b1 = new Book(14, "The Hobbit", new Genre("Fantasy"), "J.R.R.", "Tolkien");
		s1.update(b1);
		
		//Book b2 = new Book(47, "Not a Book", "Not a Genre", "Not that it", "Matters");
		//s1.update(b2);
		
		// merge will behave the same way here
		
		// get another persistent object
		Book b3 = s1.get(Book.class, 6);
		
		// transient object with duplicate id, try to "update" it.
		// NonUniqueObjectException 
		Book b4 = new Book(6, "title", new Genre("genre"), "author first", "author last");
		//s1.update(b4);
		
		// but if we used merge?
		// totally fine
		// b3 was already persistent, merge() copied values of b4 onto the persistent b3
		s1.merge(b4);
		
		tx1.commit();
		s1.close();
	}
	
	static void funWithSaveAndPersist(SessionFactory sf) {
		Session s1 = sf.openSession();
		Transaction tx1 = s1.beginTransaction();
		
		// immediately get generated id with save()
		int newId = (int) s1.save(new Book("The Silmarillion", new Genre("Fantasy"), "J.R.R.", "Tolkien"));
		System.out.println(newId);
		
		// just make the object persist
		Book b1 = new Book("The Hobbit", new Genre("Fantasy"), "J.R.R.", "Tolkien");
		s1.persist(b1);
		
		// b1 is now persistent 
		// automatic dirty checking will cause this to be updated in the database 
		b1.setTitle("The Fellowship of the Ring");
		
		tx1.commit();
		s1.close();
		
		// print out detached object
		System.out.println(b1);
		
		// open another session
		Session s2 = sf.openSession();
		Transaction tx2 = s2.beginTransaction();
		
		// b1 is now detached
		
		// try to save b1
		// this will create a new record with a different persistent identity (PK)
		s2.save(b1);
		
		// print out b1 after "saving" detached object - it's a new record
		System.out.println(b1);
		
		// try to persist b1
		s2.persist(b1);
		
		tx2.commit();
		s2.close();
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
		//System.out.println(b5.getTitle());
		// no!
		// LazyInitializationException
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
