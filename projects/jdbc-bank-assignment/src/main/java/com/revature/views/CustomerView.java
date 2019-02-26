package com.revature.views;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Account;
import com.revature.daoimpl.AccountDaoImpl;
import com.revature.daoimpl.ApplicationDaoImpl;
import com.revature.daoimpl.CustomerDaoImpl;
import com.revature.utilities.ParseString;
import com.revature.utilities.ScannerInstance;

public class CustomerView {
	
	private int customerID;
	
	public CustomerView(String username) throws SQLException {
		customerID = new CustomerDaoImpl().getCustomerIDFromUsername(username);
		
		System.out.println("\nHello " + new CustomerDaoImpl().getFirstLastNameFromCustomerID(customerID) + "!\n");
	}
	
	public void frontPage() throws SQLException {
		String input;
		
		do {
			System.out.println("A. Apply to open a new account");
			System.out.println("B. Look at accounts");
			System.out.println("C. Deposit/withdraw/transfer from an account");
			System.out.println("D. Log out");
			System.out.print("\nEnter an option: ");
			
			input = ScannerInstance.scanner.nextLine();
			
			if (input.equals("A")) {
				applyAccount();
			} else if (input.equals("B")) {
				viewAccount();
			} else if (input.equals("C")) {
				depositWithdrawTransfer();
			} else if (input.equals("D")) {
				
			} else {
				System.out.println("\nInvalid option\n");
			}
		} while (!input.equals("D"));
	}
	
	public void applyAccount() throws SQLException {
		new ApplicationDaoImpl().createApplication(customerID);
		System.out.println("\nApplication for a new account has been sent!\n");
	}
	
	public void viewAccount() throws SQLException {
		System.out.println();
		List<Account> accountList = new AccountDaoImpl().getAccountListFromCustomerID(customerID);
		for (Account a : accountList) {
			System.out.println(a.displayNoCustomerID());
		}
		System.out.println();
	}
	
	public void depositWithdrawTransfer() {
		System.out.print("Enter your account you would like to withdraw, deposit, or transfer from: ");
		String input = ScannerInstance.scanner.nextLine();
		
		if (ParseString.parseI(input) == Integer.MIN_VALUE) {
			return;
		}
		
		System.out.println("test");
	}
}
