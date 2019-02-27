package com.revature.views;

import java.util.Scanner;

import com.revature.accountopening.AccountOpening;

public class WelcomeScreen {
		
		public WelcomeScreen() {
			super();
			// TODO Auto-generated constructor stub
		}	
		public void introduction() {
			Scanner input = new Scanner(System.in);
		int n =0;
			System.out.println("Welcome to the Banking Application!");
			System.out.println("==============================================================================================");
			while(n==0) {
			System.out.println("Please enter 'L' to log in, or 'R' to register.");
			System.out.println("==============================================================================================");
			char in = input.next().charAt(0);
			
			if(in == 'L'||in == 'l') {
				LoginScreen log = new LoginScreen();
				log.loginScreen();
				break;
			}else
				if(in == 'r'|| in =='R') {
					registration();
					break;
				}else {
					System.out.println("Invalid Entry.");
					continue;
				}
			}
			input.close();
			
		}
		
		public static int b=0;

		public void registration() {
			Scanner input = new Scanner(System.in);
			
			String userName;
			String userPW;
				
			System.out.println("Registration");
			System.out.println("===============================================");
			System.out.println("Enter a unique username or your ssn no spaces.");
			userName=input.nextLine();
			
			userPW = createPW();
			
			openAccount(userName, userPW);
			input.close();
		}
		
		
		public String createPW() {
			
			Scanner input = new Scanner(System.in);
			
			String pw1;
			String pw2;
			while(b==0) {
				System.out.println("Create a password with 8 or more characters no spaces.");
				pw1=input.nextLine();
				if(pw1.length()<8) {
					System.out.println("8 or more characters needed");
					continue;
				}
				System.out.println("Re-enter password");
				pw2=input.nextLine();
				if(pw1.equals(pw2)) {
					return pw2;
				}else {
					System.out.println("Passwords don't match.");
					continue;
				}
			}
			input.close();
			return null;			
		}
		
		public void openAccount(String name, String pw) {
			Scanner input = new Scanner(System.in);
			while(b==0){
				if(pw.equals("administrator")) {
						System.out.println("Creating Administrator");
						AccountOpening ao = new AccountOpening();
						ao.createAdmin(name, pw);
						break;
						
					}else
						{	System.out.println("Opening individual account");
							AccountOpening ao = new AccountOpening();
							ao.openIndividual(name, pw);
							break;	
						}
			}
			input.close();
		}
}
