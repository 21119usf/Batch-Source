package com.revature.bap1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bank {
	
	private Map<Customer, Account> hashMap;
	private List<String> applicationList;
	private List<Employee> employeeList;
	private List<Admin> adminList;
	
	private String currentUsername;
	private String currentFirstNameAndLastName;
	private int userRights;
	
	private static final String SER_FILE = "file.ser";
	
	public Bank() {
		hashMap = new HashMap<Customer, Account>();
		applicationList = new ArrayList<String>();
		employeeList = new ArrayList<Employee>();
		adminList = new ArrayList<Admin>();
	}
	
	public void readFile() {
		File file = new File(SER_FILE);
		
		if (file.exists()) {
			try {
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(SER_FILE));
				
				hashMap = (HashMap<Customer, Account>) ois.readObject();
				applicationList = (ArrayList<String>) ois.readObject();
				employeeList = (ArrayList<Employee>) ois.readObject();
				adminList = (ArrayList<Admin>) ois.readObject();
				
				ois.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		displayCustomer();
		adminList.add(new Admin("a", "a", "a", "a"));
		adminList.add(new Admin("admin", "password", "Master", "Admin"));
	}
	
	public void writeFile() {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SER_FILE));
			
			oos.writeObject(hashMap);
			oos.writeObject(applicationList);
			oos.writeObject(employeeList);
			oos.writeObject(adminList);
			
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void displayCustomer() {
		for (Map.Entry<Customer, Account> entry : hashMap.entrySet()) {
			System.out.println(entry.getKey());
		}
	}
	
	public void displayEmployee() {
		for (Employee e : employeeList) {
			System.out.println(e);
		}
	}
	
	public void displayAdmin() {
		for (Admin a : adminList) {
			System.out.println(a);
		}
	}
	
	public void displayAccount() {
		for (Map.Entry<Customer, Account> entry : hashMap.entrySet()) {
			if (entry.getValue() != null) {
				System.out.println(entry.getValue());
			}
		}
	}
	
	public void displayApplication() {
		for (String s : applicationList) {
			System.out.println(applicationList);
		}
	}
	
	public String getCurrentFirstNameAndLastName() {
		return this.currentFirstNameAndLastName;
	}
	
	public int getUserRigts() {
		return this.userRights;
	}
	
	public void registerCustomer(String username, String password, String firstName, String lastName) {
		Customer c = new Customer(username, password, firstName, lastName);
		hashMap.put(c, null);
	}
	
	public int login(String username, String password) {
		for (Map.Entry<Customer, Account> entry : hashMap.entrySet()) {
			if (entry.getKey().getUsername().equals(username) && entry.getKey().getPassword().equals(password)) {
				currentUsername = entry.getKey().getUsername();
				currentFirstNameAndLastName = entry.getKey().getFirstName() + " " + entry.getKey().getLastName();
				userRights = 1;
				return userRights;
			}
		}
		
		for (Employee e : employeeList) {
			if (e.getUsername().equals(username) && e.getPassword().equals(password)) {
				currentUsername = e.getUsername();
				currentFirstNameAndLastName = e.getFirstName() + " " + e.getLastName();
				userRights = 2;
				return userRights;
			}
		}
		
		for (Admin a : adminList) {
			if (a.getUsername().equals(username) && a.getPassword().equals(password)) {
				currentUsername = a.getUsername();
				currentFirstNameAndLastName = a.getFirstName() + " " + a.getLastName();
				userRights = 3;
				return userRights;
			}
		}
		
		return -1;
	}
	
	public void logout() {
		currentUsername = "";
		currentFirstNameAndLastName = "";
		userRights = 0;
	}
}
