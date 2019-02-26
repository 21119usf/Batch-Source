package com.bankapp.controllers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.bankapp.account.Account;
import com.bankapp.dao.AccountDaoImp;
import com.bankapp.dao.EmployeeDaoImp;
import com.bankapp.menu.Menu;
import com.bankapp.user.Admin;
import com.bankapp.user.Customer;
import com.bankapp.user.Employee;

public class EmployeeController {
	final static Logger logger = Logger.getLogger(EmployeeController.class);
	@SuppressWarnings("unused")
	private static AccountController ac = AccountController.getInstance();
	private static EmployeeController instance;
	private static Scanner sc = new Scanner(System.in);
	private static String employeesFile = "Employees.ser";
	private static ArrayList<Employee> employees = new ArrayList<Employee>();
	private static Employee currentEmployee;
	
	// Constructor
	private EmployeeController() {
		// loadEmployees();
	}
	
	// Return singleton instance
	public static synchronized EmployeeController getInstance() {
		if (instance == null) {
			instance = new EmployeeController();
		}
		return instance;
	}
	
	// Load employees from file
	@SuppressWarnings("unchecked")
	public static void loadEmployees() {
		try {
			FileInputStream ef = new FileInputStream(employeesFile);
			ObjectInputStream ois = new ObjectInputStream(ef);
			employees = (ArrayList<Employee>)ois.readObject();
			ois.close();
			ef.close();
		} catch (FileNotFoundException e) {
			System.out.println("Employee.ser not found");
		} catch (IOException e) {
			// e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// e.printStackTrace();
		}
	}
	
	// Save employees to file
	public static void saveEmployees() {
		try {
			FileOutputStream ef = new FileOutputStream(employeesFile);
			ObjectOutputStream oos = new ObjectOutputStream(ef);
			oos.writeObject(employees);
			oos.close();
			ef.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// Get employee by username
	public static Employee getEmployee(String un) {
		EmployeeDaoImp edi = new EmployeeDaoImp();
		try {
			Employee e = edi.getEmployee(un);
			return e;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	// Display employee entry page
	public void displayEmployeeEntry() {
		ArrayList<String> al = new ArrayList<String>();
		al.add("Back");
		al.add("Employee Login");
		al.add("Register");
		Menu m = new Menu(al);
		int option = m.display();
		
		// Redirect
		switch (option) {
		case 0:
			return;
		case 1:
			EmployeeController.displayLogin();
			break;
		case 2:
			EmployeeController.displayRegistration();
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
		do {
			System.out.println();
			System.out.println("Please Login");
			System.out.println("Enter Username: ");
			System.out.print(">>> ");
			username = sc.nextLine();
			System.out.println("Password: ");
			System.out.print(">>> ");
			password = sc.nextLine();
			
			// Validate
			currentEmployee = validateLogin(username, password);
			if (currentEmployee != null) {
				notValidLogin = false;
				System.out.println("Credentials accepted. Logging in.");
				logger.info("EMPLOYEE " + currentEmployee.getId()
					+ " logged in");
				displayLanding();
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
	private static Employee validateLogin(String un, String pw) {
		// Employee login
		Employee e = getEmployee(un);
		if (e != null && e.getUsername().equals(un)) {
			if (e.getPassword().equals(pw)) {
				return e;
			} else {
				System.out.println("Invalid credentials.");
				return null;
			}
		}
		System.out.println("No user \"" + un + "\" found.");
		return null;
	}
	
	// Register employee
	public static void displayRegistration() {
		String username = "";
		String password = "";
		
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
		
		// Admin?
		System.out.println("Is this an Admin account?");
		ArrayList<String> al = new ArrayList<String>();
		boolean isAdmin = false;
		al.add("Yes");
		al.add("No");
		Menu m = new Menu(al);
		int option = m.display();
		if (option == 0) {
			isAdmin = true;
		}
		
		// Create Employee/Admin object and store data
		Employee e;
		if (isAdmin) {
			e = new Admin(username, password);
			employees.add(e);
		} else {
			e = new Employee(username, password);
			employees.add(e);
		}
		EmployeeDaoImp edi = new EmployeeDaoImp();
		try {
			edi.addEmployee(e);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		logger.info("EMPLOYEE " + e.getId()
		+ " created");
		
		// Redirect
		displayLogin();
	}
	
	// Validate username
	private static boolean validUsername(String un) {
		// Username must be at least 6 characters
		if (un.length() < 6) {
			System.out.println("Username must be at least 6 characters.");
			return false;
		}
		
		// Open Customer data file and check for taken username
		for (Employee e : employees) {
			if (e.getUsername().equals(un)) {
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
	
	// Display customer accounts page
	public static void displayLanding() {
		int option = 0;
		
		while (true) {
			ArrayList<String> al = new ArrayList<String>();
			al.add("Exit");
			al.add("Approve Account");
			al.add("View Account Information");
			al.add("View Customer Information");
			if (currentEmployee instanceof Admin) {
				al.add("Edit Account");
			}
			Menu m = new Menu(al);
			option = m.display();
			
			// Redirect
			switch (option) {
			case 0:
				if (currentEmployee != null) {
					System.out.println("Logging out.");
					logger.info("EMPLOYEE " + currentEmployee.getId()
						+ " logged out");
				}
				return;
			case 1:
				approveAccount();
				break;
			case 2:
				displayAccountInfo();
				break;
			case 3:
				displayCustomerInfo();
				break;
			case 4:
				if (currentEmployee instanceof Admin) {
					displayAccountEditor();
				} else {
					System.out.println("Invalid option");
				}
				break;
			default:
				System.out.println("Logging out.");
				logger.info("EMPLOYEE " + currentEmployee.getId()
				+ " logged out");
				System.exit(0);
			}
		}
	}
	
	// Approve an account
	private static void approveAccount() {
		int id = 0;
		
		// Get account ID
		System.out.println();
		System.out.println("Enter account ID:");
		System.out.print(">>> ");
		if (sc.hasNextInt()) {
			id = sc.nextInt();
			sc.nextLine();    // Clear buffer
		} else {
			System.out.println("Invalid ID");
			sc.nextLine();
		}
		
		// Search account
		Account a = AccountController.getAccount(id);
		if (a != null) {
			a.setOpen(true);
			System.out.println("Account opened!");
			AccountDaoImp adi = new AccountDaoImp();
			try {
				adi.updateAccount(a);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Account not found");
		}
		
		return;
	}
	
	// Display account information
	private static void displayAccountInfo() {
		int id = 0;
		
		// Get account ID
		System.out.println();
		System.out.println("Enter account ID:");
		System.out.print(">>> ");
		if (sc.hasNextInt()) {
			id = sc.nextInt();
			sc.nextLine();    // Clear buffer
		} else {
			System.out.println("Invalid ID");
			sc.nextLine();
		}
		
		// Print account details
		Account a = AccountController.getAccount(id);
		if (a == null) {
			System.out.println("Account " + id + " doesn't exist");
			return;
		}
		AccountDaoImp adi = new AccountDaoImp();
		ArrayList<Integer> al = null;
		try {
			al = adi.getCustomers(a);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println();
		System.out.println("Account ID:\t" + a.getId());
		System.out.println("Open:\t\t" + a.isOpen());
		System.out.println("Balance:\t$" + String.format("%.2f", a.getBalance()));
		System.out.print("Owners:\t\t");
		for (Integer i : al) {
			System.out.print(CustomerController.getCustomer(i).getUsername());
			System.out.print(" ");
		}
		System.out.println();
		
		return;
	}
	
	// Display customer information
	private static void displayCustomerInfo() {
		int id = 0;
		
		// Get customer ID
		System.out.println("Enter customer ID:");
		System.out.print(">>> ");
		if (sc.hasNextInt()) {
			id = sc.nextInt();
			sc.nextLine();    // Clear buffer
		} else {
			System.out.println("Invalid ID");
			sc.nextLine();
		}
		
		// Search customer
		Customer c = CustomerController.getCustomer(id);
		if (c != null) {
			System.out.println();
			System.out.println("Your ID:\t\t\t" + c.getId());
			System.out.println("Your username:\t\t" + c.getUsername());
			System.out.println("Your password:\t\t" + c.getPassword());
			System.out.println("Your phone number:\t" + c.getPhoneNumber());
			System.out.println("Your email:\t\t\t" + c.getEmail());
			return;
		} else {
			System.out.println("Account not found");
		}
		
		return;
	}
	
	// Admin account editor
	private static void displayAccountEditor() {
		int id = 0;
		
		// Get account ID
		System.out.println("Enter account ID:");
		System.out.print(">>> ");
		if (sc.hasNextInt()) {
			id = sc.nextInt();
			sc.nextLine();    // Clear buffer
		} else {
			System.out.println("Invalid ID");
			sc.nextLine();
		}
		
		// Search account
		Account a = AccountController.getAccount(id);
		if (a != null) {
			int option = 0;
			
			ArrayList<String> al = new ArrayList<String>();
			al.add("Back");
			al.add("Deposit");
			al.add("Withdraw");
			al.add("Transfer Funds");
			al.add("View Details");
			al.add(">>> Close Account <<<");
			
			Menu m = new Menu(al);
			option = m.display();
			
			// Redirect
			if (option == 0) {
				displayLanding();
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
		} else {
			System.out.println("Account not found");
		}
		
		return;
	}
}
