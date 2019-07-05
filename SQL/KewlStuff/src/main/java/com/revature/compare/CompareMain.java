package com.revature.compare;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CompareMain {

	public static void main(String[] args) {
		List<Student> studentList = new ArrayList<Student>();
		studentList.addAll(Arrays.asList(new Student[] { new Student(12, "Matt", 9.3), new Student(74, "Shyam", 2.4),
				new Student(87, "Jolie", 6.12), new Student(10, "Cody", .2), new Student(44, "Kendrick", 100.5),
				new Student(6, "Ben", 2.3), new Student(12, "Mustafa", 5.0), }));
		System.out.println("Original List");
		for (Student s : studentList) {
			System.out.println(s);
		}
		System.out.println("Sort by Label w/ Lambda");
		Collections.sort(studentList, (arg0, arg1) -> {
			return arg0.getLabel().compareTo(arg1.getLabel());
		}

		);
		for (Student s : studentList) {
			System.out.println(s);
		}
		System.out.println("Compare using normal interface convention");
		Collections.sort(studentList);
		for (Student s : studentList) {
			System.out.println(s);
		}
	}

}
