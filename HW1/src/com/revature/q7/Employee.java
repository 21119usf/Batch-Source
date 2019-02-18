package com.revature.q7;

public class Employee {
	
	//instance variables
	private String name;
	private int age;
	private String department;
	
	//access modifiers
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	
	//constructor
	public Employee(String name, int age, String department) {
		super();
		this.name = name;
		this.age = age;
		this.department = department;
	}
	
	//toString
	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", department=" + department + "]";
	}
	
	

}
