package com.revature.cja;

import java.util.Comparator;

public class SortEmployeeByDepartment implements Comparator<Employee> {

	@Override
	public int compare(Employee arg0, Employee arg1) {
		return arg0.getDepartment().compareTo(arg1.getDepartment());
	}

}
