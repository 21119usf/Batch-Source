package com.revature.cja;

import java.util.Comparator;

public class SortEmployeeByName implements Comparator<Employee> {

	@Override
	public int compare(Employee arg0, Employee arg1) {
		return arg0.getName().compareTo(arg1.getName());
	}
}
