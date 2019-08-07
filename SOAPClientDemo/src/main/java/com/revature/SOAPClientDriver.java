package com.revature;

import java.io.PrintWriter;
import java.util.List;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import com.revature.beans.Author;
import com.revature.beans.Book;
import com.revature.beans.Genre;
import com.revature.services.LibraryService;

public class SOAPClientDriver {
	
	private static final String SERVICE_URL = "http://localhost:8083/SOAPServiceDemo/library";

	public static void main(String[] args) {

		// set up a factory to create a proxy for the service
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setServiceClass(LibraryService.class); // what methods are available?
		factory.setAddress(SERVICE_URL); // where is my endpoint?
		
		// set up interceptors to log incoming and outgoing messages
		LoggingInInterceptor inInterceptor = new LoggingInInterceptor(new PrintWriter(System.out));
		LoggingOutInterceptor outInterceptor = new LoggingOutInterceptor(new PrintWriter(System.out));
		
		// add interceptors to the factory
		factory.getInInterceptors().add(inInterceptor);
		factory.getOutInterceptors().add(outInterceptor);
		
		// create an instance of the LibraryService using implementation provided by SOAP
		LibraryService library = (LibraryService) factory.create();
		
		// test out operations
		System.out.println("Invoking LibraryService.getAllBooks()... ");
		List<Book> bookList = library.getAllBooks(); // this actually makes a call to the service at SERVICE_URL
		for (Book book : bookList) System.out.println(book);
		
		System.out.println("Invoking LibraryService.addBook()..");
		Book book = new Book("Spring Tool Suite", new Genre("Humor"));
		book.getAuthors().add(new Author("George R. R.", "Martin"));
		try {
			System.out.println(library.addBook(book)); // make the call!
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Invoking LibraryService.addBook()..");
		Book book2 = new Book("Twilight", new Genre("YA"));
		book2.getAuthors().add(new Author("George R. R.", "Martin"));
		try {
			System.out.println(library.addBook(book2)); // make the call!
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Invoking LibraryService.fakeMethod()");
		library.fakeMethod();


	}

}
