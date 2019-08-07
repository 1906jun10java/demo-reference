package com.revature.services;

import java.util.List;

import javax.jws.WebService;

import com.revature.beans.Book;
import com.revature.exception.LibraryFullException;

@WebService
public interface LibraryService {
	
	List<Book> getAllBooks();
	String addBook(Book book) throws LibraryFullException;

}
