package com.revature.menu;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.revature.accountopening.AccountOpening;
import com.revature.impl.AccountDaoImpl;
import com.revature.impl.UserDaoImpl;
import com.revature.users.CustomerUser;
import com.revature.views.WelcomeScreen;

public class AdminMenu {

	public Scanner in = new Scanner(System.in);
	static float transactionAmount;
	public void adminMenu(String user) {
		System.out.println("\n\nWelcome "+ user+". Administrator Menu. Choose an option: ");
		System.out.println("==============================================================================================");
        System.out.println("1. View Customer Info");
        System.out.println("2. Create Customer Account");
        System.out.println("3. Update");
        System.out.println("4. Delete User");
        System.out.println("9. Exit");
        System.out.println("==============================================================================================");
        System.out.println("Please enter an option:");
        System.out.println("==============================================================================================");
		
        int choice = in.nextInt();
        switch(choice) {
        	case 1:
        		viewCustomerInfo();
        		adminMenu(user);
        		break;
        	case 2:
        		createCustomer(user);
        		adminMenu(user);
        		break;
        	case 3:
        		break;
        	case 4:
        		deleteUser(user);
        		adminMenu(user);
        		break;
        	case 9:
        		System.out.println("You have chosen to exit. Goodbye!\n\n\n\n");
        		WelcomeScreen w = new WelcomeScreen();
        		w.introduction();
        		break;
        	default:
        		adminMenu(user);
        		break;
        }
        in.close();
	}
	
	public void viewCustomerInfo() {
		Scanner in = new Scanner(System.in);
		int uid;
		System.out.println("Enter User ID of Customer you wish to view: ");
		uid = in.nextInt();
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
		in.close();
	}
	
	public void createCustomer(String user) {
		
		Scanner in = new Scanner(System.in);
		System.out.println("Creating account for customer. ");
		System.out.println("Enter Username for customer: ");
		String cUserName = in.nextLine();
		System.out.println("Enter Password for customer: ");
		String cPassword = in.nextLine();
		AccountOpening ao=new AccountOpening();
		int uid = ao.adminCreateAccount(cUserName, cPassword, user);
		
		CustomerMenu cm = new CustomerMenu();
		cm.viewAccountInfo(uid);
		
		AdminMenu am = new AdminMenu();
		am.adminMenu(user);
		
		in.close();
	}
	
	public void deleteUser(String user) {
		
		Scanner in = new Scanner(System.in);
		AccountDaoImpl adi =new AccountDaoImpl();
		UserDaoImpl udi = new UserDaoImpl();
		System.out.println("Enter User ID of customer you wish to delete: ");
		int uid = in.nextInt();
		int delete;
		float bal = 0f;
		try {
			bal = adi.getBalance(uid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(bal>0) {
			System.out.println("Their balance is: $"+bal);
			System.out.println("Accounts need to be zeroed to delete.");
			adminMenu(user);
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
				System.out.println("Customer's account has been deleted.\n\n\n");
				adminMenu(user);
			}else
				adminMenu(user);
		}
	}
	
	
}
