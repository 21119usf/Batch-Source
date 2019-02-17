package com.bankapp.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import com.bankapp.person.Employee;

public class EmployeeUtils {
	private static Scanner sc = new Scanner(System.in);
	private static String employeesFile = "Employees.ser";
	private static ArrayList<Employee> employees = new ArrayList<Employee>();
	
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
			if (validateLogin(username, password) != null) {
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
	}
	
	// Validate login
	private static Employee validateLogin(String un, String pw) {
		// Employee login
		for (Employee e : employees) {
			if (e.getUsername().equals(un)) {
				if (e.getPassword().equals(pw)) {
					System.out.println("Logged in!");
					return e;
				} else {
					System.out.println("Invalid credentials.");
					return null;
				}
			}
		}
		System.out.println("No user \"" + un + "\" found.");
		return null;
	}
	
	// Register employee
	public static void displayRegistration() {
		String username = "";
		String password = "";
		String firstName = "";
		String lastName = "";
		
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
		
		// Create Customer object and store data
		Employee e = new Employee(username, password, firstName, lastName);
		employees.add(e);
		saveEmployees();
		
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
}
