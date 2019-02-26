package com.revature.banking;

import java.sql.SQLException;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.daoimpl.UserDaoImpl;
import com.revature.util.ExceptionCatcher;

public class AdminAccess {
	//initializing IO
	static IO io = new IO();
	private static Logger logger = LogManager.getLogger(AdminAccess.class);
	
	
	
	//admin dashboard method
	public static void adminDash(int userID) {
		ExceptionCatcher ec = new ExceptionCatcher();
		CustomerAccess ca = new CustomerAccess();
		//while boolean login
		boolean loggedout = false;
		while (!loggedout) {
			System.out.println("What would you like to do?");
			System.out.println(	"1 - View/Modify Account Information\n"
					+ 			"2 - Create New User\n"
					+ 			"3 - Delete User\n"
					+ 			"0 - Log Out\n"
					+ "=================================================================");
			Scanner input = new Scanner(System.in);
			String optionStr = input.nextLine();
			Integer option =ec.parseIntCheck(optionStr);

			if (option==0) {
				loggedout=true;
				break;
			}
			switch (option) {
			case 1:
				//to modify an account, you have to input the username first
				System.out.println("Please enter the account number of the Account you wish to look up:");
				String targAccStr = input.nextLine();
				Integer accountID = ec.parseIntCheck(targAccStr);
					ca.accountActions(accountID, userID);
					logger.info(userID + " accessed " + accountID);
					
				break;
			case 2:
				NewUser nu = new NewUser();
				nu.createAccount();
				logger.info(userID + " created new User");
				break;
			case 3:
				System.out.println("Please input the username of the User you wish to delete:");
				String username = input.nextLine();
				UserDaoImpl udi = new UserDaoImpl();
				try {
					udi.deleteUser(username);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
			
		}
		
	}
	
		
}
