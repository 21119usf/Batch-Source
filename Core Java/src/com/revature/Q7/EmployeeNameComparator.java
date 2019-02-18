package com.revature.Q7;

import java.util.Comparator;

public class EmployeeNameComparator implements Comparator<Employee>{

	
	public EmployeeNameComparator() {
		super();
	}

	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.getName().compareTo(o2.getName());
	}

}
