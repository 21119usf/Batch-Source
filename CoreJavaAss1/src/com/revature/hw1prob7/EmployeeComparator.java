package com.revature.hw1prob7;

import java.util.Comparator;

public class EmployeeComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		return (int)(o1.getAge() - o2.getAge());
	}

}
