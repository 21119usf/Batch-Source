package com.revature.comparator;

import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;



public class Employees implements Comparator<Employees> {
	public static void main(String[] args) {
		List<Employees>employeesList= new ArrayList<Employees>();
		employeesList.addAll(Arrays.asList(
		new Employees[] {
				new Employees(" Joe", " Fitness", 23),
				new Employees(" Shmo", " Music", 25),
			}));
		System.out.println("Employee List: ");
		for(Employees e:employeesList) {
			System.out.println(e);
		}
		}	
	//1st Method
	private String employeeName;
	private String department;
	private int age;
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
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
	public Employees() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employees(String employeeName, String department, int age) {
		super();
		this.employeeName = employeeName;
		this.department = department;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Employees [employeeName =" + employeeName + ", department =" + department + ", age = " + age + "]";
	}
	@Override
	public int compare(Employees arg0, Employees arg1) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
