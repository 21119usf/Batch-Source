package com.revature.q7;

import java.util.Comparator;

public class SortByAge implements Comparator<Employee>{

	@Override
	public int compare(Employee employ1, Employee employ2) {
		//comparing age sorted by ascending order
		return employ1.getAge() - employ2.getAge();
	}

}
