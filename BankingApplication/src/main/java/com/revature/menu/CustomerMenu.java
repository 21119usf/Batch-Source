package com.revature.menu;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.revature.impl.AccountDaoImpl;
import com.revature.impl.UserDaoImpl;
import com.revature.users.CustomerUser;
import com.revature.views.WelcomeScreen;


public class CustomerMenu {

	public Scanner in = new Scanner(System.in);
	static float transactionAmount;
	public void mainMenu(int user) {
		
		System.out.println("==============================================================================================");
        System.out.println("Choose from the following menu:");
        System.out.println("1. View Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. View Account Info");
        System.out.println("5. Delete Account");
        System.out.println("9. Exit");
        System.out.println("==============================================================================================");
        System.out.println("Please enter an option:");
        System.out.println("==============================================================================================");
      
        int choice = in.nextInt();
        switch(choice) {
        	case 1:
        		getBalance(user);
        		mainMenu(user);
        		break;
        	case 2:
        		depositMoney(user);
        		mainMenu(user);
        		break;
        	case 3:
        		withdrawMoney(user);
        		mainMenu(user);
        		break;
        	case 4:
        		viewAccountInfo(user);
        		mainMenu(user);
        		break;
        	case 5:
        		deleteAccount(user);
        		mainMenu(user);
        		break;
        	case 9:
        		System.out.println("You have chosen to exit. Goodbye!\n\n\n\n");
        		WelcomeScreen w = new WelcomeScreen();
        		w.introduction();
        		break;
        	default:
        		mainMenu(user);
        		break;
        }
	}
	
	public void getBalance(int uid) {
		
		AccountDaoImpl adi =new AccountDaoImpl();
		float bal = 0f;
		try {
			bal = adi.getBalance(uid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Your current balance is: $"+bal);	
	}
	
	public void depositMoney(int uid) {
		
		AccountDaoImpl adi =new AccountDaoImpl();
		float bal = 0.00f;
		float dep = 0.00f;
		
		try {
			bal = adi.getBalance(uid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Current balance is: $"+bal);
		
		System.out.println("Enter deposit amount: ");
		dep=in.nextFloat();
		bal = bal+dep;
		
		try {
			adi.accountDeposit(uid, bal);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("New balance is: $"+bal);
	}
	
	public void withdrawMoney(int uid){
		
		AccountDaoImpl adi =new AccountDaoImpl();
		float bal = 0.00f;
		float wd = 0.00f;
		
		try {
			bal = adi.getBalance(uid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Your balance is: $"+bal);
		
		System.out.println("Amount to withdraw: ");
		wd=in.nextFloat();
		bal = bal-wd;
		
		try {
			adi.accountDeposit(uid, bal);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		System.out.println("New balance is: $"+bal);
	}
	
	public void viewAccountInfo(int uid) {
		AccountDaoImpl adi =new AccountDaoImpl();
		UserDaoImpl udi = new UserDaoImpl();

		int acctnum = 0;
		float bal = 0.00f;
		System.out.println("Account Information: ");
		System.out.println("==============================================================================================\n\n");

		try {
			bal = adi.getBalance(uid);
			acctnum = adi.getAccount(uid);
			List<CustomerUser> a = udi.getUserList(uid);
			for(CustomerUser x: a) {
				System.out.println(x);
			}
			System.out.println("Account No: "+acctnum+"\t\t\tAccount Balance: $"+bal+"\n\n");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteAccount(int uid) {
		
		AccountDaoImpl adi =new AccountDaoImpl();
		UserDaoImpl udi = new UserDaoImpl();
		int delete;
		float bal = 0f;
		try {
			bal = adi.getBalance(uid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(bal>0) {
			System.out.println("Your current balance is: $"+bal);
			System.out.println("Accounts need to be zeroed to delete. "
					+ "Choose withdraw and deplete account completely");
			mainMenu(uid);
		}else
		{
			System.out.println("Are you sure you want to delete? Type '1' for yes, '0' for no.");
			delete=in.nextInt();
			if(delete>0) {
				try {
					udi.deleteUser(uid);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Your account has been deleted. Goodbye!\n\n\n");
				WelcomeScreen ws =new WelcomeScreen();
				ws.introduction();
			}else
				mainMenu(uid);
		}
			
	}
	
	
}
