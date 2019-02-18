package com.revature.q7;

import java.util.Comparator;

public class SortByName implements Comparator<Employee>{

	@Override
	public int compare(Employee employ1, Employee employ2) {
		// sorting by name
		return employ1.getName().compareTo(employ2.getName());
	}

}
