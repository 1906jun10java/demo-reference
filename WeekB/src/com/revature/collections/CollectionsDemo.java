package com.revature.collections;

import java.util.ArrayList;
import java.util.List;

import com.revature.model.*; // importing all classes/interfaces in com.revature.model package

public class CollectionsDemo {
	
	public static void main(String[] args) {
		
		funWithLists();
		
	}
	
	public static void funWithLists() {
		
		/*
		 * List:
		 * 
		 * -Lists are ordered Collections
		 * -Duplicate elements are allowed
		 * 
		 * Some additional List features (beyond methods defined in Collection):
		 * -Positional access: access/manipulate elements based on position in List
		 * -Search: search for an element and retrieve its numerical position
		 * -Iteration: listIterator() expands on capabilities of Iterator
		 * -Range-view: access/manipulate subsets of the List
		 * 
		 * https://docs.oracle.com/javase/8/docs/api/java/util/List.html
		 *
		 */
		
		List<User> users = new ArrayList<>(); 
		// generally want to use the supertype of whatever Collection 
		// User is the type of each element in the List, replaces the generic type parameter in List<E> specification
		
		User u1 = new User("Gandalf", "Grey", "mithrandir", "you_shall_not");
		User u2 = new User("Paul", "Hewson", "bono", "u2RuleZ");
		User u3 = new User("David", "Tennant", "doc10", "tardis");
		
		users.add(u1);
		users.add(u2);
		users.add(u3);
		
		// we have a addAll() method, but it takes a Collection
		
		// duplicates are allowed, so the following should work:
		users.add(u1);
		
		for (User user : users) {
			System.out.println(user);
		}
		
		
		
		
	}

}


