package com.revature.Q7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Driver {

	public static void main(String[] args) {
		ArrayList<Employee> employees = new ArrayList<Employee>(2);		//Create arrayList of 2 employees
		employees.addAll(Arrays.asList(
			new Employee[] {
				new Employee("Mark","Finance",33),
				new Employee("Mildred","Customer Service",56)
				}));
		sortByName(employees);											//Sort employees arraylist by name and prints
		System.out.println("Sorted by name: ");	 						//Simple print
		printEmployees(employees);
		sortByDepartment(employees);									//Sort employees arraylist by department and prints
		System.out.println("Sorted by department:"); 					//Simple print
		printEmployees(employees);					
		sortByAge(employees);											//Sort employees arraylist by age and prints
		System.out.println("Sorted by age: ");
		printEmployees(employees);										//Simple print
		

	}
	
	public static void printEmployees(ArrayList<Employee> employees) {
		for(Employee e:employees) {
			System.out.println(e.toString());	
		}
	}

	/*sortByName
	 * Input	: ArrayList
	 * Output	: none
	 * Algo		: We sort arraylist by using Collections.sort passing
	 * 			  the arraylist and a comparator instance specific to sort by name.
	 * 			  This comparator class implements comparator interface.
	 * 			  When sort is called with our comparator instance it will sort based on
	 * 			  the order described in the comparator
	 */
	public static void sortByName(ArrayList<Employee> employees) {
		Collections.sort(employees, new EmployeeNameComparator());		
	}
	//same as sortByName but with Department comparator
	public static void sortByDepartment(ArrayList<Employee> employees) {
		Collections.sort(employees, new EmployeeDepartmentComparator());		
	}
	//same as sortByName but with Age comparator
	public static void sortByAge(ArrayList<Employee> employees) {
		Collections.sort(employees, new EmployeeAgeComparator());	
	}
	
	

}
