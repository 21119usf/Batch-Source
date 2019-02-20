package com.revature.bankingapp;

import java.util.Scanner;

public class Registration {

	//this should have a form to register
	//need to choose a username or have ssn as username, and create a password
	//have to choose what kind of account to open
	public Scanner in = new Scanner(System.in);
	public static int b=0;
	AccountOpening acctObj = new AccountOpening();
	public void registrationScreen() {
		
		String userName;
		String userPW;
		
		
		System.out.println("Registration");
		System.out.println("===============================================");
		
		userName=createUser();
		userPW = createPW();
		if(userPW.equals("employee")) {
			System.out.println("Welcome Bank Employee");
			acctObj.createEmployee(userName, userPW);
		}else
			chooseAcctType(userName, userPW);
		
		
	in.close();
	}
	
	public void chooseAcctType(String name, String pw) {
		
		while(b==0){
			System.out.println("What kind of account would you like to open? 'J' for joint and 'I' for individual.");
			char a = in.next().charAt(0);
			if(a == 'J'||a=='j') {
				System.out.println("Opening joint account");
				acctObj.openJoint(name, pw);
				
				break;
			}else
				if(a == 'I'||a=='i') {
					System.out.println("Opening individual account");
					acctObj.openIndividual(name, pw);
					break;
				}else
					if(a == 'E'||a=='e') {
						System.out.println("Creating Employee User");
						acctObj.createEmployee(name, pw);
						break;
					}else
						if(a == 'A'||a=='a') {
						System.out.println("Creating Administrator");
						acctObj.createAdmin(name, pw);
						break;
					}else
						continue;
		}
	}
	public String createPW() {
		String pw1;
		String pw2;
		while(b==0) {
			System.out.println("Create a password with 8 or more characters no spaces.");
			pw1=in.nextLine();
			if(pw1.length()<8) {
				System.out.println("8 or more characters needed");
				continue;
			}
			System.out.println("Re-enter password");
			pw2=in.nextLine();
			if(pw1.equals(pw2)) {
				return pw2;
			}else {
				System.out.println("Passwords don't match.");
				continue;
			}
		}
		return null;
	}
	public String createUser() {
		System.out.println("Enter a unique username or your ssn no spaces.");
		String user=in.nextLine();
		return user;
	}
	
}
