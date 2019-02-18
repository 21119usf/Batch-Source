package com.revature.hw1prob7;

//employee bean
public class Employee implements Comparable<Employee>{
	
	private int age;
	private String name;
	private String department;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Employee(int age, String name, String department) {
		super();
		this.age = age;
		this.name = name;
		this.department = department;
	}


	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
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
	
	@Override
	public String toString() {
		return "Employee [age=" + age + ", name=" + name + ", department=" + department + "]";
	}
	
	@Override
	public int compareTo(Employee o) {
		//compare studentID
		return this.getAge() - o.getAge();
	}
	
	
}
