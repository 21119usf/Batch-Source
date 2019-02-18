package com.revature.q7;

import java.util.ArrayList;
import java.util.Collections;

public class Q7 {

	public static void main(String[] args) {
		
		//array of Employees
		ArrayList<Employee> employees = new ArrayList<Employee>();
		
		employees.add(new Employee("frank", 32, "dept5"));
		employees.add(new Employee("sindy", 22, "dept3"));
		
		// unsorted
		System.out.println("Unsorted"); 
        for (int i=0; i<employees.size(); i++) 
            System.out.println(employees.get(i));
        
        System.out.println("\n");
        
        //sort by age
        Collections.sort(employees, new SortByAge());
        
        System.out.println("Sorted by Age"); 
        for (int i=0; i<employees.size(); i++) 
            System.out.println(employees.get(i));
        
        System.out.println("\n");
        
        
        //sort by name
        Collections.sort(employees, new SortByName());
        
        System.out.println("Sorted by Name"); 
        for (int i=0; i<employees.size(); i++) 
            System.out.println(employees.get(i));
        
        System.out.println("\n");
        
        
        //sort by Departments
        Collections.sort(employees, new SortByDepartment());
        
        System.out.println("Sorted by Department"); 
        for (int i=0; i<employees.size(); i++) 
            System.out.println(employees.get(i));
	}

}
