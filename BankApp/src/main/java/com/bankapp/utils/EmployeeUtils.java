package com.bankapp.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import com.bankapp.person.Customer;
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
			
		} catch (ClassNotFoundException e) {
			
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
}
