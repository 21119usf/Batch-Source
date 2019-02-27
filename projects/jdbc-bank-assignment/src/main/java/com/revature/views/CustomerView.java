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
			System.out.println("D. Remove account");
			System.out.println("E. Log out");
			System.out.print("\nEnter an option: ");
			
			input = ScannerInstance.scanner.nextLine();
			
			if (input.equals("A")) {
				applyAccount();
			} else if (input.equals("B")) {
				viewAccount();
			} else if (input.equals("C")) {
				depositWithdrawTransfer();
			} else if (input.equals("D")) {
				removeAccount();
			} else if (input.equals("E")) {
				
			} else {
				System.out.println("\nInvalid option\n");
			}
		} while (!input.equals("E"));
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
				System.out.print("Enter the amount you like to deposit: ");
				input = ScannerInstance.scanner.nextLine();
				amount = ParseString.parseD(input);
				if (amount == Double.NEGATIVE_INFINITY) {
					break;
				}
				if (Validation.isLessThanZero(amount)) {
					break;
				}
				double newBalance = (new AccountDaoImpl().getBalanceFromAccountID(accountID) + amount);
				new AccountDaoImpl().setBalanceFromAccountID(accountID, newBalance);
				System.out.println("You have deposited " + amount);
				System.out.printf("Your new balance is %.2f", newBalance);
				System.out.println();

			} else if (input.equals("C")) {
				System.out.print("Enter the account you would like to transfer to: ");
				
				int transferAccountID = ParseString.parseI(ScannerInstance.scanner.nextLine());
				
				if (transferAccountID == Integer.MIN_VALUE) {
					return;
				}

				if (!new AccountDaoImpl().doesAccountIDExist(transferAccountID)) {
					System.out.println("You do not have access to this account");
					return;
				}
				
				System.out.print("Enter the amount you would like to transfer: ");
				amount = ParseString.parseD(ScannerInstance.scanner.nextLine());
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
				double transferNewBalancedouble = (new AccountDaoImpl().getBalanceFromAccountID(transferAccountID) + amount);
				
				new AccountDaoImpl().setBalanceFromAccountID(accountID, newBalance);
				new AccountDaoImpl().setBalanceFromAccountID(transferAccountID, transferNewBalancedouble);
				
				System.out.println("You have transferred " + amount);
				System.out.printf("Your new balance is %.2f", newBalance);
				System.out.println();
			} else if (input.equals("D")) {
				
			} else {
				System.out.println("\nInvalid option\n");
			}
		} while (!input.equals("D"));
	}
	
	public void removeAccount() throws SQLException {
		System.out.print("Enter the account you would like to remove: ");
		
		int accountID = ParseString.parseI(ScannerInstance.scanner.nextLine());
		
		if (accountID == Integer.MIN_VALUE) {
			return;
		}

		if (!new AccountDaoImpl().doesAccountIDExistAccountIDCustomerID(accountID, customerID)) {
			System.out.println("You do not have access to this account");
			return;
		}
		
		if (new AccountDaoImpl().getBalanceFromAccountID(accountID) != 0) {
			System.out.println("You need to withdraw all your money before you can cancel your account");
			return;
		}
		
		new AccountDaoImpl().deleteAccountFromAccountID(accountID);
		System.out.println("Account removed");
	}
}
