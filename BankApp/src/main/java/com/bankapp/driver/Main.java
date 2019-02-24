package com.bankapp.driver;

import com.bankapp.controllers.AccountController;
import com.bankapp.controllers.CustomerController;
import com.bankapp.controllers.EmployeeController;
import com.bankapp.controllers.MenuController;

// Driver class for BankApp
public class Main {
	public static void main(String[] args) {
		// Initialize singleton controllers
		CustomerController cc = CustomerController.getInstance();
		EmployeeController ec = EmployeeController.getInstance();
		AccountController ac = AccountController.getInstance();
		
		// Landing page
		int option = 0;
		option = MenuController.displayLanding();
		
		// Redirect
		switch (option) {
		case 1:		// Customer
			CustomerController.displayCustomerEntry();
			break;
		case 2:		// Employee
			EmployeeController.displayEmployeeEntry();
			break;
		case 0:		// Exit
			System.out.println("Goodbye");
			return;
		default:
			System.out.println("Goodbye");
			return;
		}
	}
}
