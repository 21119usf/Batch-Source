package com.revature.driver;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Scanner;
import com.revature.bankApp1.Login;
import com.revature.beans.Admin;
import com.revature.beans.Customer;
import com.revature.beans.Employee;
import com.revature.implementers.CreateNewAccount;
import com.revature.logs.Logging;
import com.revature.userprompt.UserPrompts;

public class BankAppMain {
	static String username;
	static String password;
	private static ArrayList<Object> credCheck = new ArrayList<Object>(); 
	private static Login logs;
	private static final UserPrompts prompt = new UserPrompts();
	private static String[] credentials = new String[2];
	
	public static void main(String[] args) throws SQLException {
		credCheck.add(false);
		boolean x = false;
		while(x==false) {
			System.out.println("Admin Login:\t\tEnter: \"admin\"");
			System.out.println("Employee Login:\t\tEnter: \"employee\"");
			System.out.println("Customer Login:\t\tEnter: \"customer\"");		
			System.out.println("Create New Account:\tEnter: \"new\"");
			System.out.println("Exit:\t\t\tEnter: \"exit\"\n");
			Scanner myScanner = new Scanner(System.in);
			String choice = myScanner.nextLine().toLowerCase();
			switch(choice) {
				case "admin":

					Admin admin = new Admin();
					
					while((Boolean)credCheck.get(0)==false) {
						credentials = prompt.logInPrompt();
						admin.setUsername(credentials[0]);
						admin.setPassword(credentials[1]);
						logs = new Login(admin.getUsername(), admin.getPassword(), admin);
						credCheck = logs.login();
						System.out.println();
						if((Boolean)credCheck.get(0)==true) {
							admin.setUserID(credCheck.get(1));
							prompt.AdminPrompt(admin.getUserID());
							break;
						}
						 Logging.LOGGER.info("Admin Login attemped failed => Username:" + admin.getUsername());
					}
					x=true;
					break;
				case "employee":
					Employee employ = new Employee();
					while((Boolean)credCheck.get(0)==false) {
						credentials = prompt.logInPrompt();
						employ.setUsername(credentials[0]);
						employ.setPassword(credentials[1]);
						logs = new Login(employ.getUsername(), employ.getPassword(), employ);
						credCheck = logs.login();
						System.out.println();
						if((Boolean)credCheck.get(0)==true) {
							employ.setUserID(credCheck.get(1));
							prompt.EmployeePrompt(employ.getUserID());
							break;
						}
						Logging.LOGGER.info("Employee Login attmemped failed => Username:" + employ.getUsername());
					}
					x=true;
					break;
				
				case "customer":
					Customer customer= new Customer();
					while((Boolean)credCheck.get(0)==false) {
						credentials = prompt.logInPrompt();
						customer.setUsername(credentials[0]);
						customer.setPassword(credentials[1]);
						logs = new Login(customer.getUsername(), customer.getPassword(), customer);
						credCheck = logs.login();
						System.out.println();
						if((Boolean)credCheck.get(0)==true) {
							customer.setUserID(credCheck.get(1));
							prompt.CustomerPrompt(customer.getUserID());
							break;
						}
						Logging.LOGGER.info("Customer Login attempted failed => Username:" + customer.getUsername());
					}
					myScanner.close();
					x=true;
					break;
					
				case "new":
					System.out.println("Enter First Name:\t");
					String firstname = myScanner.nextLine();
					System.out.println("Enter Last Name: \t");
					String lastname = myScanner.nextLine();
					System.out.println("Enter DOB (mm/dd/yyyy):\t");
					String DOB = myScanner.nextLine();
					System.out.println("Enter Street:\t");
					String street = myScanner.nextLine();
					System.out.println("Enter City:\t");
					String city = myScanner.nextLine();
					System.out.println("Enter State:\t");
					String state = myScanner.nextLine();
					System.out.println("Enter phone number (1110001111):");
					String cell = myScanner.nextLine();
					System.out.println("Enter email address:");
					String email = myScanner.nextLine();
					System.out.println("Create username: ");
					username = myScanner.nextLine();
					System.out.println("Create pasword: ");
					password = myScanner.nextLine();
					System.out.println("Sending your request to the cloud... Hang tight...");
					CreateNewAccount newAccount= new CreateNewAccount();
					newAccount.createNewAccount(firstname,lastname,DOB,street,city,state,cell,email,username,password);
					Logging.LOGGER.info("New account request => Username:" + username);
					myScanner.close();
					x=true;
					break;
				
				case "exit":
					System.out.println("Goodbye...");
					Logging.LOGGER.info("Exit program");
					System.exit(0);
					x=true;
					
				default:
					x=false;
					System.out.println("Invalid input.\nPlease enter one of the following options...\n");
			}
		}
	}

}
