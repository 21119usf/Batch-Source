package com.revature.core.java.assignment.sorters;

import java.util.Comparator;

import com.revature.core.java.assignment.helpers.Employee;

public class SortByEmployeeAge implements Comparator<Employee>
{
	@Override
	public int compare(Employee o1, Employee o2) 
	{
		return o1.getAge() - o2.getAge();
	}	
}
