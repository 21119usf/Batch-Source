package com.revature.question7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//Q7. Sort two employees based on their name, department, and age using the Comparator interface.

public class QuestionSeven {

	public static void main(String[] args) {
		List<Employee> employeeList = new ArrayList<Employee>();			//used a similar setup to in-class example
		employeeList.addAll(Arrays.asList(
				new Employee[] {
						new Employee("Matt", "Janitorial", 30),				//two random employees
						new Employee("Austin", "Software Development",27)
				}	)	);
			System.out.println("Original List");
			for (Employee s:employeeList) {									//printing original list
				System.out.println(s);
			}
		System.out.println("============");
		Collections.sort(employeeList, new EmployeeComparator());			//calling EmployeeComparator to compare age
		System.out.println("Sorted by age: ");
		for (Employee s:employeeList) {
			System.out.println(s);
		}
		System.out.println("============");
		Collections.sort(employeeList, new SortByName());					//Calling SortByName to compare names
		System.out.println("Sorted by Name: ");
		for (Employee s:employeeList) {
			System.out.println(s);
		}
		System.out.println("============");
		Collections.sort(employeeList, new SortByDept());					//Calling SortByDept to compare departments
		System.out.println("Sorted by Department: ");
		for (Employee s:employeeList) {
			System.out.println(s);
		}
	}

}
