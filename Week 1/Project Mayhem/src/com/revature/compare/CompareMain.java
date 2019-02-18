package com.revature.compare;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CompareMain {

	public static void main(String[] args) {
		List<Student> studentList = new ArrayList<Student>();
		studentList.addAll(Arrays.asList(
				new Student[] {
						new Student(15,"Matt", 7.22),
						new Student(78, "Sloan", 2.5),
						new Student(21, "Noel", 3.2),
						new Student(1, "David", 0.4),
						new Student(16, "Freddie", 2.9),
						new Student(80, "Miguel", 92),
						new Student(34, "JJ", 2.91),
						new Student(55, "Mark", 6.56)
				}	)	);
			System.out.println("Original List");
			for (Student s:studentList) {
				System.out.println(s);
			}
		System.out.println("============");
		Collections.sort(studentList);
		System.out.println("Sorted by StudentID");
		for (Student s:studentList) {
			System.out.println(s);
		}
		System.out.println("============");
		Collections.sort(studentList, new StudentComparator());
		System.out.println("Sorted by GPA: ");
		for (Student s:studentList) {
			System.out.println(s);
		}
		System.out.println("============");
		System.out.println("Sort by Label w/ Lambda");
		Collections.sort(studentList, (arg0,arg1)
				->{
					return arg0.getLabel().compareTo(arg1.getLabel());
				}
				);
		for (Student s:studentList) {
			System.out.println(s);
		}
	}

}
