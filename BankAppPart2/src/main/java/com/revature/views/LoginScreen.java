package com.revature.views;

import java.sql.SQLException;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.impl.UserDaoImpl;
import com.revature.menu.AdminMenu;
import com.revature.menu.CustomerMenu;

public class LoginScreen {
	
	static Logger logger = LogManager.getLogger(LoginScreen.class);

	Scanner in = new Scanner(System.in);
	String userName;
	String passWord;
	
	public LoginScreen() {
		// TODO Auto-generated constructor stub
	}
	
	public void loginScreen() {
		int x = 0;
		int uid=0;
		while(x<3)
		{
			logger.info("Log in successful.");
			System.out.println("Enter your Username: ");			
			userName = in.nextLine();
			System.out.println("Enter your Password: ");
			passWord = in.nextLine();
			UserDaoImpl udi = new UserDaoImpl();
			
			try {
				uid = udi.getUserId(userName, passWord);
				if(uid<1) 
				{
					System.out.println("\nCannot find username or password.");
					System.out.println("Try again\n");
					x++;
				}else
					if(passWord.equals("administrator")){
							AdminMenu am = new AdminMenu();
							am.adminMenu(userName);
					}else
					{
						
						CustomerMenu cm= new CustomerMenu();
						cm.mainMenu(uid);
					}
						
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
		}
		System.out.println("Too many attempts. You may need to register.\n\n\n");
		logger.info("Log in unsuccessful.");
		WelcomeScreen w = new WelcomeScreen();
		w.introduction();
	}

}
