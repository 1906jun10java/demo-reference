package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import com.revature.beans.Author;
import com.revature.beans.Book;
import com.revature.beans.Genre;
import com.revature.exception.LibraryFullException;

@WebService(endpointInterface="com.revature.services.LibraryService")
public class LibraryServiceImpl implements LibraryService {
	
	private static List<Book> library = new ArrayList<>();
	
	static {
		Genre g1 = new Genre("Fantasy");
		Genre g2 = new Genre("Home Improvement");
		Author a1 = new Author("Tim", "Allen");
		Author a2 = new Author("J.R.R", "Tolkien");
		Book b1 = new Book("The Two Towers: Behind the Scenes", g2);
		b1.getAuthors().add(a1);
		b1.getAuthors().add(a2);
		Book b2 = new Book("The Two Towers", g1);
		b2.getAuthors().add(a2);
		Book b3 = new Book("The Santa Clause 4: Race to Mordor", g1);
		b3.getAuthors().add(a1);
		b3.getAuthors().add(a2);
		library.add(b1);
		library.add(b2);
		library.add(b3);
	}

	@Override
	public List<Book> getAllBooks() {
		return library;
	}

	@Override
	public String addBook(Book book) throws LibraryFullException {
		if(book.getTitle().equals("Twilight")) {
			throw new LibraryFullException("Library full, cannot add book.");
		}
		library.add(book);
		return "successfully added " + book.getTitle();
	}

}
