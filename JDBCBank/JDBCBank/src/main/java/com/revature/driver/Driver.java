package com.revature.driver;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import com.revature.daoimpl.CustomerDaoImpl;

public class Driver {
	public static Scanner input = new Scanner(System.in);
	public static String username = "";
	public static String password = "";
	public static int userID;
	public static int accountID;
	
	public static void main(String[] args) {
		Properties prop = new Properties();
		String adminusr = "";
		String adminpass = "";
		try {
			prop.load(new FileReader("database.properties"));
			adminusr = prop.getProperty("adminusr");
			adminpass = prop.getProperty("adminpass");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		CustomerDaoImpl cdi = new CustomerDaoImpl();
		
		int i = 0;
		while (i != -1){
			//user input: 
			//create account or account login
			System.out.println("Type integer to proceed: ");
			System.out.println("1 = Login");
			System.out.println("2 = Create Account");
			System.out.println("-1 = Shut Down");
			i = input.nextInt();
			if (i == -1) {
				//Terminate program
				System.out.println("Goodbye!");
				return;
			}
			if(i == 1) {
				String userclass;
				System.out.println("Enter username:");
				username = input.next();
				System.out.println("Enter password:");
				password = input.next();
				if(username.equals(adminusr) && password.equals(adminpass)) {
					userclass = "admin";
				}else {
					userclass = "customer";
				}
				switch(userclass) {
				case "admin":
					AdminMenu.menu();
					break;
				case "customer":
					CustomerMenu.menu();
					break;
				}
				if(i == 2) {
					String firstName;
					String lastName;
					System.out.println("Enter username:");
					username = input.next();
					System.out.println("Enter password:");
					password = input.next();
					System.out.println("Enter firstName:");
					firstName = input.next();
					System.out.println("Enter lastName:");
					lastName = input.next();
					try {
						cdi.createUser(username, password, firstName, lastName);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
}
