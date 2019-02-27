package com.revature.options;

import java.util.Scanner;

public class MainOptions {
	private static Scanner sc = new Scanner(System.in);
	public static String homeScreen() {
		System.out.println("------------------------------WELCOME TO THE BANK--------------------------");
		System.out.println("What would you like to do today?");
		System.out.println("\t1.Customer Login");
		System.out.println("\t2.Admin Login");
		System.out.println("\t3.Apply for an account");
		while(true) {
			String choice = sc.nextLine();
			if(choice.equals("1")||choice.equals("2")||choice.equals("3")||choice.equals("quit")){
				
				return choice;
			}
			System.out.println("Not an option, try again..");
		}
	}

}
