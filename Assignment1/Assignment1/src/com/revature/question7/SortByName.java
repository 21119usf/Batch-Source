package com.revature.question7;

import java.util.Comparator;

public class SortByName implements Comparator<Employee>{	//Sorting by name using compareTo
	public int compare (Employee o1, Employee o2)
	{
		return o1.name.compareTo(o2.name);
	}
}
