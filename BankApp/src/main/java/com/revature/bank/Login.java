package com.revature.bank;

import java.util.Scanner;

import com.revature.beans.Customer;
import com.revature.beans.User;
import com.revature.main.Driver;
/*
 * This class allows for customers to apply or for users to sign in to their accounts
 */
public class Login {
	static Scanner sc = new Scanner(System.in);
	
	public static String landingPage() {
		System.out.println("----------------------------------------- Welcome to SkunkWorks Bank  (v2.0)---------------------------------------------------\n");		
		System.out.println("Options Menu");
		System.out.println("\t1. Login");
		System.out.println("\t2. Apply for an account");
			System.out.print("\n-> ");
			return sc.nextLine();		
	}

	public static void applyPrompt() {
		Customer c1 = createCustomer();
		Customer c2 = null;
		System.out.println("\nWill this be a joint account(y/n)?");
		System.out.print("\t-> ");
		String s = sc.nextLine();
		boolean loop = true;
		while(loop) {
			if(s.equals("y")) {
				c2 = createJointCustomer();
				c1.setC2(c2);
				c2.setC2(c1);
				loop = false;
			}else if(s.equals("n")){
				loop = false;
			}else {
				System.out.println("Invalid input");
			}
		}
		System.out.println("Thank you for applying to SkunkWorks Bank! Check back with us shortly\n\n\n");
		Driver.appQueue.add(c1);
		if(c2 != null) {
			Driver.appQueue.add(c2);
		}
	}
	
	private static Customer createJointCustomer() {
		System.out.println("\nWho else will be using this account? 'firstname lastname'");
		System.out.print("\t-> ");
		String name = sc.nextLine();
		boolean isTaken = true;
		String username = null;
		while(isTaken) {
			System.out.print("\nEnter a username: ");
			username = sc.nextLine();
			if(Utility.usernameExists(username)) {
				System.out.println("Username alread taken, enter a new username");
			}else {
				isTaken = false;
			}
		}
		System.out.print("Enter a password: ");
		String password = sc.nextLine();
		return new Customer(name,username,password);
	}

	public static Customer createCustomer() {
		System.out.println("\nEnter your name in the format 'firstname lastname'");
		System.out.print("\t-> ");
		String name = sc.nextLine();
		boolean isTaken = true;
		String username = null;
		while(isTaken) {
			System.out.print("\nEnter a username: ");
			username = sc.nextLine();
			if(Utility.usernameExists(username)) {
				System.out.println("Username alread taken, enter a new username");
			}else {
				isTaken = false;
			}
		}
		System.out.print("Enter a password: ");
		String password = sc.nextLine();
		return new Customer(name,username,password);
	}
		

	public static User loginPrompt() {
		boolean isValid = false;
		String u = null;
		String p = null;
		while(!isValid) {
			System.out.print("Enter Username: ");
			u = sc.nextLine();
			System.out.print("Enter Password: ");
			p = sc.nextLine();
			if(Utility.usernameExists(u) && Utility.findUser(u).getPassword().equals(p)) {
				isValid = true;
				
			}
			else {
				System.out.println("Wrong username or password, try again");
			}
		}
		System.out.println("Login Successful\n\n\n");
		return Utility.findUser(u);
	}
}
