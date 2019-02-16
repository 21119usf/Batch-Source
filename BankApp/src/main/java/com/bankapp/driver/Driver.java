package com.bankapp.driver;

import com.bankapp.utils.MenuUtils;
import com.bankapp.account.Account;
import com.bankapp.utils.AccountUtils;
import com.bankapp.person.Customer;
import com.bankapp.utils.CustomerUtils;
import com.bankapp.person.Employee;
import com.bankapp.utils.EmployeeUtils;

// Driver class for BankApp
public class Driver {
	public static void main(String[] args) {
		// Load Customer data from file
		CustomerUtils.loadCustomers();
		
		// Load Account data from file
		
		// Landing page
		int option = 0;
		option = MenuUtils.displayLanding();
		
		// Redirect
		switch (option) {
		case 1:		// Login
			MenuUtils.displayLogin();
			break;
		case 2:		// Register
			MenuUtils.displayRegistration();
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
