package com.revature.banking;

import java.sql.SQLException;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.daoimpl.UserDaoImpl;

public class NewUser {
	private static Logger logger = LogManager.getLogger(AdminAccess.class);
	static Scanner input = new Scanner(System.in);
	static void createAccount() {
		boolean success = false;
		while (!success) {
	System.out.println("Please choose a Username, or type \"esc\" to go back.");
	String nameAttempt = input.nextLine();
	UserDaoImpl udi = new UserDaoImpl();
	
	try {
		if (nameAttempt.equals("esc")) {
			break;
		}
		else if(udi.checkUser(nameAttempt)) {
			System.out.println("Username already exists. ");
			System.out.println("=================================================================");
			
		}
		else if (nameAttempt.length()<6){
			System.out.println("Please choose a username with 6 or more characters");
			System.out.println("=================================================================");
			
		}
		else {
			String password = passCheck();
			
			int passint = password.hashCode();
			int encryption = (passint*500003477)%1009747;
			System.out.println("First Name:");
			String firstName = input.nextLine();
			System.out.println("Last Name:");
			String lastName = input.nextLine();
			System.out.println("Street Address:");
			String address = input.nextLine();
			System.out.println("City:");
			String city = input.nextLine();
			System.out.println("State:");
			String state = input.nextLine();
			System.out.println("Phone Number:");
			String phone = input.nextLine();
			System.out.println("Email:");
			String email = input.nextLine();
			udi.createUser(nameAttempt, encryption, firstName, lastName, address, city, state, phone, email);
			logger.info("User " + nameAttempt + " created.");
			System.out.println("Thank you for registering. \n"
	    			+ "To begin using your account, please re-enter your information and log in below.\n"
	    			+ "=================================================================\n"
	    			+ "Have a Great Day!");
			success = true;
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		}
	}
	public static String passCheck() {
		boolean passValid = false;
		while (!passValid) {
			System.out.println("Please choose a Password at least 6 characters:");
			String password = input.nextLine();
			
			System.out.println("Please re-enter your Password choice:");
			String passwordCheck = input.nextLine();
			
			if (!(password.equals(passwordCheck))) {
				System.out.println("Your Passwords do not match, please try again.");
			}
			else if (password.length()<6) {
				System.out.println("Your Password is not long enough, please try again.");
			}
			
			else {
				return password;
			}
			}
		return null;
	}
}
