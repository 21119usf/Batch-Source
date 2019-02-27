package com.revature.views;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Account;
import com.revature.daoimpl.AccountDaoImpl;
import com.revature.daoimpl.ApplicationDaoImpl;
import com.revature.daoimpl.CustomerDaoImpl;
import com.revature.utilities.ParseString;
import com.revature.utilities.ScannerInstance;
import com.revature.utilities.Validation;

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
	
	public void depositWithdrawTransfer() throws SQLException {
		System.out.print("Enter your account you would like to withdraw, deposit, or transfer from: ");
		
		String input = ScannerInstance.scanner.nextLine();
		int accountID = ParseString.parseI(input);
		
		if (accountID == Integer.MIN_VALUE) {
			return;
		}

		if (!new AccountDaoImpl().doesAccountIDExistAccountIDCustomerID(accountID, customerID)) {
			System.out.println("You do not have access to this account");
			return;
		}
		
		do {
			double amount;
			
			System.out.println("A. Withdraw");
			System.out.println("B. Deposit");
			System.out.println("C. Transfer");
			System.out.println("D. Exit");
			System.out.print("\nEnter an option: ");
			
			input = ScannerInstance.scanner.nextLine();
			
			if (input.equals("A")) {
				System.out.print("Enter the amount you like to withdraw: ");
				input = ScannerInstance.scanner.nextLine();
				amount = ParseString.parseD(input);
				if (amount == Double.NEGATIVE_INFINITY) {
					break;
				}
				if (Validation.isLessThanZero(amount)) {
					break;
				}
				if ((new AccountDaoImpl().getBalanceFromAccountID(accountID) - amount) < 0) {
					System.out.println("You can not overdraft your account");
					break;
				}
				double newBalance = (new AccountDaoImpl().getBalanceFromAccountID(accountID) - amount);
				new AccountDaoImpl().setBalanceFromAccountID(accountID, newBalance);
				System.out.println("You have withdrawed " + amount);
				System.out.printf("Your new balance is %.2f", newBalance);
				System.out.println();
				
			} else if (input.equals("B")) {

			} else if (input.equals("C")) {

			} else if (input.equals("D")) {
				
			} else {
				System.out.println("\nInvalid option\n");
			}
		} while (!input.equals("D"));
	}
}
