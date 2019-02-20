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
import validation.Validations;

public class CustomerOptions 
{
	final static Logger logger = Logger.getLogger(CustomerOptions.class);
	private static Scanner scan = new Scanner(System.in);
	private static String customersFile = "Customers.ser";
	private static ArrayList<Customer> customers = new ArrayList<Customer>();
	private static Customer currentCust;
	
	// Load customers from file
	@SuppressWarnings("unchecked")
	public static void loadCustomers() 
	{
		try
		{
			FileInputStream fis = new FileInputStream(customersFile);
			ObjectInputStream ois = new ObjectInputStream(fis);
			customers = (ArrayList<Customer>)ois.readObject();
			ois.close();
			fis.close();
		} 
		catch (FileNotFoundException e) {System.out.println(" File \"Customer.ser\" not found");} 
		catch (IOException e) {} 
		catch (ClassNotFoundException e) {}
	}
	
	// Save customers to file
	public static void saveCustomers() {
		try 
		{
			FileOutputStream fos = new FileOutputStream(customersFile);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(customers);
			oos.close();
			fos.close();
		} 
		catch (FileNotFoundException e) {e.printStackTrace();} 
		catch (IOException e) {e.printStackTrace();}
		
	}
	
	// Return customer by id
	public static Customer getCustomer(int id)
	{
		for (Customer c : customers) 
		{
			if (c.getCustID() == id) 
			{
				return c;
			}
		}
		return null;
	}
	
	// Display login
	public static void displayLogin() 
	{
		boolean notValidLogin = true;
		String username;
		String password;
		while(notValidLogin)
		{
			System.out.println("Enter Username: ");
			username = scan.nextLine();
			System.out.println("Password: ");
			password = scan.nextLine();
			
			currentCust = validLogin(username, password);
			if (currentCust != null) 
			{
				notValidLogin = false;
				System.out.println("Login accepted. Logging in.");
				logger.info("Customer " + currentCust.getCustID() + " logged in");
				displayCustomerMenu();
			} 
		} 
	}
	
	private static Customer validLogin(String username, String password) {
		// Customer login
		for (Customer c : customers)
		{
			if (c.getUsername().equals(username)) 
			{
				if (c.getPassword().equals(password)) 
				{
					System.out.println("Logged in!");
					return c;
				} 
				else 
				{
					System.out.println("Invalid login. Try again.");
					return null;
				}
			}
		}
		System.out.println("No user \"" + username + "\" found.");
		return null;
	}
	
	// Display registration page
	public static void displayRegistration()
	{
		String username = "";
		String password = "";
		String firstName = "";
		String lastName = "";
		long phoneNum = 0L;
		String email = "";
		long ssn = 0L;
		String address = "";
		
		System.out.println("Enter your personal account information:");
		
		boolean notValidUsername = true;
		while(notValidUsername)
		{
			System.out.println("Enter a username");
			username = scan.nextLine();
			if (Validations.validUsername(username)) {
				notValidUsername = false;
			} 
			else
			{
				System.out.println("Username is either invalid or taken.");
			}
		} 
		
		// Password
		boolean notValidPassword = true;
		String pass1, pass2;
		while(notValidPassword)
		{
			System.out.println("Enter a password");
			pass1 = scan.nextLine();
			if (Validations.validPassword(pass1)) 
			{
				System.out.println("Re-type password: ");
				pass2 = scan.nextLine();
				if (pass1.equals(pass2)) 
				{
					password = pass1;
					notValidPassword = false;
				}
				else
				{
					System.out.println("Mismatched passwords.");
				}
			}
		} 
		
		// First and last names, email and address
		System.out.println("Enter your first name: ");
		firstName = scan.nextLine();
		System.out.println("Enter your last name: ");
		lastName = scan.nextLine();
		System.out.println("Enter your email address: ");
		email = scan.nextLine();
		System.out.println("Enter your full address: ");
		address = scan.nextLine();
		
		// Phone number
		boolean notValidPhoneNumber = true;
		while(notValidPhoneNumber)
		{
			System.out.println("Enter your phone number: ");
			try 
			{
				phoneNum = scan.nextLong();
				if (Validations.validPhoneNumber(phoneNum)) 
				{
					notValidPhoneNumber = false;
				} 
				else
				{
					System.out.println("Invalid phone number");
					scan.nextLine();
				}
			} 
			catch (InputMismatchException e) 
			{
				System.out.println("Numerals only!!!");
				scan.nextLine();		
			}
		} 
		
		// Social security number
		boolean notValidSsn = true;
		while(notValidSsn)
		{
			System.out.println("Enter your social security number: ");
			try
			{
				ssn = scan.nextLong();
				if (Validations.validSsNumber(ssn)) 
				{
					notValidSsn = false;
				}
				else
				{
					System.out.println("Invalid social security number.");
					scan.nextLine();
				}
			} 
			catch (InputMismatchException e) 
			{
				System.out.println("Numerals only!!!");
				scan.nextLine();	
			}
		} 
		scan.nextLine();
		
		// Create Customer object and store data
		Customer c = new Customer(username, password, firstName, lastName, 
		email, address, phoneNum, ssn);
		customers.add(c);
		saveCustomers();
		displayLogin();
	}
	
	// Display customer accounts page
	public static void displayCustomerMenu() 
	{
		System.out.println("1. Your Accounts"
		+ "\n2. View Personal Information"
		+ "\n3. Edit Personal Information"
		+ "\nPress any number 4-9 to logout");	
		int choice =scan.nextInt();
		switch (choice) 
		{
			case 1:
				displayCustomerAccounts();
				break;
			case 2:
				displayCustomerInfo();
				break;
			case 3:
				editCustomerInfo();
				break;
			default:
				System.out.println("Logging out.");
				logger.info("Customer " + currentCust.getCustID() + " logged out");
				System.exit(0);
		}
	}
	
	// Display currentCustomer accounts
	public static void displayCustomerAccounts() 
	{
		ArrayList<Account> accounts = currentCust.getAccounts();	
		ArrayList<String> menuItems = new ArrayList<String>();
		menuItems.add("Go Back to Menu");
		menuItems.add("Open New Account");
		for (Account a : accounts) 
		{
			menuItems.add(a.getName());
		}
		
		CreateMenuDisplay m = new CreateMenuDisplay(menuItems);
		int choice = m.display();
		
		// Redirect
		switch(choice)
		{
			case 1:
				CustomerOptions.displayCustomerMenu();
				break;
			case 2:
				AccountOptions.displayOpenAccount(currentCust);
				break;
			default:
				AccountOptions.displayAccountMenu(accounts.get(choice-2));
				break;
		}
	}
	
	// Display currentCustomer personal info
	private static void displayCustomerInfo()
	{
		System.out.println("Your ID: " + currentCust.getCustID() 
		+ "\nYour username: " + currentCust.getUsername()
		+ "\nYour password: "+ currentCust.getPassword()
		+ "\nYour phone number: " + currentCust.getPhoneNum()
		+ "\nYour email: " + currentCust.getEmail());
		System.out.println();
		displayCustomerMenu();
	}
	
	// Edit currentCustomer personal info
	private static void editCustomerInfo()
	{	
		ArrayList<String> menuItems = new ArrayList<String>();
		menuItems.add("Edit First Name");
		menuItems.add("Edit Last Name");
		menuItems.add("Edit Email");
		menuItems.add("Edit Address");
		menuItems.add("Edit Phone Number");
		menuItems.add("Back");
		CreateMenuDisplay m = new CreateMenuDisplay(menuItems);
		
		int option = m.display();
		switch(option) {
		case 1:
			System.out.println("Enter New First Name:");
			String newFirstName = scan.nextLine();
			currentCust.setFirstName(newFirstName);
			break;
		case 2:
			System.out.println("Enter New Last Name:");
			String newLastName = scan.nextLine();
			currentCust.setLastName(newLastName);
			break;
		case 3:
			System.out.println("Enter New Email:");
			String newEmail = scan.nextLine();
			currentCust.setEmail(newEmail);
			break;
		case 4:
			System.out.println("Enter New Address:");
			String newAddress = scan.nextLine();
			currentCust.setAddress(newAddress);
			break;
		case 5:
			boolean notValidPhoneNumber = true;
			long phoneNumber = currentCust.getPhoneNum();
			do 
			{
				System.out.println("Enter your new Phone Number: ");
				try 
				{
					phoneNumber = scan.nextLong();
					if (Validations.validPhoneNumber(phoneNumber)) {
						notValidPhoneNumber = false;
					} 
					else
					{
						System.out.println("Invalid phone number");
						scan.nextLine();
					}
				}
				catch (InputMismatchException e)
				{
					System.out.println("Numerals only, no hyphens.");
					scan.nextLine();		
				}
			} 
			while (notValidPhoneNumber);
			currentCust.setPhoneNum(phoneNumber);
			break;
		case 6:
			displayCustomerMenu();
			break;
		default:
			displayCustomerMenu();
			break;
		}
		saveCustomers();
	}
}
