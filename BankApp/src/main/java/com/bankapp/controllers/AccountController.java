package com.bankapp.controllers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.bankapp.account.Account;
import com.bankapp.menu.Menu;
import com.bankapp.user.Customer;

public class AccountController {
	final static Logger logger = Logger.getLogger(AccountController.class);
	private static AccountController instance;
	private static Scanner sc = new Scanner(System.in);
	private static String accountsFile = "Accounts.ser";
	private static ArrayList<Account> accounts = new ArrayList<Account>();
	
	// Constructor
	private AccountController() {
		loadAccounts();
	}
	
	// Return instance
	public static synchronized AccountController getInstance() {
		if (instance == null) {
			instance = new AccountController();
		}
		return instance;
	}
	
	// Load accounts from file
	@SuppressWarnings("unchecked")
	public static void loadAccounts() {
		try {
			FileInputStream af = new FileInputStream(accountsFile);
			ObjectInputStream ois = new ObjectInputStream(af);
			accounts = (ArrayList<Account>)ois.readObject();
			ois.close();
			af.close();
		} catch (FileNotFoundException e) {
			System.out.println("Accounts.ser not found");
		} catch (IOException e) {
			// e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// e.printStackTrace();
		}
	}
	
	// Save accounts to file
	public static void saveAccounts() {
		try {
			FileOutputStream af = new FileOutputStream(accountsFile);
			ObjectOutputStream oos = new ObjectOutputStream(af);
			oos.writeObject(accounts);
			oos.close();
			af.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// Return account by id
	public static Account getAccount(int id) {
		for (Account a : accounts) {
			if (a.getId() == id) {
				return a;
			}
		}
		return null;
	}
	
	// Display account menu
	public static void displayAccountMenu(Account a) {
		int option = 0;
		
		ArrayList<String> al = new ArrayList<String>();
		al.add("Back");
		al.add("Deposit");
		al.add("Withdraw");
		al.add("Transfer Funds");
		al.add("View Details");
		al.add(">>> Close Account <<<");
		
		System.out.println();
		Menu m = new Menu(al);
		option = m.display();
		
		// Redirect
		if (option == 0) {
			return;
		} else if (option == 1) {
			AccountController.deposit(a);
		} else if (option == 2) {
			AccountController.withdraw(a);
		} else if (option == 3) {
			AccountController.transfer(a);
		} else if (option == 4) {
			AccountController.printAccountDetails(a);
		} else if (option == 5) {
			AccountController.closeAccount(a);
		}

		return;
	}
	
	// Deposit
	public static void deposit(Account a) {
		double amount = 0.0;
		
		System.out.println();
		System.out.println("Enter amount to deposit (0 to cancel):");
		System.out.print(">>> ");
		try {
			amount = sc.nextDouble();
		} catch (InputMismatchException e) {
			System.out.println("Invalid amount.");
			sc.nextLine();
		}
		
		if (amount > 0.0 && a.deposit(amount)) {
			logger.info("DEPOSIT " + "(" + a.getId() + "): $"
				+ String.format("%.2f", amount));
			saveAccounts();
		} else if (amount == 0.0) {
			return;
		}
	}
	
	// Withdraw
	public static void withdraw(Account a) {
		double amount = 0.0;
		
		System.out.println();
		System.out.println("Enter amount to withdraw (0 to cancel):");
		System.out.print(">>> ");
		try {
			amount = sc.nextDouble();
		} catch (InputMismatchException e) {
			System.out.println("Invalid amount.");
			sc.nextLine();
		}
		
		if (amount == 0.0) {
			return;
		} else if (amount > 0.0 && a.withdraw(amount)) {
			logger.info("WITHDRAW " + "(" + a.getId() + "): $"
					+ String.format("%.2f", amount));
			AccountController.saveAccounts();
		}
	}
	
	// Transfer from account a
	public static void transfer(Account a) {
		int bId = 0;
		double amount = 0.0;
		
		System.out.println();
		System.out.println("Enter account id to transfer to (0 to cancel)");
		System.out.print(">>> ");
		try {
			bId = sc.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Invalid amount.");
			sc.nextLine();
		}
		System.out.println("Enter amount to transfer:");
		System.out.print(">>> ");
		try {
			amount = sc.nextDouble();
		} catch (InputMismatchException e) {
			System.out.println("Invalid amount.");
			sc.nextLine();
		}
		
		if (amount == 0.0) {
			return;
		} else if (amount > 0.0) {
			// Get account b
			Account b = getAccount(bId);
			if (b != null && a.transfer(b, amount)) {
				logger.info("TRANSFER from " + a.getId() + " to " + b.getId() 
					+ " $" + String.format("%.2f", amount));
				AccountController.saveAccounts();
			} else {
				System.out.println("Account not found");
			}
		}
	}
	
	// Menu to open account
	public static Account displayOpenAccount(Customer c) {
		Account a = new Account(c);
		int option = 0;
		
		// Ask for joint account
		ArrayList<String> al = new ArrayList<String>();
		al.add("Yes");
		al.add("No");
		Menu m = new Menu(al);
		System.out.println("Should this be a joint account?");
		option = m.display();
		if (option == 0) {
			System.out.println("Enter other user's ID number:");
			System.out.print(">>> ");
			try {
				int id = sc.nextInt();
				Customer c2 = CustomerController.getCustomer(id);
				if (c2 != null) {
					a.addOwner(c2);
					logger.info("CUSTOMERS " + c.getId() + ", " + c2.getId() +
						" opened ACCOUNT " + a.getId());
					saveAccounts();
				} else {
					System.out.println("User ID not found");
					displayOpenAccount(c);
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid ID.");
				sc.nextLine();
			}
		}
		
		accounts.add(a);
		saveAccounts();
		c.getAccounts().add(a.getId());
		CustomerController.saveCustomers();
		logger.info("CUSTOMER " + c.getId() + " opened ACCOUNT " + a.getId());
		displayAccountMenu(a);
		
		return a;
	}
	
	// Close account
	public static void closeAccount(Account a) {
		ArrayList<String> al = new ArrayList<String>();
		System.out.println("Are you sure?");
		al.add("Cancel");
		al.add("No");
		al.add("No");
		al.add("No");
		al.add("Yes");
		Menu m = new Menu(al);
		int option = m.display();
		
		if (option == 4) {
			a.setOpen(false);
			logger.info("ACCOUNT " + a.getId() + " closed");
			saveAccounts();
		}
		return;
	}
	
	// Print account details
	public static void printAccountDetails(Account a) {
		System.out.println();
		System.out.println("Account ID:\t" + a.getId());
		System.out.println("Status:\t\t" + a.getStatus());
		System.out.println("Open:\t\t" + a.isOpen());
		System.out.println("Balance:\t$" + String.format("%.2f", a.getBalance()));
		ArrayList<Customer> al = a.getOwners();
		System.out.print("Owners:\t\t");
		for (Customer c : al) {
			System.out.print(c.getUsername() + " ");
		}
		
		displayAccountMenu(a);
	}
}
