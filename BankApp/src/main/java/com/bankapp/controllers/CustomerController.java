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

public class CustomerController {
	final static Logger logger = Logger.getLogger(CustomerController.class);
	@SuppressWarnings("unused")
	private static AccountController ac = AccountController.getInstance();
	private static CustomerController instance;
	private static Scanner sc = new Scanner(System.in);
	private static String customersFile = "Customers.ser";
	private static ArrayList<Customer> customers = new ArrayList<Customer>();
	private static Customer currentCustomer;
	
	// Constructor
	private CustomerController() {
		loadCustomers();
	}
	
	// Return singleton instance
	public static synchronized CustomerController getInstance() {
		if (instance == null) {
			instance = new CustomerController();
		}
		return instance;
	}
	
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
	
	// Display customer entry page
	public void displayCustomerEntry() {
		ArrayList<String> al = new ArrayList<String>();
		al.add("Back");
		al.add("Customer Login");
		al.add("Register");
		Menu m = new Menu(al);
		int option = m.display();
		
		// Redirect
		switch (option) {
		case 0:
			return;
		case 1:
			CustomerController.displayLogin();
			break;
		case 2:
			CustomerController.displayRegistration();
			break;
		default:
			displayLanding();
			break;
		}
	}
	
	// Display login
	public static void displayLogin() {
		int loginCount = 0;
		boolean notValidLogin = true;
		
		// Three tries to login
		String username;
		String password;
		while (notValidLogin && loginCount < 3) {
			System.out.println();
			System.out.println("Please Login");
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
				logger.info("CUSTOMER " + currentCustomer.getId() +
					" logged in");
				displayLanding();
			} else {
				loginCount++;
			}
		}
		
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
		
		System.out.println("Enter some personal account information:");
		
		// Username
		boolean notValidUsername = true;
		while (notValidUsername) {
			System.out.println("Enter a username");
			System.out.print(">>> ");
			username = sc.nextLine();
			if (validUsername(username)) {
				notValidUsername = false;
			} else {
				System.out.println("Username invalid or taken.");
			}
		}
		
		// Password
		boolean notValidPassword = true;
		String p0, p1;
		while (notValidPassword) {
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
		}
		
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
		
		// Phone number
		boolean notValidPhoneNumber = true;
		while (notValidPhoneNumber) {
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
		}
		
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
		email, phoneNumber, ssNumber);
		customers.add(c);
		saveCustomers();
		logger.info("CUSTOMER " + c.getId()
		+ " created");
		
		// Redirect
		displayLogin();
	}
	
	// Validate username
	private static boolean validUsername(String un) {
		// Username should be at least 6 characters
		if (un.length() < 6) {
			System.out.println("Username must be at least 6 characters.");
			return false;
		}
		
		// Open Customer data file and check for taken username
		for (Customer c : customers) {
			if (c.getUsername().equals(un)) {
				return false;
			}
		}

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
	
	// Display customer landing page
	public static void displayLanding() {
		int option = 0;
		
		while (true) {
			ArrayList<String> al = new ArrayList<String>();
			al.add("Exit");
			al.add("Accounts");
			al.add("View Personal Information");
			al.add("Edit Personal Information");
			Menu m = new Menu(al);
			option = m.display();
			
			// Redirect
			switch (option) {
			case 0:
				if (currentCustomer != null) {
					System.out.println("Logging out.");
					logger.info("CUSTOMER " + currentCustomer.getId()
						+ " logged out");
				}
				return;
			case 1:
				displayAccounts();
				break;
			case 2:
				printCustomerInfo(currentCustomer);
				break;
			case 3:
				editCustomerInfo();
				break;
			}
		}
	}
	
	// Display currentCustomer accounts
	public static void displayAccounts() {
		int option = 0;
		ArrayList<Integer> acctIds = currentCustomer.getAccounts();
		
		ArrayList<String> al = new ArrayList<String>();
		al.add("Back");
		al.add(">>> Open Account <<<");
		for (Integer id : acctIds) {
			al.add(Integer.toString(id));
		}
		
		Menu m = new Menu(al);
		option = m.display();
		
		// Redirect
		if (option == 0) {
			//displayLanding();
			return;
		} else if (option == 1) {
			AccountController.displayOpenAccount(currentCustomer);
		} else {
			Account a = AccountController.getAccount(acctIds.get(option-2));
			AccountController.displayAccountMenu(a);
		}
	}
	
	// Display currentCustomer personal info
	public static void printCustomerInfo(Customer c) {
		System.out.println();
		System.out.println("Your ID:\t\t\t" + c.getId());
		System.out.println("Your username:\t\t" + c.getUsername());
		System.out.println("Your password:\t\t" + c.getPassword());
		System.out.println("Your phone number:\t" + c.getPhoneNumber());
		System.out.println("Your email:\t\t\t" + c.getEmail());
		return;
	}
	
	// Edit currentCustomer personal info
	private static void editCustomerInfo() {
		int option = 0;
		
		ArrayList<String> al = new ArrayList<String>();
		al.add("Back");
		al.add("Edit Password");
		al.add("Edit First Name");
		al.add("Edit Last Name");
		al.add("Edit Email");
		al.add("Edit Phone Number");
		Menu m = new Menu(al);
		option = m.display();
		
		if (option == 0) {
			return;
		} else if (option == 1) {
			// password
		} else if (option == 2) {
			System.out.println("Enter First Name:");
			System.out.print(">>> ");
			String s = sc.nextLine();
			currentCustomer.setFirstName(s);
		} else if (option == 3) {
			System.out.println("Enter Last Name:");
			System.out.print(">>> ");
			String s = sc.nextLine();
			currentCustomer.setLastName(s);
		} else if (option == 4) {
			System.out.println("Enter Email:");
			System.out.print(">>> ");
			String s = sc.nextLine();
			currentCustomer.setEmail(s);
		} else if (option == 5) {
			boolean notValidPhoneNumber = true;
			long phoneNumber = currentCustomer.getPhoneNumber();
			while (notValidPhoneNumber) {
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
			}
			currentCustomer.setPhoneNumber(phoneNumber);
		}
		saveCustomers();
	}
}
