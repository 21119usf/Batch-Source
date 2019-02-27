package com.revature.menu;

import java.sql.SQLException;
import java.util.Scanner;

import com.revature.impl.UserDaoImpl;
import com.revature.views.WelcomeScreen;

public class UpdateUserMenu {
	
public void updateMenu(String user) {
	
		Scanner in = new Scanner(System.in);
		CustomerMenu cm = new CustomerMenu();
		System.out.println("==============================================================================================");
        System.out.println("Choose from the following menu:");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Update name");
        System.out.println("4. Update login");
        System.out.println("9. Exit");
        System.out.println("==============================================================================================");
        System.out.println("Please enter an option:");
        System.out.println("==============================================================================================");
      
        int choice = in.nextInt();
        switch(choice) {
        	case 1:
        		System.out.println("Enter customer's User ID");
        		int uid=in.nextInt();
        		cm.depositMoney(uid);
        		updateMenu(user);
        		break;
        	case 2:
        		System.out.println("Enter customer's User ID");
        		int userid=in.nextInt();
        		cm.withdrawMoney(userid);
        		updateMenu(user);
        		break;
        	case 3:
        		updateName(user);
        		updateMenu(user);
        		break;
        	case 4:
        		updateLogin(user);
        		updateMenu(user);
        		break;
        	case 9:
        		System.out.println("You have chosen to exit. Goodbye!\n\n\n\n");
        		AdminMenu am = new AdminMenu();
        		am.adminMenu(user);
        		break;
        	default:
        		updateMenu(user);
        		break;
        }
	}

	public void updateLogin(String user) {
		
		Scanner in = new Scanner(System.in);
		UserDaoImpl udi=new UserDaoImpl();
		
		System.out.println("Enter customer's User ID");
		int uid=in.nextInt();
		
		System.out.println("Enter a unique username or the customer's ssn no spaces.");
		String userName=in.nextLine();
		
		WelcomeScreen ws = new WelcomeScreen();
		String userPW = ws.createPW();
		
		try {
			udi.updateLogin(uid, userName, userPW);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		updateMenu(user);
		
	}
	public void updateName(String user) {
		Scanner in = new Scanner(System.in);
		UserDaoImpl udi=new UserDaoImpl();
		
		System.out.println("Enter customer's User ID");
		int uid=in.nextInt();
		
		System.out.println("Enter customer's first name");
		String fn=in.nextLine();
		String fnn = toUpperCase(fn);
		
		System.out.println("Enter customer's last name");
		String ln=in.nextLine();
		String lnn = toUpperCase(ln);
		
		try {
			udi.updateName(uid, fnn, lnn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		updateMenu(user);
	}
	
	public static String toUpperCase(String str) {
		char[] f = new char[str.length()];
		for(int i=0;i<str.length();i++) {
			f[i]=Character.toUpperCase(str.charAt(i));	
		}
		String name = new String(f);
		return name;
	}
}
