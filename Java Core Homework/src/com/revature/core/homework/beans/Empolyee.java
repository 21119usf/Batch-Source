package com.revature.core.homework.beans;

import java.util.Comparator;

public class Empolyee {
	private String department;
	private int age;
	private String name;

	public String getDepartment() {
		return department;
	}
	public Empolyee(String department, int age, String name) {
		super();
		this.department = department;
		this.age = age;
		this.name = name;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
