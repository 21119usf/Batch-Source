package com.revature.question7;

import java.util.Comparator;

public class SortByDept implements Comparator<Employee>{		//Sorting by department using compareTo
	public int compare (Employee o1, Employee o2)
	{
		return o1.department.compareTo(o2.department);
	}
}
