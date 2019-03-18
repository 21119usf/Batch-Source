package com.revature.bankingapp;

import java.util.Scanner;

public class LoginScreen {

	Scanner in = new Scanner(System.in);
	String userName;
	String passWord;
	
	public LoginScreen() {
		// TODO Auto-generated constructor stub
	}
	
	public void loginScreen() {
		
		while(true)
		{
			IOFile.readUserFile();
			System.out.println("Enter your Username: ");			
			userName = in.nextLine();
			System.out.println("Enter your Password: ");
			passWord = in.nextLine();
			for(int i=0;i<IOFile.userCust.size();i++) {
				String ui = IOFile.userCust.get(i).getUserID();
				String pw = IOFile.userCust.get(i).getPassWord();
				if(ui.equals(userName) && pw.equals(passWord)) {
					System.out.println("Retrieving your information: ");
					Menu m = new Menu();
					m.mainMenu(userName);
				}
			}
			for(int i=0;i<IOFile.userEmp.size();i++) {
				String ui = IOFile.userEmp.get(i).getUserID();
				String pw = IOFile.userEmp.get(i).getPassWord();
				if(ui.equals(userName) && pw.equals(passWord)) {
					System.out.println("Hello Employee: ");
					EmpMenu e =  new EmpMenu();
					e.employeeMenu(userName);
				}
			}
			for(int i=0;i<IOFile.userAdmin.size();i++) {
				String ui = IOFile.userAdmin.get(i).getUserID();
				String pw = IOFile.userAdmin.get(i).getPassWord();
				if(ui.equals(userName) && pw.equals(passWord)) {
					System.out.println("Hello Admin: ");
					AdminMenu g =  new AdminMenu();
					g.adminMenu(userName);
				}
			}
			System.out.println("\nCannot find username or password.");
			System.out.println("Try again\n");

		}
	}

}
