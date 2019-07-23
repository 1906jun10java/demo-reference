package com.revature;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.revature.beans.Book;
import com.revature.util.ConnectionUtil;

public class Driver {
	
	public static void main(String[] args) {
		// use this to get Sessions, which will do most of the work
		SessionFactory sf = ConnectionUtil.getSessionFactory();
		Session s = sf.openSession();
		System.out.println(s.getStatistics());
		Transaction tx = s.beginTransaction();
		s.save(new Book("Percy Jackson and the Lightning Thief", "Fantasy", "Ric", "Riordan"));
		tx.commit();
		s.close();
	
	}

}
