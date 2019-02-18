//Q7. Sort two employees based on their name, department, and age using the
//Comparator interface.

package com.revature.cja;

import java.util.Comparator;

public class SortEmployeeByAge implements Comparator<Employee> {

	// method to compare employee by age
	@Override
	public int compare(Employee arg0, Employee arg1) {
		return arg0.getAge() - arg1.getAge();
	}

}
