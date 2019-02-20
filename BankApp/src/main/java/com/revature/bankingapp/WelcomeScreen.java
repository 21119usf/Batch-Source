package com.revature.bankingapp;

import java.util.Scanner;

public class WelcomeScreen {
	
		static Scanner input = new Scanner(System.in);

		
		public WelcomeScreen() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		
		public void introduction() {
		int n =0;
			System.out.println("Welcome to the Banking Application!");
			System.out.println("==============================================================================================");
			while(n==0) {
			System.out.println("Please enter 'l' to log in, or 'r' to register.");
			System.out.println("==============================================================================================");
			char in = input.next().charAt(0);
			
			if(in == 'L'||in == 'l') {
				LoginScreen log = new LoginScreen();
				log.loginScreen();
				break;
			}else
				if(in == 'r'|| in =='R') {
					Registration reg = new Registration();
					reg.registrationScreen();
					break;
				}else {
					System.out.println("Invalid Entry.");
					continue;
				}
			}
			input.close();
		}
		
}
