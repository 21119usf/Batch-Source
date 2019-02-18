package com.revature.question7;

import java.util.Comparator;

public class EmployeeComparator implements Comparator<Employee> {	//implementing comparator
	@Override
	public int compare(Employee o1, Employee o2) {
		
		
		return (int)(o1.getAge()-o2.getAge());	//rearranges based on age (lowest to highest)
	}

	
}
