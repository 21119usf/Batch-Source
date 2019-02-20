package com.revature.bap1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class UserManager {
	
	private List<User> userList;
	
	private static final String USER_FILE = "user.ser";
	
	public UserManager() {
		userList = new ArrayList<User>();
	}
	
	public void readFile() {
		File file = new File(USER_FILE);
		
		if (file.exists()) {
			try {
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(USER_FILE));
				userList = (ArrayList<User>) ois.readObject();
				ois.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void writeFile() {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(USER_FILE));
			oos.writeObject(userList);
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void displayUserList() {
		for (User u : userList) {
			System.out.println(u);
		}
	}
	
	public void registerCustomer(int accountCount, String username, String password, String firstName, String lastName) {
		userList.add(new Customer(accountCount, username, password, firstName, lastName));
	}
	
	public void createEmployee(int accountCount, String username, String password, String firstName, String lastName) {
		userList.add(new Employee(accountCount, username, password, firstName, lastName));
	}
	
	public void createAdmin(int accountCount, String username, String password, String firstName, String lastName) {
		userList.add(new Admin(accountCount, username, password, firstName, lastName));
	}
	
	public User login(String username, String password) {
		for (User u : userList) {
			if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
				return u;
			}
		}
		return null;
	}
}
