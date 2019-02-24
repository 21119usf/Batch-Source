package com.bankapp.driver;

import com.bankapp.controllers.CustomerController;
import com.bankapp.controllers.EmployeeController;
import com.bankapp.controllers.MenuController;

// Driver class for BankApp
public class Main {
	public static void main(String[] args) {
		// Initialize singleton controllers
		CustomerController cc = CustomerController.getInstance();
		EmployeeController ec = EmployeeController.getInstance();
		
		// Start menu
		int option = 0;
		while (true) {
			option = MenuController.displayLanding();
			
			// Redirect
			switch (option) {
			case 0:		// Exit
				System.out.println("Goodbye");
				return;
			case 1:		// Customer
				cc.displayCustomerEntry();
				break;
			case 2:		// Employee
				ec.displayEmployeeEntry();
				break;
			}
		}
	}
}
