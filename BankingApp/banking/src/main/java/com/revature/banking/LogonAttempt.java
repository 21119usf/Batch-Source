package com.revature.banking;

import java.util.Scanner;

public class LogonAttempt {
	static IO io = new IO();
	static String userString = io.readInputStreamContents("Users.txt");
	static String[] userList = userString.split(System.getProperty("line.separator"));
	static int userLength = userList.length;
	
	
	
	static void login(String response){
		boolean success = false;
		while (!success) {
			
		String userTest = response;

		if (userTest.equals("esc")) {
			break;
		}
		for (int i = 1; i < userLength; i++) {
			String[] userSplit = userList[i].split(":");
			if (!(userTest.equals(userSplit[1]))) {
				System.out.println("=================================================================");
				success=true;
				break;
			}
			else 
//				if (userTest.equals(userSplit[1])) 
				{
				boolean passSuccess = false;
				while (!passSuccess) {
				System.out.println("===================Please enter your Password:===================");
				Scanner input = new Scanner(System.in);
				String passAttempt = input.nextLine();
				if (passAttempt.equals("esc")) {
					passSuccess=true;
					break;
				}
				int passint = passAttempt.hashCode();
				int encryption = (passint*500003477)%1009747;
				int checkr = Integer.parseInt(userSplit[3]);
				if (checkr == encryption) {
					System.out.println("Welcome " + userSplit[1]);
					UserDashboard init = new UserDashboard();
					int accessType = Integer.parseInt(userSplit[2]);
					int userID = Integer.parseInt(userSplit[2]);
					
					UserDashboard.dash(accessType, userID);
					success = true;
					passSuccess = true;
				}
				}
			}
		}
		
		}
		
	}
	
}
