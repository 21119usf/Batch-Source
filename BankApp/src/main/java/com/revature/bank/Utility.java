package com.revature.bank;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

import com.revature.beans.Account;
import com.revature.beans.Admin;
import com.revature.beans.Customer;
import com.revature.beans.Employee;
import com.revature.beans.User;
import com.revature.main.Driver;

public class Utility {
	/*
	 * This class provides utility functions used to help find accounts/users, print app state,
	 * setup new accounts and check username availability
	 */
	
	static Scanner sc = new Scanner(System.in);
	
	/*usernameExists
	 *  - 	Returns true when username exists in our data structure
	 * 		false if it doesn't
	 */
	public static boolean usernameExists(String s) {
		
		for(User u:Driver.users) {
			if(u.getUsername().equals(s))return true;
		}
		return false;
	}
	/*find
	 * 	-	Returns the User with the specified username 
	 */
	public static User findUser(String s) {
		for(User u:Driver.users) {
			if(u.getUsername().equals(s)) {
				return u;
			}
		}
		return null;
	}
	public static Account findAccount(int id) {
		for(Account a:Driver.accounts) {
			if(a.getId() == id) {
				return a;
			}
		}
		return null;
	}
	public static int nextAccountId() {
		boolean isAvailable = false;
		int i = Driver.accounts.size();
		while(!isAvailable) {
			if(findAccount(i) == null) {
				isAvailable=true;
			}
			else{
				i++;			
			}
		}
		return i;
	}
	
	public static int getIntFromSc() {
		boolean hasFailed = true;
		int n = 0;
		while(hasFailed) {
			try {
				n = Integer.parseInt(sc.nextLine());
				hasFailed = false;
			}catch(NumberFormatException e) {
				System.out.println("Invalid input, try again\n\t->");
			}
		}
		return n;
	}
	public static double getDoubleFromSc() {
		boolean hasFailed = true;
		double n = 0;
		while(hasFailed) {
			try {
				n = Double.parseDouble(sc.nextLine());
				hasFailed = false;
			}catch(NumberFormatException e) {
				System.out.println("Invalid input, try again\n\t->");
			}
		}
		return n;
	}
	public static void init() {
		Driver.users = new ArrayList<User>();
		Driver.accounts = new ArrayList<Account>();
		Driver.appQueue = new LinkedList<Customer>();
		Driver.users.add(new Employee("TheEmployee","emp","pass"));
		Driver.users.add(new Admin("TheBoss","boss","pass"));
	}
	
	public static void print(ArrayList<User> u) {
		System.out.println("users:");
		for(User p:u)System.out.println(p);
	}
	public static void print2(ArrayList<Account> u) {
		System.out.println("accounts:");
		for(Account p:u)System.out.println(p);
	}
	public static void print3(LinkedList<Customer> aq) {
		System.out.println("appqueue:");
		while(!aq.isEmpty()) {
			System.out.println(aq.remove().toString());
		}
	}

}
