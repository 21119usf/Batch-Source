package com.revature.hw1prob7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CompareMain {
	public static void main(String[] args) {
		
		List<Employee> employeeList = new ArrayList<Employee>();
		employeeList.addAll(Arrays.asList(
				new Employee [] {
						new Employee(67,"Karl","SuperTrooper"),
						new Employee(15,"Kevin McLovin", "Police")
				}));
		System.out.println("Original List");
		for (Employee s:employeeList) {
			System.out.println(s);
		}
		
		System.out.println("================");
		Collections.sort(employeeList, new EmployeeComparator());
		System.out.println("Sorted by age:");
		for (Employee s:employeeList) {
			System.out.println(s);
		}
		
		System.out.println("================");
		//Sort by name with lambda
		Collections.sort(employeeList,(arg0,arg1)
				->{return arg0.getName().compareTo(arg1.getName());}
				);
		System.out.println("Sorted by name:");
		for (Employee s:employeeList) {
			System.out.println(s);
		}
		
		System.out.println("================");
		//Sort by name with lambda
		Collections.sort(employeeList,(arg0,arg1)
				->{return arg0.getDepartment().compareTo(arg1.getDepartment());}
				);
		System.out.println("Sorted by department:");
		for (Employee s:employeeList) {
			System.out.println(s);
		}
		
		
	}

}
