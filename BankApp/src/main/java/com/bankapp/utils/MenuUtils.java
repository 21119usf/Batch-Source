package com.bankapp.utils;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.bankapp.person.Customer;
import com.bankapp.person.Employee;

public class MenuUtils {
	private static Customer currentCustomer;
	private static Employee currentEmployee;
	private static Scanner sc = new Scanner(System.in);
	
	// Display landing page and get desired option
	public static int displayLanding() {
		boolean notValidOption = true;
		int option = 0;
		
		// Continue until valid option
		do {
			System.out.println("1. Customer");
			System.out.println("2. Employee");
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
	
	// Display customer entry page
	public static void displayCustomerEntry() {
		boolean notValidOption = true;
		int option = 0;
		
		// Continue until valid option
		do {
			System.out.println("1. Customer Login");
			System.out.println("2. Register");
			System.out.println("0. Back");
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
		
		// Redirect
		switch (option) {
		case 1:
			displayLogin(1);
			break;
		case 2:
			displayRegistration();
			break;
		case 0:
			displayLanding();
			break;
		default:
			displayLanding();
			break;
		}
	}
	
	// Display employee entry page
	public static void displayEmployeeEntry() {
		boolean notValidOption = true;
		int option = 0;
		
		// Continue until valid option
		do {
			System.out.println("1. Employee Login");
			System.out.println("0. Back");
			System.out.print(">>> ");
			
			try {
				option = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Invalid option. Try again.");
				sc.nextLine();
			}
			
			if (option == 1 || option == 0) {
				notValidOption = false;
				sc.nextLine();	// Clear buffer
			} else {
				System.out.println("Invalid option. Try again.");
			}
		} while (notValidOption);
		
		// Redirect
		switch (option) {
		case 1:
			displayLogin(2);
			break;
		case 0:
			displayLanding();
			break;
		default:
			displayLanding();
			break;
		}
	}
	
	// Display login page. flag: 1 = Customer, 2 = Employee
	public static void displayLogin(int flag) {
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
			if (validateLogin(username, password, flag)) {
				notValidLogin = false;
				System.out.println("Credentials accepted. Logging in.");
			} else {
				loginCount++;
			}
		} while (notValidLogin && loginCount < 3);
		
		// Exit application if login fails 3 times
		if (loginCount == 3) {
			System.out.println("Three invalid attempts. Bye.");
			System.exit(0);
		}
		
		// Redirect
		switch (flag) {
		case 1:
			displayCustomerAccounts(currentCustomer);
			break;
		case 2:
			displayEmployeeMenu();
			break;
		default:
			displayLanding();
			break;
		}
	}
	
	// Validate login credentials
	private static boolean validateLogin(String un, String pw, int flag) {
		// Customer login
		if (flag == 1) {
			for (Customer c : CustomerUtils.customers) {
				if (c.getUsername().equals(un)) {
					if (c.getPassword().equals(pw)) {
						currentCustomer = c;
						System.out.println("Logged in!");
						return true;
					} else {
						System.out.println("Invalid credentials.");
						return false;
					}
				}
			}
			System.out.println("No user \"" + un + "\" found.");
		}
		// Employee login
		else if (flag == 2) {
			for (Employee e : EmployeeUtils.employees) {
				if (e.getUsername().equals(un)) {
					if (e.getPassword().equals(pw)) {
						currentEmployee = e;
						System.out.println("Logged in!");
						return true;
					} else {
						System.out.println("Invalid credentials.");
						return false;
					}
				}
			}
			System.out.println("No user \"" + un + "\" found.");
		}
		return false;
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
	
	// Display customer accounts page
	private static void displayCustomerAccounts(Customer c) {
		
	}
	
	// Display employee menu page
	private static void displayEmployeeMenu() {
		
	}
}
