package com.revature.cja;

import java.util.Comparator;

public class SortEmployeeByAge implements Comparator<Employee> {

	@Override
	public int compare(Employee arg0, Employee arg1) {
		return arg0.getAge() - arg1.getAge();
	}

}
