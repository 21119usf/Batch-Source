package com.bankapp.driver;

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
import com.bankapp.person.Customer;
import com.bankapp.person.Employee;

// Driver class for BankApp
public class Driver {
	private static String employeesFile = "Employees.ser";
	private static String customersFile = "Customers.ser";
	private static String accountsFile = "Accounts.ser";
	private static ArrayList<Employee> employees = new ArrayList<Employee>();
	private static ArrayList<Customer> customers = new ArrayList<Customer>();
	private static ArrayList<Account> accounts = new ArrayList<Account>();
	private static Scanner sc = new Scanner(System.in);
	
	// Save customers to file
	private static void saveCustomers() {
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
	
	// Load customers from file
	@SuppressWarnings("unchecked")
	private static void loadCustomers() {
		try {
			FileInputStream cf = new FileInputStream(customersFile);
			ObjectInputStream ois = new ObjectInputStream(cf);
			customers = (ArrayList<Customer>)ois.readObject();
			ois.close();
			cf.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	// Display landing page and get desired option
	private static int displayLanding() {
		boolean notValidOption = true;
		int option = 0;
		
		// Continue until valid option
		do {
			System.out.println("1. Login");
			System.out.println("2. Register");
			System.out.println();
			System.out.println("0. Exit");
			
			try {
				option = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Invalid option. Try again.");
				sc.nextLine();
			}
			
			if (option == 1 || option == 2 || option == 0) {
				notValidOption = false;
				sc.nextLine();	// Clear buffer
			} else {
				System.out.println("Invalid option. Try again.");
			}
		} while (notValidOption);
		
		return option;
	}
	
	// Display login page
	private static void displayLogin() {
		int loginCount = 0;
		boolean notValidLogin = true;
		
		// Three tries to login
		String username;
		String password;
		do {
			System.out.print("Username: ");
			username = sc.nextLine();
			System.out.print("Password: ");
			password = sc.nextLine();
			
			// Validate
			if (validateLogin(username, password)) {
				notValidLogin = false;
				System.out.println("Credentials accepted. Logging in.");
			} else {
				System.out.println("Invalid credentials.");
				loginCount++;
			}
		} while (notValidLogin && loginCount < 3);
		
		// Exit application if login fails 3 times
		if (loginCount == 3) {
			System.out.println("Three invalid attempts. Bye.");
			System.exit(0);
		}
	}
	
	// Validate login credentials
	private static boolean validateLogin(String un, String pw) {
		boolean isValid = false;
		
		// Open Customer data file and check credentials
		
		return isValid;
	}
	
	// Display registration page
	private static void displayRegistration() {
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
			System.out.println("(Must be greater than 5 characters)");
			System.out.print("Username: ");
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
			System.out.println("(Must be greater than 5 characters)");
			System.out.print("Password: ");
			p0 = sc.nextLine();
			if (validPassword(p0)) {
				System.out.print("Confirm password: ");
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
		System.out.print("Enter your first name: ");
		firstName = sc.nextLine();
		System.out.print("Enter your last name: ");
		lastName = sc.nextLine();
		System.out.print("Enter your email address: ");
		email = sc.nextLine();
		System.out.print("Enter your full address: ");
		address = sc.nextLine();
		
		// Phone number
		boolean notValidPhoneNumber = true;
		do {
			System.out.print("Enter your phone number: ");
			try {
				phoneNumber = sc.nextLong();
				if (validPhoneNumber(phoneNumber)) {
					notValidPhoneNumber = false;
				} else {
					System.out.println("Invalid phone number");
				}
			} catch (InputMismatchException e) {
				System.out.println("Numerals only, no hyphens.");
				sc.nextLine();		// Clear buffer
			}
		} while (notValidPhoneNumber);
		
		// Social security number
		boolean notValidSsNumber = true;
		do {
			System.out.print("Enter your social security number: ");
			try {
				ssNumber = sc.nextLong();
				if (validSsNumber(ssNumber)) {
					notValidSsNumber = false;
				} else {
					System.out.println("Invalid social security number.");
				}
			} catch (InputMismatchException e) {
				System.out.println("Numerals only, no hyphens.");
				sc.nextLine();		// Clear buffer
			}
		} while (notValidSsNumber);
		
		// Create Customer object and store data
		Customer c = new Customer(username, password, firstName, lastName, 
		email, address, phoneNumber, ssNumber);
		customers.add(c);
		saveCustomers();
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
		} else {
			return true;
		}
	}
	
	// Main
	public static void main(String[] args) {
		// Load Customer data from file
		loadCustomers();
		
		// Load Account data from file
		
		// Landing page
		int option = 0;
		option = displayLanding();
		
		// Redirect
		switch (option) {
		case 1:		// Login
			displayLogin();
			break;
		case 2:		// Register
			displayRegistration();
			break;
		case 0:		// Exit
			System.out.println("Goodbye");
			return;
		default:
			System.out.println("Goodbye");
			return;
		}
	}
}
