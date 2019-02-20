package com.revature.project0.classes;

import java.util.ArrayList;

public class EmployeeManager 
{
	private static ArrayList<Employee> employeeList = new ArrayList<Employee>();

	public static void setEmployeeList(ArrayList<Employee> employeeList) {
		EmployeeManager.employeeList = employeeList;
	}

	public static ArrayList<Employee> getEmployeelist() {
		return employeeList;
	}

	public void addNewEmployee(Employee employee)
	{
		employeeList.add(employee);
	}
	
	public Employee findEmployee(String username)
	{
		Employee foundEmployee = null;
		
		for(Employee employee : employeeList)
		{
			if(employee.getUsername().equals(username))
			{
				foundEmployee = employee;
			}
		}
		
		return foundEmployee;
	}
}
