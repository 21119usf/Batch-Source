package com.revature.bankApplication;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import com.revature.bankApplication.daoImpl.AccountDataAccessObjectImplimentation;
import com.revature.bankApplication.daoImpl.CustomerDataAccessObjectImplimentation;

public class Bank {
	

	public static void main(String[] args) {
		Properties prop = new Properties();
		String username = "";
		String password = "";
		Scanner scanner = new Scanner(System.in);
		try {
			prop.load(new FileReader("database.properties"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String adminUsername = prop.getProperty("adminusr");
		String adminPassword = prop.getProperty("adminpwd");
		
		CustomerDataAccessObjectImplimentation customer = new CustomerDataAccessObjectImplimentation();
		AccountDataAccessObjectImplimentation account = new AccountDataAccessObjectImplimentation();
		try {
			boolean mainBank = true;
			while(mainBank) {
				String firstSelection = "";
				System.out.println("========================================");
				System.out.println("==============  WELCOME  ===============");
				System.out.println("========================================");
				System.out.println("Please select an option");
				System.out.println("a: Create new Customer");
				System.out.println("b: Login");
				System.out.println("c: Admin Power");
				System.out.println("e: Exit Bank");
				System.out.println("Please Enter a Selection: ");
				firstSelection = scanner.next();
				
				if(firstSelection.equals("a")) {
					System.out.println("Enter new username: ");
					String newUsername = scanner.next();
					System.out.println("Enter new password: ");
					String newPassword = scanner.next();
					System.out.println("Enter new first name: ");
					String firstName = scanner.next();
					System.out.println("Enter new last name: ");
					String lastName = scanner.next();
					customer.createCustomer(newUsername, newPassword, firstName, lastName);
					customer.displayAllCustomer();

				}
				if(firstSelection.equals("e")) {
					System.out.println("Goodbye");
					return;
				}
				
				if (firstSelection.equals("b")) {
					System.out.println("========================================");
					System.out.println("===============  Login  ================");
					System.out.println("========================================");
					System.out.println("Enter Username");
					username = scanner.next();
					System.out.println("Enter Password");
					password = scanner.next();
					if(username.equals(adminUsername) && password.equals(adminPassword)) {
						System.out.println("welcome admin powers");
						customer.displayAllCustomer();
					}
					else {
						boolean loginLoop = true;
						while (loginLoop) {
							customer.displaySepecificCustomer(username, password);
							System.out.println("Please select an option");
							System.out.println("a: deposit");
							System.out.println("b: withdraw");
							// System.out.println("c: balance");
							System.out.println("d: create account");
							System.out.println("e: end transaction");

							String loginSelect = scanner.next();

							switch (loginSelect) {
							case "a":
								System.out.println("Which account number: ");
								String sAccountNumber = scanner.next();
								int accountNumber = Integer.parseInt(sAccountNumber);
								System.out.println("Amount to deposit: ");
								String sBalance = scanner.next();
								double balance = Double.parseDouble(sBalance);
								account.depositAccount(accountNumber, balance);
								customer.displaySepecificCustomer(username, password);
								break;
							case "b":
								System.out.println("Which account number: ");
								String sAccountNumberB = scanner.next();
								int accountNumberB = Integer.parseInt(sAccountNumberB);
								System.out.println("Amount to withdraw: ");
								String sWithdraw = scanner.next();
								double withdraw = Double.parseDouble(sWithdraw);
								account.withdrawAccount(accountNumberB, withdraw);
								customer.displaySepecificCustomer(username, password);
								break;
							// case "c":
							// account.getBalance(accountnumberC);
							// break;
							case "d":
								System.out.println("which customerid: ");
								String sCustomerid = scanner.next();
								int customerid = Integer.parseInt(sCustomerid);
								System.out.println("Initial Balance: ");
								String sBalanceD = scanner.next();
								double balanceD = Double.parseDouble(sBalanceD);
								account.createAccount(customerid, balanceD);
								customer.displaySepecificCustomer(username, password);
								break;
							case "e":
								loginLoop = false;
								break;
							}

						}
					}

				}
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	

}
