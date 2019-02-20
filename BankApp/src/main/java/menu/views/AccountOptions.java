package menu.views;

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

import account.Account;
import bankactors.Customer;
import menu.CreateMenuDisplay;

public class AccountOptions 
{
	final static Logger logger = Logger.getLogger(AccountOptions.class);
	private static Scanner scan = new Scanner(System.in);
	private static String accountsFile = "Accounts.ser";
	private static ArrayList<Account> accounts = new ArrayList<Account>();
	
	// Load accounts from file
	@SuppressWarnings("unchecked")
	public static void loadAccounts() 
	{
		try
		{
			FileInputStream fis = new FileInputStream(accountsFile);
			ObjectInputStream ois = new ObjectInputStream(fis);
			accounts = (ArrayList<Account>)ois.readObject();
			ois.close();
			fis.close();
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Accounts.ser not found");
		}
		catch (IOException e) {}
		catch (ClassNotFoundException e) {}
	}
	
	// Save accounts to file
	public static void saveAccounts() 
	{
		try 
		{
			FileOutputStream fos = new FileOutputStream(accountsFile);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(accounts);
			oos.close();
			fos.close();
		} 
		catch (FileNotFoundException e) {e.printStackTrace();}
		catch (IOException e) {e.printStackTrace();}
	}
	
	// Return account by id
	public static Account getAccount(int id) 
	{
		for (Account a : accounts) 
		{
			if (a.getAccountID() == id) 
			{
				return a;
			}
		}
		return null;
	}
	
	// Display account menu
	public static void displayAccountMenu(Account a) 
	{	
		ArrayList<String> menuItems = new ArrayList<String>();
		menuItems.add("Deposit");
		menuItems.add("Withdraw");
		menuItems.add("Transfer Funds");
		menuItems.add("View Account Details");
		menuItems.add("Close This Account ");
		menuItems.add("Go Back?");
		
		CreateMenuDisplay m = new CreateMenuDisplay(menuItems);
		int option = m.display();
		
		// Redirect
		switch(option)
		{
			case 1:
				AccountOptions.deposit(a);
				break;
			case 2:
				AccountOptions.withdraw(a);
				break;
			case 3:
				AccountOptions.transfer(a);
				break;
			case 4:
				AccountOptions.printAccountDetails(a);
				break;
			case 5:
				return;
		}
		displayAccountMenu(a);
	}
	
	// Deposit
	public static void deposit(Account a) {
		double amount = 0.0;
		
		System.out.println("Enter amount to deposit:");
		try {amount = scan.nextDouble();} 
		catch (InputMismatchException e) 
		{
			System.out.println("Invalid amount.");
			scan.nextLine();
		}
		
		if (amount > 0.0) 
		{
			a.deposit(amount);
			logger.info("Depsited " + a.getAccountID() + ": $" + String.format("%.2f", amount));
			saveAccounts();
		} 
		else if (amount == 0.0){return;}
	}
	
	// Withdraw
	public static void withdraw(Account a) {
		double amount = 0.0;
		
		System.out.println("Enter amount to withdraw:");
		try {amount = scan.nextDouble();}
		catch (InputMismatchException e) 
		{
			System.out.println("Invalid amount.");
			scan.nextLine();
		}
	
		if (amount > 0.0) 
		{
			a.withdraw(amount);
			logger.info("Withdrew " + a.getAccountID() + ": $" + String.format("%.2f", amount));
			AccountOptions.saveAccounts();
		}
		else if (amount == 0.0) {return;} 
	}
	
	// Transfer from account a
	public static void transfer(Account a) {
		int accountID = 0;
		double amount = 0.0;
		
		System.out.println("Enter Account ID to transfer funds towards:");
		try {accountID = scan.nextInt();} 
		catch
		(InputMismatchException e) 
		{
			System.out.println("Invalid amount.");
			scan.nextLine();
		}
		System.out.println("Enter amount to transfer:");
		try {amount = scan.nextDouble();} 
		catch (InputMismatchException e) 
		{
			System.out.println("Invalid amount.");
			scan.nextLine();
		}
		
		if (amount == 0.0) {return;}
		else if (amount > 0.0)
		{
			// Get account b
			Account a2 = getAccount(accountID);
			if (a2 != null)
			{
				a.transfer(a2, amount);
				logger.info("Transferred from " + a.getAccountID() + " to " + a2.getAccountID() 
						+ " $" + String.format("%.2f", amount));
				AccountOptions.saveAccounts();
			}
			else
			{
				System.out.println("Account not found");
			}
		}
	}
	
	// Menu to open account
	public static Account displayOpenAccount(Customer c)
	{
		Account a = new Account(c);
		int choice = 0;
		
		ArrayList<String> menuItems = new ArrayList<String>();
		menuItems.add("Yes");
		menuItems.add("No");
		CreateMenuDisplay m = new CreateMenuDisplay(menuItems);
		System.out.println("Do you want this to be a joint account?");
		choice = m.display();
		if (choice == 1) 
		{
			System.out.println("Enter the other user's ID:");
			try 
			{
				int id = scan.nextInt();
				Customer c2 = CustomerOptions.getCustomer(id);
				if (c2 != null) 
				{
					a.addUser(c2);
					logger.info("Users: " + c.getCustID() + ", " + c2.getCustID() + " opened new Account " + a.getAccountID());
					saveAccounts();
				} 
				else
				{
					System.out.println("User ID not found. Try again");
					displayOpenAccount(c);
				}
			}
			catch (InputMismatchException e) 
			{
				System.out.println("Invalid ID.");
				scan.nextLine();
			}
		}
		
		accounts.add(a);
		saveAccounts();
		c.getAccounts().add(a);
		CustomerOptions.saveCustomers();
		displayAccountMenu(a);
		
		return a;
	}
	public static void closeAccount(Account a)
	{
		ArrayList<String> menuItems = new ArrayList<String>();
		System.out.println("All deletions of accounts are final. Are you sure you want this account deleted?");
		menuItems.add("Yes");
		menuItems.add("I change my mind");
		CreateMenuDisplay m = new CreateMenuDisplay(menuItems);
		int option = m.display();
		if(option == 1)
		{
			a.setOpen(false);
			logger.info("Account " + a.getAccountID() + " is now closed");
			saveAccounts();
		}
		return;
	}
	// Print account details
	public static void printAccountDetails(Account a) {
		System.out.println("Account ID:" + a.getAccountID());
		System.out.println("Balance: $" + a.getBalance());
		ArrayList<Customer> user = a.getUsers();
		System.out.print("Owners:\t\t");
		for (Customer c : user) 
		{
			System.out.println(c.getUsername() + " ");
		}
		
		displayAccountMenu(a);
	}
}
