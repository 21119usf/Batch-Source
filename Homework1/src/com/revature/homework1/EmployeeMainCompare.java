package com.revature.homework1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;








public class EmployeeMainCompare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Employee> employeeList = new ArrayList<Employee>();
		
		employeeList.addAll(Arrays.asList(new Employee [] {
				new Employee("Freddie","Management",27),
				new Employee("Noel","Toys",24),
				new Employee("Jake","Brooms",30)
				
		}));
		
		System.out.println("Original list: ");
		for(Employee e :employeeList) {
			System.out.println(e);
		}
		
		System.out.println("==========");
		Collections.sort(employeeList, new Employee());
		System.out.println("age");
		for(Employee e: employeeList) {
			System.out.println(e);
		}
		
		System.out.println("=======");
		System.out.println("Sorted by Department");
		Collections.sort(employeeList, (arg0,arg1)
		->{return arg0.getDepartment().compareTo(arg1.getDepartment());});
		for(Employee e: employeeList) {
			System.out.println(e);
		}
		
		System.out.println("=======");
		System.out.println("Sorted by Name");
		Collections.sort(employeeList, (arg0,arg1)
		->{return arg0.getName().compareTo(arg1.getName());});
		for(Employee e: employeeList) {
			System.out.println(e);
		}
		
	}

}
