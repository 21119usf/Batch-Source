package com.revature.driver;

import java.sql.SQLException;

import com.revature.daoimpl.AccountDaoImpl;
import com.revature.daoimpl.CustomerDaoImpl;

public class CustomerMenu {
	public static boolean userFound = true;
	public static boolean accountFound = true;
	public static void menu() {
		// TODO Auto-generated method stub
		CustomerDaoImpl cdi = new CustomerDaoImpl();
		AccountDaoImpl adi = new AccountDaoImpl();
		int i = 0;
		try {
			cdi.displayCustomer(Driver.username, Driver.password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(userFound == false) {
			return;
		}else {
			while(i != -1) {
				accountFound = false;
				try {
					adi.findAccount(Driver.userID);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			System.out.println("What would you like to do?");
			System.out.println("1: Create new Account: ");
			if(accountFound == true) {
				System.out.println("2: Withdraw");
				System.out.println("3: Deposit");
				System.out.println("4: Delete");
				}
			System.out.println("-1: Logout");
			i = Driver.input.nextInt();
			switch (i) {
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
				break;
			}
			}
		}
	}
}
