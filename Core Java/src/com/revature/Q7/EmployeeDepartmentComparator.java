package com.revature.Q7;

import java.util.Comparator;

public class EmployeeDepartmentComparator implements Comparator<Employee>{

	public EmployeeDepartmentComparator() {
		super();
	}

	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.getDepartment().compareTo(o2.getDepartment()) ;
	}
}
