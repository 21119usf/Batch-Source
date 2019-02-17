package com.bankapp.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.bankapp.account.Account;
import com.bankapp.menu.Menu;
import com.bankapp.person.Customer;

public class CustomerUtils {
	private static Scanner sc = new Scanner(System.in);
	private static String customersFile = "Customers.ser";
	private static ArrayList<Customer> customers = new ArrayList<Customer>();
	private static Customer currentCustomer;
	
	// Load customers from file
	@SuppressWarnings("unchecked")
	public static void loadCustomers() {
		try {
			FileInputStream cf = new FileInputStream(customersFile);
			ObjectInputStream ois = new ObjectInputStream(cf);
			customers = (ArrayList<Customer>)ois.readObject();
			ois.close();
			cf.close();
		} catch (FileNotFoundException e) {
			//e.printStackTrace();
		} catch (IOException e) {
			//e.printStackTrace();
		} catch (ClassNotFoundException e) {
			//e.printStackTrace();
		}
	}
	
	// Save customers to file
	public static void saveCustomers() {
		try {
			FileOutputStream cf = new FileOutputStream(customersFile);
			ObjectOutputStream oos = new ObjectOutputStream(cf);
			oos.writeObject(customers);
			oos.close();
			cf.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// Return customer by id
	public static Customer getCustomer(int id) {
		for (Customer c : customers) {
			if (c.getId() == id) {
				return c;
			}
		}
		return null;
	}
	
	// Display login
	public static void displayLogin() {
		int loginCount = 0;
		boolean notValidLogin = true;
		
		// Three tries to login
		String username;
		String password;
		do {
			System.out.println("Enter Username: ");
			System.out.print(">>> ");
			username = sc.nextLine();
			System.out.println("Password: ");
			System.out.print(">>> ");
			password = sc.nextLine();
			
			// Validate
			currentCustomer = validateLogin(username, password);
			if (currentCustomer != null) {
				notValidLogin = false;
				System.out.println("Credentials accepted. Logging in.");
				displayCustomerLanding();
			} else {
				loginCount++;
			}
		} while (notValidLogin && loginCount < 3);
		
		// Exit application if login fails 3 times
		if (loginCount == 3) {
			System.out.println("Three invalid attempts. Bye.");
			System.exit(0);
		}
	}
	
	// Validate login
	private static Customer validateLogin(String un, String pw) {
		// Customer login
		for (Customer c : customers) {
			if (c.getUsername().equals(un)) {
				if (c.getPassword().equals(pw)) {
					return c;
				} else {
					System.out.println("Invalid credentials.");
					return null;
				}
			}
		}
		System.out.println("No user \"" + un + "\" found.");
		return null;
	}
	
	// Display registration page
	public static void displayRegistration() {
		String username = "";
		String password = "";
		String firstName = "";
		String lastName = "";
		long phoneNumber = 0L;
		String email = "";
		long ssNumber = 0L;
		String address = "";
		
		System.out.println("Enter some personal account information:");
		
		// Username
		boolean notValidUsername = true;
		do {
			System.out.println("Enter a username");
			System.out.print(">>> ");
			username = sc.nextLine();
			if (validUsername(username)) {
				notValidUsername = false;
			} else {
				System.out.println("Username invalid or taken.");
			}
		} while (notValidUsername);
		
		// Password
		boolean notValidPassword = true;
		String p0, p1;
		do {
			System.out.println("Enter a password");
			System.out.print(">>> ");
			p0 = sc.nextLine();
			if (validPassword(p0)) {
				System.out.println("Confirm password: ");
				System.out.print(">>> ");
				p1 = sc.nextLine();
				if (p0.equals(p1)) {
					password = p0;
					notValidPassword = false;
				} else {
					System.out.println("Mismatched passwords.");
				}
			}
		} while (notValidPassword);
		
		// First and last names, email and address
		System.out.println("Enter your first name: ");
		System.out.print(">>> ");
		firstName = sc.nextLine();
		System.out.println("Enter your last name: ");
		System.out.print(">>> ");
		lastName = sc.nextLine();
		System.out.println("Enter your email address: ");
		System.out.print(">>> ");
		email = sc.nextLine();
		System.out.println("Enter your full address: ");
		System.out.print(">>> ");
		address = sc.nextLine();
		
		// Phone number
		boolean notValidPhoneNumber = true;
		do {
			System.out.println("Enter your phone number: ");
			System.out.print(">>> ");
			try {
				phoneNumber = sc.nextLong();
				if (validPhoneNumber(phoneNumber)) {
					notValidPhoneNumber = false;
				} else {
					System.out.println("Invalid phone number");
					sc.nextLine();
				}
			} catch (InputMismatchException e) {
				System.out.println("Numerals only, no hyphens.");
				sc.nextLine();		// Clear buffer
			}
		} while (notValidPhoneNumber);
		
		// Social security number
		boolean notValidSsNumber = true;
		do {
			System.out.println("Enter your social security number: ");
			System.out.print(">>> ");
			try {
				ssNumber = sc.nextLong();
				if (validSsNumber(ssNumber)) {
					notValidSsNumber = false;
				} else {
					System.out.println("Invalid social security number.");
					sc.nextLine();
				}
			} catch (InputMismatchException e) {
				System.out.println("Numerals only, no hyphens.");
				sc.nextLine();		// Clear buffer
			}
		} while (notValidSsNumber);
		sc.nextLine();
		
		// Create Customer object and store data
		Customer c = new Customer(username, password, firstName, lastName, 
		email, address, phoneNumber, ssNumber);
		customers.add(c);
		saveCustomers();
		
		// Redirect
		displayLogin();
	}
	
	// Validate username
	private static boolean validUsername(String un) {
		//boolean validUsername = false;
		
		if (un.length() < 6) {
			return false;
		}
		// Open Customer data file and check for taken username

		return true;
	}
	
	// Validate password
	private static boolean validPassword(String pw) {
		if (pw.length() < 6) {
			return false;
		} else {
			return true;
		}
	}
	
	// Validate phone number
	private static boolean validPhoneNumber(long pn) {
		if (String.valueOf(pn).length() != 10) {
			return false;
		} else {
			return true;
		}
	}
	
	// Validate social security number
	private static boolean validSsNumber(long ss) {
		if (String.valueOf(ss).length() != 9) {
			return false;
		}
		return true;
	}
	
	// Display customer accounts page
	public static void displayCustomerLanding() {
		int option = 0;
		
		ArrayList<String> al = new ArrayList<String>();
		al.add("Exit");
		al.add("Accounts");
		al.add("Personal Information");
		Menu m = new Menu(al);
		option = m.display();
		
		// Redirect
		switch (option) {
		case 1:
			displayCustomerAccounts();
			break;
		case 2:
			displayCustomerInfo();
			break;
		case 0:
			System.out.println("Logging out.");
			System.exit(0);
		default:
			System.out.println("Logging out.");
			System.exit(0);
		}
	}
	
	// Display currentCustomer accounts
	public static void displayCustomerAccounts() {
		int option = 0;
		ArrayList<Account> accounts = currentCustomer.getAccounts();
		
		ArrayList<String> al = new ArrayList<String>();
		al.add("Back");
		al.add(">>> Open Account <<<");
		for (Account a : accounts) {
			al.add(a.getName());
		}
		
		Menu m = new Menu(al);
		option = m.display();
		
		// Redirect
		if (option == 0) {
			CustomerUtils.displayCustomerLanding();
		} else if (option == 1) {
			AccountUtils.displayOpenAccount(currentCustomer);
		} else {
			AccountUtils.displayAccountMenu(accounts.get(option-2));
		}
	}
	
	// Display currentCustomer personal info
	private static void displayCustomerInfo() {
		System.out.println("Your ID:\t\t" + currentCustomer.getId());
		System.out.println("Your username:\t\t" + currentCustomer.getUsername());
		System.out.println("Your password:\t\t" + currentCustomer.getPassword());
		System.out.println("Your phone number:\t" + currentCustomer.getPhoneNumber());
		System.out.println("Your email:\t\t" + currentCustomer.getEmail());
		displayCustomerLanding();
	}
}
