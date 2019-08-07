package com.revature.services;

import java.util.List;

import javax.jws.WebService;

import com.revature.beans.Book;

// could go contract-first and generate this class and all attendant datatypes from the WSDL exposed by the service. 
// here in the client, we don't need to write an implementation. 

@WebService
public interface LibraryService {

	List<Book> getAllBooks();

	String addBook(Book book);
	
	void fakeMethod();

}
