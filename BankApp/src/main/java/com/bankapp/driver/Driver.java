package com.bankapp.driver;

import com.bankapp.utils.MenuUtils;
import com.bankapp.utils.AccountUtils;
import com.bankapp.utils.CustomerUtils;
import com.bankapp.utils.EmployeeUtils;

// Driver class for BankApp
public class Driver {
	public static void main(String[] args) {
		// Load data from files
		CustomerUtils.loadCustomers();
		EmployeeUtils.loadEmployees();
		AccountUtils.loadAccounts();
		
		// Landing page
		int option = 0;
		option = MenuUtils.displayLanding();
		
		// Redirect
		switch (option) {
		case 1:		// Customer
			MenuUtils.displayCustomerEntry();
			break;
		case 2:		// Employee
			MenuUtils.displayEmployeeEntry();
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
