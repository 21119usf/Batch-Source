package com.bankapp.utils;

import java.util.ArrayList;

import com.bankapp.menu.Menu;

public class MenuUtils {
	// Display landing page and get desired option
	public static int displayLanding() {
		ArrayList<String> al = new ArrayList<String>();
		al.add("Exit");
		al.add("Customer");
		al.add("Employee");
		Menu m = new Menu(al);
		int option = m.display();
		
		return option;
	}
	
	// Display customer entry page
	public static void displayCustomerEntry() {
		ArrayList<String> al = new ArrayList<String>();
		al.add("Back");
		al.add("Customer Login");
		al.add("Register");
		Menu m = new Menu(al);
		int option = m.display();
		
		// Redirect
		switch (option) {
		case 0:
			displayLanding();
			break;
		case 1:
			CustomerUtils.displayLogin();
			break;
		case 2:
			CustomerUtils.displayRegistration();
			break;
		default:
			displayLanding();
			break;
		}
	}
	
	// Display employee entry page
	public static void displayEmployeeEntry() {
		ArrayList<String> al = new ArrayList<String>();
		al.add("Back");
		al.add("Employee Login");
		al.add("Register");
		Menu m = new Menu(al);
		int option = m.display();
		
		// Redirect
		switch (option) {
		case 0:
			displayLanding();
			break;
		case 1:
			EmployeeUtils.displayLogin();
			break;
		case 2:
			EmployeeUtils.displayRegistration();
			break;
		default:
			displayLanding();
			break;
		}
	}
}
