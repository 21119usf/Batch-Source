package com.bankapp.utils;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.bankapp.account.Account;
import com.bankapp.menu.Menu;
import com.bankapp.person.Customer;
import com.bankapp.person.Employee;

public class MenuUtils {
	private static Customer currentCustomer;
	private static Employee currentEmployee;
	private static Scanner sc = new Scanner(System.in);
	
	// Display landing page and get desired option
	public static int displayLanding() {
		int option = 0;
		
		ArrayList<String> al = new ArrayList<String>();
		al.add("Exit"); al.add("Customer"); al.add("Employee");
		Menu m = new Menu(al);
		option = m.display();
		
		return option;
	}
	
	// Display customer entry page
	public static void displayCustomerEntry() {
		int option = 0;
		
		ArrayList<String> al = new ArrayList<String>();
		al.add("Back");
		al.add("Customer Login");
		al.add("Register");
		Menu m = new Menu(al);
		option = m.display();
		
		// Redirect
		switch (option) {
		case 1:
			CustomerUtils.displayLogin();
			break;
		case 2:
			CustomerUtils.displayRegistration();
			break;
		case 0:
			displayLanding();
			break;
		default:
			displayLanding();
			break;
		}
	}
	
	// Display employee entry page
	public static void displayEmployeeEntry() {
		int option = 0;
		
		ArrayList<String> al = new ArrayList<String>();
		al.add("Back");
		al.add("Employee Login");
		Menu m = new Menu(al);
		option = m.display();
		
		// Redirect
		switch (option) {
		case 1:
			EmployeeUtils.displayLogin();
			break;
		case 0:
			displayLanding();
			break;
		default:
			displayLanding();
			break;
		}
	}
	
	// Display open account menu
	private static void displayOpenAccount() {
		
	}
	
	// Display employee menu page
	private static void displayEmployeeLanding() {
		
	}
}
