package com.revature.bank;

import java.util.Scanner;

public class userType {

	void logType() {
		
		char option = 0;
	Scanner scan = new Scanner(System.in);
	
	do {
		System.out.println();
		System.out.println("Enter an option: ");
		option = scan.next().charAt(0);
		System.out.println();
		
		switch(option) {
		
		case 'A':
			System.out.println();
			System.out.println("Employee");
			System.out.println();
			break;
		case 'B':
			System.out.println();
			System.out.println("Admin");
			System.out.println();
		case 'C':
			System.out.println();
			System.out.println("Customer");
			System.out.println();
			break;
		case 'E':
			System.out.println("****");
			break;
			
		default:
			System.out.println("Invaild option, please enter again.");
			break;
		} 
	} while(option != 'E');
	System.out.println("Thank you for using our services! ");
	}
}

