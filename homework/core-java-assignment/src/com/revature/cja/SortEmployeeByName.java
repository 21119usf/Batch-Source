//Q7. Sort two employees based on their name, department, and age using the
//Comparator interface.

package com.revature.cja;

import java.util.Comparator;

public class SortEmployeeByName implements Comparator<Employee> {

	// method to compare employee by name
	@Override
	public int compare(Employee arg0, Employee arg1) {
		return arg0.getName().compareTo(arg1.getName());
	}
}
