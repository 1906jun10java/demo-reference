package com.revature.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Vector;

import com.revature.model.User;

public class CollectionsDemo {

	public static void main(String[] args) {

		funWithIterator();

	}
	
	public static void funWithIterator() {
		
		// initialize a Collection (extends Iterable interface)
		Set<User> userSet = new HashSet<>();
		userSet.add(new User("Gandalf", "Grey", "mithrandir", "you_shall_not"));
		userSet.add(new User("Paul", "Hewson", "bono", "u2RuleZ"));
		userSet.add(new User("David", "Tennant", "doc10", "tardis"));
		
		/*
		 * Iterator:
		 * 
		 * -Iterable is an interface which is extended by Collection
		 * -Iterable provides methods for easy traversal of any concrete subtype
		 * 			-defines iterator() method, which return an Iterator
		 * -Iterator has methods .next(), .hasNext(), .remove()
		 * -using the Iterator allows us to safely remove elements in place and traverse multiple Collections at once
		 * 
		 * https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
		 */
		
		Iterator<User> userIterator = userSet.iterator();
		
		// use hasNext() method (returns a boolean) as the condition for a while loop
		while(userIterator.hasNext()) {
			User u = userIterator.next(); // next() returns the next element, and steps forward the position of the iterator
			// could use remove() to remove elements from the Collection (filtering a Collection)
			System.out.println(u);
		}
		
	}
	
	public static void funWithMaps() {
		
		/*
		 * Map:
		 * 
		 * -object which maps keys to values
		 * -no duplicate keys
		 * -every key may map to at most one value
		 * -most implementations allow keys to be null
		 * 
		 * https://docs.oracle.com/javase/8/docs/api/java/util/Map.html
		 */
		
		Map<String, String> credentialsMap =  new HashMap<>();
		credentialsMap.put("mithrandir", "you_shall_not");
		credentialsMap.put(null, ""); // is fine, as long as there is only one null key
		credentialsMap.put("bono", null); // null values are fine, any number of keys may have null values
		credentialsMap.put("bono2", null);
		credentialsMap.put("doc10", "tardis");
		
		// retrieve objects by their keys
		System.out.println(credentialsMap.get("doc10"));
		
		// iterate through the map
		for (Map.Entry<String, String> entry : credentialsMap.entrySet()) {
			System.out.println("Key: "+entry.getKey()+", Value: "+entry.getValue());
		}
	}
	
	public static void funWithQueues() {
		
		/*
		 * Queue:
		 * 
		 * -typically for holding elements while waiting to process them
		 * -provides methods for adding, removing, and, inspecting elements
		 * -two versions for each of these behaviors: one which throws an exception if the operation fails,
		 * and one which does not. 
		 * -FIFO (first-in, first-out, except for PriorityQueue, which uses a Comparator or elements' natural ordering
		 * -duplicates are allowed
		 * 
		 *  https://docs.oracle.com/javase/8/docs/api/java/util/Queue.html
		 */
		
		Queue<User> userQueue = new LinkedList<>();
		
		User u1 = new User("Gandalf", "Grey", "mithrandir", "you_shall_not");
		User u2 = new User("Paul", "Hewson", "bono", "u2RuleZ");
		User u3 = new User("David", "Tennant", "doc10", "tardis");

		userQueue.add(u1);
		userQueue.add(u2);
		userQueue.add(u3);
		userQueue.add(u1);
		
		while (userQueue.size() != 0) {
			System.out.println("Queue size: "+userQueue.size());
			System.out.println("Processing: "+ userQueue.poll()); // removes and returns head of queue
		}
		
	}
	
	public static void funWithSets() {
		
		/*
		 * Set:
		 * 
		 * -Sets are not ordered
		 * -Duplicate elements are not allowed
		 * -Two sets are equal if they have the same elements (enforced by equals() and hashcode() implementations)
		 * 
		 * https://docs.oracle.com/javase/8/docs/api/java/util/Set.html
		 */
		
		Set<User> userSet = new HashSet<>();
		User u1 = new User("Gandalf", "Grey", "mithrandir", "you_shall_not");
		User u2 = new User("Paul", "Hewson", "bono", "u2RuleZ");
		User u3 = new User("David", "Tennant", "doc10", "tardis");

		userSet.add(u1);
		userSet.add(u2);
		userSet.add(u3);
		
		// no duplicates... addition of duplicate elements will be ignored. 
		userSet.add(u1); // same object (according to ==) as an existing element
		
		User u4 = new User("David", "Tennant", "doc10", "tardis");
		userSet.add(u4); // different object (according to ==) with the same fields as an existing element
		
		// both are ignored, it's the .equals() comparison that's being used (equality, not identity)
		
		for (User user : userSet) {
			System.out.println(user);
		}
		
		// notice that insertion order is ignored! 
		
	}

	public static void funWithLists() {

		/*
		 * List:
		 * 
		 * -Lists are ordered Collections -Duplicate elements are allowed
		 * 
		 * Some additional List features (beyond methods defined in Collection):
		 * -Positional access: access/manipulate elements based on position in List
		 * -Search: search for an element and retrieve its numerical position
		 * -Iteration: listIterator() expands on capabilities of Iterator -Range-view:
		 * access/manipulate subsets of the List
		 * 
		 * https://docs.oracle.com/javase/8/docs/api/java/util/List.html
		 *
		 */

		List<User> users = new ArrayList<>();
		// generally want to use the supertype of whatever Collection
		// User is the type of each element in the List, replaces the generic type
		// parameter in List<E> specification

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

		System.out.println("Size of list: " + users.size());

		System.out.println("---------------------------------------------------------");

		// List of Integers
		List<Integer> integerList = new Vector<>();
		// must use wrapper class Integer
		// wrapper class - datatype which wraps around a primitive value
		// every primitive datatype has a corresponding wrapper class

		integerList.add(10); // implicitly converting from int (primitive) to Integer (Object). This is
								// called autoboxing
		integerList.add(-255);
		integerList.add(new Integer(9)); // this is NOT autoboxing!
		integerList.add(75);
		integerList.add(-12);

		System.out.println("integer list, in insertion order");

		for (Integer integer : integerList) {
			System.out.println(integer);
		}
		

		/*
		 * Collections utility class has static methods for operating on Collection
		 * objects.
		 * 
		 * sort() method:
		 * must be used with a Collection of Comparable elements
		 * (or be provided a Comparator for that datatype)
		 */
		Collections.sort(integerList);

		System.out.println("integer list, sorted");

		for (Integer integer : integerList) {
			System.out.println(integer);
		}
		
		System.out.println("---------------------------------------------------------");

	}

}
