package com.revature.input;

import java.sql.SQLException;
import java.util.Scanner;

import com.revature.app.Main;
import com.revature.bankinterface.CustomerDAOImpl;
import com.revature.menu.IntroMenu;
import com.revature.people.Customer;
import com.revature.util.InputScan;

public class NewCustInput {
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private String socialSecurity;
	private String Email;
	private static CustomerDAOImpl customerDAO = new CustomerDAOImpl();
	
	
	public int getInput() {
		Scanner scan = InputScan.scan;
		System.out.println("Please enter your information." );
		System.out.println("Enter a username: " );
		userName = scan.next();
		System.out.println("Enter a password: ");
		password = scan.next();
		System.out.println("Enter your first name: ");
		firstName = scan.next();
		System.out.println("Enter your last name: ");
		lastName = scan.next();
		System.out.println("Enter your Social Security Number: ");
		socialSecurity = scan.next();
		System.out.println("Enter your Email: ");
		Email = scan.next();
		
		
			validate();
			Customer c = new Customer();
			c.setFirstName(firstName);
			c.setLastName(lastName);
			c.setUserName(userName);
			c.setPassword(password);
			c.setSocialSecurity(socialSecurity);
			c.setEmail(Email);
		
			try {
				customerDAO.createCustomer(c);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		return 0;
		
	}
	public void validate(){
	if (userName.length() < 8) {
		System.out.println("Username must be greater then 8 charecters");
		new NewCustInput().getInput();
	}
	if (userName.length() > 25) {
		System.out.println("Username must be less then 25 charecters");
		new NewCustInput().getInput();
	}
	if (password.length() < 8) {
		System.out.println("Password must be greater then 8 charecters");
		new NewCustInput().getInput();
	}
	if (password.length() > 25) {
		System.out.println("Password must be less then 25 charecters");
		new NewCustInput().getInput();
	}
	if (firstName.length() < 2) {
		System.out.println("First Name must be greater then 1 charecters");
		new NewCustInput().getInput();
	}
	if (firstName.length() > 25) {
		System.out.println("First Name must be less then 25 charecters");
		new NewCustInput().getInput();
	}
	if (lastName.length() < 2) {
		System.out.println("Last Name must be greater then 1 charecters");
		new NewCustInput().getInput();
	}
	if (lastName.length() > 25) {
		System.out.println("Last Name must be less then 25 charecters");
		new NewCustInput().getInput();
	}
	if (socialSecurity.length() != 9) {
		System.out.println("Social Security Number must be 10 charecters long");
		new NewCustInput().getInput();
	}
	if (Email.length() < 4) {
		System.out.println("Email Invalid");
		new NewCustInput().getInput();
	}
	

}

	
		public void InvaildInput(Exception e) {
			System.out.println("Invaild Input");
			getInput();
		}

		

}
