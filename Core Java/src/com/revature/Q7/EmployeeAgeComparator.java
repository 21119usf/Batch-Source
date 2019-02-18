package com.revature.Q7;

import java.util.Comparator;

public class EmployeeAgeComparator implements Comparator<Employee>{

	public EmployeeAgeComparator() {
		super();
	}

	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.getAge() - o2.getAge();
	}

}
