package bank.menu;

import java.util.Scanner;

import org.apache.log4j.Logger;

public class Login implements Display
{
	final static Logger logger = Logger.getLogger(Login.class);
	private String username;
	private String password;
	Scanner scan =new Scanner(System.in);
	@Override
	public void display() {
		System.out.println("Enter username and password");
		System.out.print("Username:");
		username = scan.next();
		System.out.print("Password:");
		password = scan.next();
		if (username.equals("LoveMuffin") && password.equals("test01")) {
			logger.info("Admin Login");
			new Admin().display();
		} 
		else
		{
			logger.info("Customer Login");
			new Customer().display();
		}
	}

}
