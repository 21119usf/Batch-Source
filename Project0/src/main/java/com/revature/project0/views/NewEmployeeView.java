package com.revature.project0.views;

import java.util.Scanner;

import com.revature.project0.classes.Employee;
import com.revature.project0.classes.EmployeeManager;

public class NewEmployeeView implements View
{

	@Override
	public void show(ViewController controller) 
	{
		String username = "";
		
		String password = "";
		
		Scanner scanner = ViewController.scanner;
		
		EmployeeManager manager = new EmployeeManager();
		
		System.out.println("Welcome to the new employee creation. \n" 
				+ "Please enter your username: ");
		
		username = scanner.nextLine();
		
		System.out.println("Please enter your password: ");
		
		password = scanner.nextLine();
		
		Employee employee = new Employee(username, password);
		
		manager.addNewEmployee(employee);
		
		System.out.println("You have successfully created a new employee account");
	
		controller.getLastView();
	}
	
}
