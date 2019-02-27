package com.revature.menu;


import java.io.File;
import java.util.Properties;

import com.revature.people.Admin;
import com.revature.util.InputScan;
import com.revature.util.Props;

public class AdminLogin {
	private String username;
	private String password;
	
	
	
	private Admin a = new Admin();
	
	public void AdLogMenu() {
		
		Properties prop = Props.getProps();
		
		System.out.println("Please Enter Your Username and Password." );
		System.out.println("Username: " );
		username = InputScan.scan.nextLine();
		a.setAdminName(username);
		System.out.println("Password: ");
		password = InputScan.scan.nextLine();
		a.setPassword(password);
		System.out.println();
		
		File file = new File("DB.properties");
		try {
			Class.forName(prop.getProperty("driver"));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (username.equals(Props.getProps().getProperty("admin_username")) &&
				password.equals(Props.getProps().getProperty("admin_password"))) {
			new AdminMenu().AdMenu();
		} else {
			System.out.println("Credientals are invalid");
			new IntroMenu().FirstMenu();
		
		
		
	}

}
}