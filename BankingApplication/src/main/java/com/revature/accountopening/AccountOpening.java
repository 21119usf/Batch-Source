package com.revature.accountopening;

import java.sql.SQLException;
import java.util.Scanner;

import com.revature.impl.AccountDaoImpl;
import com.revature.impl.UserDaoImpl;
import com.revature.menu.AdminMenu;
import com.revature.menu.CustomerMenu;
import com.revature.views.WelcomeScreen;

public class AccountOpening {

	public Scanner in = new Scanner(System.in);
	
	public void openIndividual(String logName, String logPW) {
		
		String fn;
		String ln;
		int userID = 0;
		float deposit;
		UserDaoImpl udi = new UserDaoImpl();
		AccountDaoImpl adi = new AccountDaoImpl();
		
		System.out.println("Enter your first name");
		fn=in.nextLine();
		String fnn = toUpperCase(fn);
		
		System.out.println("Enter your last name");
		ln=in.nextLine();
		String lnn = toUpperCase(ln);
		
		System.out.println("How much would you like to deposit? ");
		deposit=in.nextFloat();
	
		try {
			udi.createUser(fnn, lnn, logName, logPW);
			userID =udi.getUserId(logName, logPW);
			adi.createAccount(userID, deposit);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		System.out.println("Your account has been processed.");
		System.out.println("===============================================\n\n\n\n\n\n");
		
		
		CustomerMenu cm = new CustomerMenu();
		cm.mainMenu(userID);
	}
	
	
	public void createAdmin(String logName, String logPW) {
		String fn;
		String ln;
		UserDaoImpl udi = new UserDaoImpl();
	
		System.out.println("Enter your first name");
		fn=in.nextLine();
		String fnn = toUpperCase(fn);
		
		System.out.println("Enter your last name");
		ln=in.nextLine();
		String lnn = toUpperCase(ln);
		
		try {
			udi.createUser(fnn, lnn, logName, logPW);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		AdminMenu am = new AdminMenu();
		am.adminMenu(logName);
	}
	
	public static String toUpperCase(String str) {
		char[] f = new char[str.length()];
		for(int i=0;i<str.length();i++) {
			f[i]=Character.toUpperCase(str.charAt(i));	
		}
		String name = new String(f);
		return name;
	}
	
public int adminCreateAccount(String logName, String logPW, String adminName) {
		
		String fn;
		String ln;
		int userID = 0;
		float deposit;
		UserDaoImpl udi = new UserDaoImpl();
		AccountDaoImpl adi = new AccountDaoImpl();
		
		System.out.println("Enter customer's first name");
		fn=in.nextLine();
		String fnn = toUpperCase(fn);
		
		System.out.println("Enter customer's last name");
		ln=in.nextLine();
		String lnn = toUpperCase(ln);
		
		System.out.println("How much are they depositing? ");
		deposit=in.nextFloat();
	
		try {
			udi.createUser(fnn, lnn, logName, logPW);
			userID =udi.getUserId(logName, logPW);
			adi.createAccount(userID, deposit);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		System.out.println("The account has been processed.");
		System.out.println("===============================================\n\n\n\n\n\n");
		
		return userID;
	}
}
