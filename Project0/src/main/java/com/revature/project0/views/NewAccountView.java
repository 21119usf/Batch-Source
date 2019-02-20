package com.revature.project0.views;

import java.util.Scanner;

import com.revature.project0.classes.ApplicationManager;
import com.revature.project0.classes.Customer;

public class NewAccountView implements View
{
	@Override
	public void show(ViewController controller) 
	{
		Scanner scanner = ViewController.scanner;
		
		ApplicationManager applicationManager = new ApplicationManager();
		
		String firstName = "";
		
		String lastName = "";
		
		String address = "";
		
		String password = "";
		
		String username = "";
		
		System.out.println("Welcome to new account creation.");
		
		System.out.println("Please re-enter your username: ");
		
		username = scanner.nextLine();
		
		System.out.println("Please enter a password for your account: ");
		
		password = scanner.nextLine();
		
		System.out.println("Please enter your first name: ");
		
		firstName = scanner.nextLine();
		
		System.out.println("Please enter your last name: ");
		
		lastName = scanner.nextLine();
		
		System.out.println("Please enter your address: ");
		
		address = scanner.nextLine();
		
		Customer newCustomer = new Customer(username, password);
		
		newCustomer.setFirstName(firstName);
		newCustomer.setLastName(lastName);
		newCustomer.setAddress(address);
		
		System.out.println("A new application has been created for you. \n"
				+ "The application must be approved before you can use your new account.");
		
		applicationManager.createNewApplication(newCustomer);
	
		controller.getLastView();
	}
}
