package com.revature.homework1;

import java.util.Comparator;

public class Employee implements Comparator<Employee>{
	private String name;
	private String department;
	private int age;
	
	Employee(){
		super();
	}
	
	Employee(String name, String department, int age){
		this.name = name;
		this.department = department;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", department=" + department + ", age=" + age + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public int compare(Employee e1, Employee e2) {
		// TODO Auto-generated method stub
		return ((int) (e1.getAge()) - (e2.getAge()));
		
	}
	
	
}
