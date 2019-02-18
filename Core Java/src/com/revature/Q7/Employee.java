package com.revature.Q7;



/*
 * Rather Boring Employee POJO
 * Fields:  String name,
 * 			String department,
 * 			int age
 */


public class Employee{

	private String name;
	private String department;
	private int age;
	
	public Employee(String name, String department, int age) {
		this.name = name;
		this.department = department;
		this.age = age;
	}
	
	public void setName(String name){
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setDepartment(String department){
		this.department = department;
	}
	public String getDepartment() {
		return department;
	}
	public void setAge(int age){
		this.age = age;
	}
	public int getAge() {
		return age;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", department=" + department + ", age=" + age + "]";
	}
	// Override equals so assertEquals works when Junit testing
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Employee))return false;
		Employee e = (Employee) obj;
		if(!(this.name.equals(e.name)))return false;
		if(!(this.department.equals(e.department)))return false;
		if(this.age != e.age)return false;
		return true;
	}


}
