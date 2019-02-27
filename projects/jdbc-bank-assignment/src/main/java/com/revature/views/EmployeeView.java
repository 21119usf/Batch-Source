package com.revature.views;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Account;
import com.revature.beans.Application;
import com.revature.beans.Customer;
import com.revature.daoimpl.AccountDaoImpl;
import com.revature.daoimpl.ApplicationDaoImpl;
import com.revature.daoimpl.CustomerDaoImpl;
import com.revature.utilities.ParseString;
import com.revature.utilities.ScannerInstance;

public class EmployeeView {

	public EmployeeView() {
		System.out.println("\nHello Employee!\n");
	}
	
	public void frontPage() throws SQLException {
		String input;
		
		do {
			System.out.println("A. View Customers");
			System.out.println("B. View Accounts");
			System.out.println("C. Approve/deny applications");
			System.out.println("D. Log out");
			System.out.print("\nEnter an option: ");
			
			input = ScannerInstance.scanner.nextLine();
			
			if (input.equals("A")) {
				viewCustomers();
			} else if (input.equals("B")) {
				viewAccounts();
			} else if (input.equals("C")) {
				approveDenyApplication();
			} else if (input.equals("D")) {
				
			} else {
				System.out.println("\nInvalid option\n");
			}
		} while (!input.equals("D"));
	}
	
	public void viewCustomers() throws SQLException {
		System.out.println();
		List<Customer> customerList = new CustomerDaoImpl().getCustomerListNoPassword();
		for (Customer c : customerList) {
			System.out.println(c.displayNoPassword());
		}
		System.out.println();
	}
	
	public void viewAccounts() throws SQLException {
		System.out.println();
		List<Account> accountList = new AccountDaoImpl().getAccountList();
		for (Account a : accountList) {
			System.out.println(a);
		}
		System.out.println();
	}
	
	public void approveDenyApplication() throws SQLException {
		System.out.println();
		List<Application> applicationList = new ApplicationDaoImpl().getApplicationList();
		for (Application a : applicationList) {
			System.out.println(a);
		}
		System.out.println();
		
		System.out.print("Enter the application you like to approve/deny: ");
		
		int appID = ParseString.parseI(ScannerInstance.scanner.nextLine());
		
		if (appID == Integer.MIN_VALUE) {
			return;
		}
		
		if (!new ApplicationDaoImpl().doesApplicatoinIDExist(appID)) {
			System.out.print("This application ID does NOT exist");
			return;
		}
		
		String input;
		
		System.out.println("A. Approve");
		System.out.println("B. Deny");
		System.out.println("C. Any other key to exit");
		System.out.print("\nEnter an option: ");
		
		input = ScannerInstance.scanner.nextLine();
		
		if (input.equals("A")) {
			new AccountDaoImpl().createAccount(new ApplicationDaoImpl().getCustomerIDFromApplication(appID));
			new ApplicationDaoImpl().deleteApplication(appID);
			System.out.println("Application approved");
		} else if (input.equals("B")) {
			new ApplicationDaoImpl().deleteApplication(appID);
			System.out.println("Application denied");
		}
	}
}
