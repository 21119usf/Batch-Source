package com.reavature.service;

import java.util.ArrayList;
import java.util.Scanner;

import org.mindrot.jbcrypt.BCrypt;

import com.revature.beans.Admin;
import com.revature.beans.Customer;
import com.revature.beans.Employee;
import com.revature.beans.User;
import com.revature.io.FileIO;

public class UserService {
	public static void createAdmin() {
		System.out.println("Please Create An Admin Account");
		Scanner in = new Scanner(System.in);
		String firstName;
		String lastName;
		String SSN;
		String email;
		String address;
		String username;
		String password;
		String hash;
		System.out.println("First Name: ");
		firstName = in.nextLine();
		System.out.println("Last Name: ");
		lastName = in.nextLine();
		System.out.println("Social Security Number: ");
		SSN = in.nextLine();
		System.out.println("Email: ");
		email = in.nextLine();
		System.out.println("Address");
		address = in.nextLine();
		System.out.println("Username");
		username = in.nextLine();
		System.out.println("Password: ");
		password = in.nextLine();
		try {
			validateUsername(username);
			validatePassword(password);
			validateSSN(SSN);
			hash = BCrypt.hashpw(password, BCrypt.gensalt());
			ArrayList<User> users = FileIO.getFromFile("users.txt");
			Admin admin = new Admin(firstName, lastName, SSN, email, address, username, hash, users.size());
			users.add(admin);
			FileIO.savedata(users, "users.txt");
		} catch (ValidationException e) {
			System.out.println(e.getMessage());
			System.out.println("Please try again");
			createAdmin();
		}
	}
	
	public static Customer createCustomer() {
		Scanner in = new Scanner(System.in);
		String firstName;
		String lastName;
		String SSN;
		String email;
		String address;
		String username;
		String hash;
		System.out.println("First Name: ");
		firstName = in.nextLine();
		System.out.println("Last Name: ");
		lastName = in.nextLine();
		System.out.println("Social Security Number: ");
		SSN = in.nextLine();
		System.out.println("Email: ");
		email = in.nextLine();
		System.out.println("Address");
		address = in.nextLine();
		System.out.println("Username");
		username = in.nextLine();
		System.out.println("Password: ");
		hash = BCrypt.hashpw(in.nextLine(), BCrypt.gensalt());
		ArrayList<User> users = FileIO.getFromFile("users.txt");
		Customer cus = new Customer(firstName, lastName, SSN, email, address, username, hash, users.size());
		users.add(cus);
		FileIO.savedata(users, "users.txt");
		return cus;
	}
	
	public static void createEmployee() {
		Scanner in = new Scanner(System.in);
		String firstName;
		String lastName;
		String SSN;
		String email;
		String address;
		String username;
		String password;
		String hash;
		System.out.println("First Name: ");
		firstName = in.nextLine();
		System.out.println("Last Name: ");
		lastName = in.nextLine();
		System.out.println("Social Security Number: ");
		SSN = in.nextLine();
		System.out.println("Email: ");
		email = in.nextLine();
		System.out.println("Address");
		address = in.nextLine();
		System.out.println("Username");
		username = in.nextLine();
		System.out.println("Password: ");
		password = in.nextLine();
		try {
			validateUsername(username);
			validatePassword(password);
			validateSSN(SSN);
			hash = BCrypt.hashpw(password, BCrypt.gensalt());
			ArrayList<User> users = FileIO.getFromFile("users.txt");
			Employee admin = new Employee(firstName, lastName, SSN, email, address, username, hash, users.size());
			users.add(admin);
			FileIO.savedata(users, "users.txt");
		} catch (ValidationException e) {
			System.out.println(e.getMessage());
			System.out.println("Please try again");
			createAdmin();
		}
	}
	
	private static void validateUsername(String username) throws ValidationException {
		if (username.length() < 8) {
			throw new ValidationException("username must be at lease 8 characters long");
		}
		if (username.length() > 25 ) {
			throw new ValidationException("username must be less then 25 characters long");
		}
	}
	
	private static void validatePassword(String password) throws ValidationException {
		if (password.length() < 8) {
			throw new ValidationException("password must be at lease 8 characters long");
		}
		if (password.length() > 25 ) {
			throw new ValidationException("password must be less then 25 characters long");
		}
	}
	
	private static void validateSSN(String SSN) throws ValidationException {
		if (SSN.length() != 9) {
			throw new ValidationException("Social Security Number must be 9 digts");
		}
	}
	
	public static User getUserBuUsername(String username) throws ValidationException {
		ArrayList<User> users = FileIO.getFromFile("users.txt");
		for (User x: users) {
			if (x.getUsername().equals(username)) {
				return x;
			}
		}
		throw new ValidationException("Invalid Username");
	}
	
	public static User getUserById(int id) throws ValidationException {
		ArrayList<User> users = FileIO.getFromFile("users.txt");
		for (User x: users) {
			if (x.getUserId() == id) {
				return x;
			}
		}
		throw new ValidationException("Invalid ID");
	}
	
	public static User login() {
		Scanner in = new Scanner(System.in);
		String username;
		String password;
		System.out.println("Username: ");
		username = in.nextLine();
		System.out.println("Password: ");
		password = in.nextLine();
		try {
			validateUsername(username);
			User u = getUserBuUsername(username);
			validatePassword(password);
			if (BCrypt.checkpw(password, u.getHash()) == false) {
				throw new ValidationException("Invalid Login");
			}
			return u;
		} catch (ValidationException e) {
			System.out.println(e.getMessage());
			System.out.println("Invalid Login");
			login();
		}
		return null;
	}
	
	public void updateUser(User u) {
		ArrayList<User> users = FileIO.getFromFile("accounts.txt");
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getUserId() == u.getUserId()) {
				users.set(i, u);
			}
		}
		FileIO.savedata(users, "accounts.txt");
	}
	
	public Employee getEmplyoee(int employeeId) throws ValidationException {
		User u = getUserById(employeeId);
		if (u instanceof Employee) {
			return (Employee) u;
		} else {
			throw new ValidationException("Id Provided Is Not An Empolyee Id");
		}
	}
	
	public Customer getCustomer(int customerId) throws ValidationException {
		User u = getUserById(customerId);
		if (u instanceof Customer) {
			return (Customer) u;
		} else { 
			throw new ValidationException("Customer Id Provided Is Not For A Customer");
		}
		
	}
	
	public void addCustomerToEmployee(int customerId, int employeeId) throws ValidationException {
		Customer customer = getCustomer(customerId);
		Employee e = getEmplyoee(employeeId);
		ArrayList<Integer> clinets = e.getClients();
		clinets.add(customer.getUserId());
		updateUser(e);
	}
}
