package com.revature;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.Author;
import com.revature.beans.Flashcard;
import com.revature.beans.FlashcardTopic;

public class Driver {

	public static void main(String[] args) {
		
		// access ApplicationContext, the IoC container
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		
		// obtain an instance of Author bean from AC
		Author a = (Author) (ac).getBean("author");
		System.out.println(a);
		
		// obtain an instance of Flashcard bean from AC
		Flashcard f = (Flashcard) (ac).getBean("componentScannedFlashcard");
		f.setQuestion("What is the answer to life, the universe, and everything?");
		f.setAnswer("42");
		f.setId(6);
		f.setTopic(FlashcardTopic.THE_BEATLES);
		System.out.println(f);
		
		// always close the AC when you're finished
		ac.close();

	}

}
