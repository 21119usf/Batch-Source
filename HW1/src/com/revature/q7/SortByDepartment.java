package com.revature.q7;

import java.util.Comparator;

public class SortByDepartment implements Comparator<Employee>{

	@Override
	public int compare(Employee employ1, Employee employ2) {
		// compare departments
		return employ1.getDepartment().compareTo(employ2.getDepartment());
	}

}
