package com.bankapp.driver;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.bankapp.account.Account;
import com.bankapp.utils.AccountUtils;
import com.bankapp.person.Customer;
import com.bankapp.utils.CustomerUtils;
import com.bankapp.person.Employee;
import com.bankapp.utils.EmployeeUtils;

// Driver class for BankApp
public class Driver {
	private static Scanner sc = new Scanner(System.in);
	
	// Display landing page and get desired option
	private static int displayLanding() {
		boolean notValidOption = true;
		int option = 0;
		
		// Continue until valid option
		do {
			System.out.println("1. Login");
			System.out.println("2. Register");
			System.out.println("0. Exit");
			System.out.print(">>> ");
			
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
				}
			} catch (InputMismatchException e) {
				System.out.println("Numerals only, no hyphens.");
				sc.nextLine();		// Clear buffer
			}
		} while (notValidSsNumber);
		
		// Create Customer object and store data
		Customer c = new Customer(username, password, firstName, lastName, 
		email, address, phoneNumber, ssNumber);
		CustomerUtils.customers.add(c);
		CustomerUtils.saveCustomers();
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
		CustomerUtils.loadCustomers();
		
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
