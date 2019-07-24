package com.revature;

import java.util.List;

import com.revature.beans.Book;
import com.revature.dao.BookDao;
import com.revature.dao.BookDaoImpl;

public class Driver {
	
	public static void main(String[] args) {
		
		// use this to get Sessions, which will do most of the work
		/*SessionFactory sf = ConnectionUtil.getSessionFactory();
		Session s = sf.openSession();
		System.out.println(s.getStatistics());
		Transaction tx = s.beginTransaction();
		s.save(new Book("Percy Jackson and the Lightning Thief", "Fantasy", "Ric", "Riordan"));
		tx.commit();
		s.close();*/
		
		BookDao bd = new BookDaoImpl();
		
		//bd.addBook(new Book("The Count of Monte Cristo","Fiction", "Alexandre","Dumas"));
		
		Book bookToUpdate = bd.getBookById(2);
		
		bookToUpdate.setTitle("Percy Jackson and the Goblet of Zeus");
		
		bd.updateBook(bookToUpdate);
		
		List<Book> bookList = bd.getAllBooks();
		for(Book b : bookList) {
			System.out.println(b);
		}
	
	}

}
