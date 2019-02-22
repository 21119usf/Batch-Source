//Q7. Sort two employees based on their name, department, and age using the
//Comparator interface.

package com.revature.cja;

import java.util.Comparator;

public class SortEmployeeByDepartment implements Comparator<Employee> {

	// method to compare employees by department
	@Override
	public int compare(Employee arg0, Employee arg1) {
		return arg0.getDepartment().compareTo(arg1.getDepartment());
	}

}
