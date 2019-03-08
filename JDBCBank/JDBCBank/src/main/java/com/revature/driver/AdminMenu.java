package com.revature.driver;

import java.sql.SQLException;

import com.revature.daoimpl.AccountDaoImpl;
import com.revature.daoimpl.CustomerDaoImpl;

public class AdminMenu {
	public static boolean userFound = true;
	public static boolean accountFound = true;
	public static void menu() {
		//view/edit all accounts
		//close accounts
		//withdraw/deposit/transfer
		CustomerDaoImpl cdi = new CustomerDaoImpl();
		AccountDaoImpl adi = new AccountDaoImpl();
		int i = 0;
		while (i != -1) {
			System.out.println("What would you like to do?");
			System.out.println("1: View Customer Account Information");
			System.out.println("2: Create Customer");
			System.out.println("-1: Log Off");

			i = Driver.input.nextInt();
			switch(i) {
			case 1:
				System.out.println("Enter customer username: ");
				Driver.username = Driver.input.next();
				try {
					cdi.displayAdmin(Driver.username);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(userFound == false) {
					break;
				}
				accountFound = false;
				try {
					adi.findAccount(Driver.userID);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				int j = 0;
				while(j != -1) {
					System.out.println("What would you like to do?");
					System.out.println("1: Create Account");
					if(accountFound == true) {
						System.out.println("2: Deposit");
						System.out.println("3: Withdraw");
						System.out.println("4: Delete");
					}
					System.out.println("-1: Log Out.");
					j = Driver.input.nextInt();
					switch (j) {
					case 1:
						int balance;
						System.out.println("How much would you like to deposit to new account?");
						balance = Driver.input.nextInt();
						try {
							adi.createAccount(balance, Driver.userID);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
					case 2:
						System.out.println("Which account would you like to withdraw from?");
						Driver.accountID = Driver.input.nextInt();
						System.out.println("How much would you like to withdraw?");
						int amount = Driver.input.nextInt();
						try {
							adi.withdrawal(Driver.accountID, amount);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
					case 3:
						System.out.println("Which account would you like to deposit to?");
						Driver.accountID = Driver.input.nextInt();
						System.out.println("How much would you like to deposit?");
						int depamount = Driver.input.nextInt();
						try {
							adi.deposit(Driver.accountID, depamount);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
					case 4:
						System.out.println("Which account would you like to delete?");
						Driver.accountID = Driver.input.nextInt();
						try {
							adi.delete(Driver.accountID);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					case -1:
						System.out.println("Goodbye!");
					}
					break;
				}
				
			case 2:
				String firstName;
				String lastName;
				System.out.println("Enter username:");
				Driver.username = Driver.input.next();
				System.out.println("Enter password:");
				Driver.password = Driver.input.next();
				System.out.println("Enter firstName:");
				firstName = Driver.input.next();
				System.out.println("Enter lastName:");
				lastName = Driver.input.next();
				try {
					cdi.createUser(Driver.username, Driver.password, firstName, lastName);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case -1:
				System.out.println("Goodbye!");
			}
		}
	}
}
