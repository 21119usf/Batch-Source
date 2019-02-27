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
import com.revature.utilities.Validation;

public class AdminView {

	public AdminView() {
		System.out.print("\nHello Admin!\n");
	}
	
	public void frontPage() throws SQLException {
		String input;
		
		do {
			System.out.println("A. View Customers");
			System.out.println("B. View Accounts");
			System.out.println("C. Approve/deny applications");
			System.out.println("D. Deposit/withdraw/transfer from an account");
			System.out.println("E. Remove account");
			System.out.println("F. Log out");
			System.out.print("\nEnter an option: ");
			
			input = ScannerInstance.scanner.nextLine();
			
			if (input.equals("A")) {
				viewCustomers();
			} else if (input.equals("B")) {
				viewAccounts();
			} else if (input.equals("C")) {
				approveDenyApplication();
			} else if (input.equals("D")) {
				depositWithdrawTransfer();
			} else if (input.equals("E")) {
				removeAccount();
			} else if (input.equals("F")) {
			
			} else {
				System.out.println("\nInvalid option\n");
			}
		} while (!input.equals("F"));
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
	
	public void depositWithdrawTransfer() throws SQLException {
		System.out.print("Enter your account you would like to withdraw, deposit, or transfer from: ");
		
		String input = ScannerInstance.scanner.nextLine();
		int accountID = ParseString.parseI(input);
		
		if (accountID == Integer.MIN_VALUE) {
			return;
		}

		if (!new AccountDaoImpl().doesAccountIDExist(accountID)) {
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

		if (!new AccountDaoImpl().doesAccountIDExist(accountID)) {
			System.out.println("This account does not exist");
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
