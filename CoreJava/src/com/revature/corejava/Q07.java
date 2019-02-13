package com.revature.corejava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

// Class 
public class Q07 {
	static class Employee {
		private String name;
		private String department;
		private int age;
		
		Employee(String name, String department, int age) {
			this.name = name;
			this.department = department;
			this.age = age;
		}
		
		public String toString() {
			return this.name + " " + this.department + " " + this.age;
		}
	}
	
	// Compare Employee names
	static class SortByName implements Comparator<Employee> {
		public int compare(Employee a, Employee b) {
			return a.name.compareTo(b.name);
		}
	}
	
	// Compare Employee departments
	static class SortByDepartment implements Comparator<Employee> {
		public int compare(Employee a, Employee b) {
			return a.department.compareTo(b.department);
		}
	}
	
	// Compare Employee age
	static class SortByAge implements Comparator<Employee> {
		public int compare(Employee a, Employee b) {
			return a.age - b.age;
		}
	}
	
	// Main
	public static void main(String[] args) {
		ArrayList<Employee> al = new ArrayList<Employee>();
		al.add(new Employee("John", "IT", 43));
		al.add(new Employee("Eric", "Sales", 32));
		
		// Print unsorted
		for (int i=0; i<al.size(); i++) {
			System.out.println(al.get(i));
		}
		System.out.println();
		
		// Print sorted by name
		Collections.sort(al, new SortByName());
		for (int i=0; i<al.size(); i++) {
			System.out.println(al.get(i));
		}
		System.out.println();
		
		// Print sorted by department
		Collections.sort(al, new SortByDepartment());
		for (int i=0; i<al.size(); i++) {
			System.out.println(al.get(i));
		}
		System.out.println();
		
		// Print sorted by age
		Collections.sort(al, new SortByAge());
		for (int i=0; i<al.size(); i++) {
			System.out.println(al.get(i));
		}
		System.out.println();
	}
}
