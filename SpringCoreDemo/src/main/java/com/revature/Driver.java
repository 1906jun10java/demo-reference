package com.revature;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.Author;
import com.revature.beans.Flashcard;
import com.revature.beans.FlashcardTopic;

public class Driver {

	public static void main(String[] args) {
		
		// access ApplicationContext, the IoC container
		// eagerly instantiates and initializes all singleton-scoped beans HERE
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		
		// obtain an instance of Author bean from AC
		Author a = (Author) ac.getBean("author");
		System.out.println(a);
		
		// obtain an instance of Flashcard bean from AC
		// AC will read Flashcard bean definition and create an instance of Flashcard based on the bean recipe
		Flashcard f = (Flashcard) (ac).getBean("componentScannedFlashcard");
		f.setQuestion("What is the answer to life, the universe, and everything?");
		f.setAnswer("42");
		f.setId(6);
		f.setTopic(FlashcardTopic.THE_BEATLES);
		
		// request another Flashcard bean
		Flashcard f2 = (Flashcard) (ac).getBean("componentScannedFlashcard");
		f2.setQuestion("What is Java?");
		f2.setAnswer("42");
		f2.setId(8);
		f2.setTopic(FlashcardTopic.CODING);
		
		System.out.println(f);
		System.out.println(f2);
		
		// are the Authors the same object?
		// yes
		
		a.setFirstName("Patrick");
		
		System.out.println(f);
		System.out.println(f2);
		
		ac.getBean("lifecycleBean"); // default name for bean when using stereotypes is class name, but camelCase.
		
		// always close the AC when you're finished
		ac.close();

	}

}
