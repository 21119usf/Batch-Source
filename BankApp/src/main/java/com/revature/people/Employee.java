package com.revature.people;

public class Employee {
	String employeeName;
	String password;
	
	public Employee() {}
	
	public Employee(String employeeName, String password) {
		super();
		this.employeeName = employeeName;
		this.password = password;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
