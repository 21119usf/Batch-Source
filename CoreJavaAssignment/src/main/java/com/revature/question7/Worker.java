package com.revature.question7;

public class Worker implements Comparable<Worker>{

	private String name;
	private String department;
	private int age;
	
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



	public Worker() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Worker(String name, String department, int age) {
		super();
		this.name = name;
		this.department = department;
		this.age = age;
	}



	@Override
	public String toString() {
		return "Worker [name=" + name + ", department=" + department + ", age=" + age + "]";
	}

	@Override
	public int compareTo(Worker o) {
		// TODO Auto-generated method stub
		return this.getAge() - o.getAge();
	}




	//Sort two employees based on their name, department, 
	//and age using the Comparator interface.
	
}
