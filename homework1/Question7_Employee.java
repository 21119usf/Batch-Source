package com.revature.homework1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;;

public class Question7_Employee {
		String name;
		String department;
		Integer age;	
		
		public Question7_Employee(String name, String department, Integer age){
			this.name = name;
			this.department = department;
			this.age = age;;
		}
			
		
	public static void main(String[] args) {
		// create an arrayList for generics and object comparison
		ArrayList<Question7_Employee> employeeList = new ArrayList<Question7_Employee>();
		// add employees to the list
		employeeList.add(new Question7_Employee("dude", "FL", 26));
		employeeList.add(new Question7_Employee("gal", "MA", 20));
		employeeList.add(new Question7_Employee("miss", "PA", 33));
		employeeList.add(new Question7_Employee("mr", "VA", 12));
		
		// sort employees by Name
		System.out.println("---- Sorted By Name ----");
		//Perform the Sort
		Collections.sort(employeeList, new SortByName());
		for(Question7_Employee emp: employeeList) {
			System.out.println(emp.name + " " + emp.department+ " " + emp.age);
		}
		
		// sort employees by Department
		System.out.println();
		System.out.println("---- Sorted By Department ----");
		//Perform the Sort
		Collections.sort(employeeList, new SortByDepartment());
		
		for(Question7_Employee emp: employeeList) {
			System.out.println(emp.name + " " + emp.department+ " " + emp.age);
		}
		
		// sort employees by Age
		System.out.println();
		System.out.println("---- Sorted By Age ----");
		//Perform the Sort
		Collections.sort(employeeList, new SortByAge());
		for(Question7_Employee emp: employeeList) {
			System.out.println(emp.name + " " + emp.department+ " " + emp.age);
		}
		
	}

}

// Use Generics for implement sort method only once instead 3 times for each return type

class SortByAge implements Comparator<Question7_Employee>{
	// implement the Comparator Interface
	@Override
	public int compare(Question7_Employee o1, Question7_Employee o2) {
		return o1.age-o2.age;
	}
}

class SortByName implements Comparator<Question7_Employee>{

	@Override
	public int compare(Question7_Employee o1, Question7_Employee o2) {
		return o1.name.compareTo(o2.name);
	}
}

class SortByDepartment implements Comparator<Question7_Employee>{

	@Override
	public int compare(Question7_Employee o1, Question7_Employee o2) {
		return o1.department.compareTo(o2.department);
	}
}
