package com.revature.bank;

import java.util.Scanner;



public class BankInput {
	//variables
	int balance;
	int previousTransaction;
	String customerName;
	String customerID;
	
	//constructor
	BankInput(String custName, String custID){
		customerName = custName;
		customerID = custID;
	}
	
	void deposit(int amount) {
		if(amount != 0) {
			balance = balance + amount;
			previousTransaction = amount;
		}
	}
	//This will allow a negative amount affect your balance
	void withdraw(int amount) {
		if(amount != 0) {
			balance = balance - amount;
			previousTransaction = amount;
		}
	}
	//Displays the previous transactions on the account
	/*
	 * if else statement to show whether the user deposited a positive, else if did they withdraw a negative
	 * else no transaction occurred
	 */
	void getPreviousTransaction() {
		if(previousTransaction < 0) {
			System.out.println("Deposited: "+ previousTransaction);
		}
		else if(previousTransaction > 0) {
			System.out.println("Withdrawn: "+ previousTransaction);
			
		}
		else{
			System.out.println("No Transaction Occured");
		}
	}
	void showMenu() {
		
		
		char option = 0;
		Scanner scanner = new Scanner(System.in);
		
		/*System.out.println();
		System.out.println("A. Customer");
		System.out.println("B. Employee");
		System.out.println("C. Admin");
		System.out.println();
		System.out.println("D. New Customer");
		System.out.println();
		System.out.println("E. Exit");
		System.out.println();*/
		
	/*	System.out.println("Welcome "+customerName);
		System.out.println("User ID "+customerID);
		System.out.println();
		System.out.println("A. Check Balance");
		System.out.println("B. Deposit");
		System.out.println("C. Withdraw");
		System.out.println("D. Previous Transactions");
		System.out.println("E. Exit");*/
		
		//do while statement to state that if its anything other than 'E' run, it if not then close
		do {
			System.out.println("Welcome "+customerName);
			System.out.println("User ID "+customerID);
			System.out.println();
			System.out.println("A. Check Balance");
			System.out.println("B. Deposit");
			System.out.println("C. Withdraw");
			System.out.println("D. Previous Transactions");
			System.out.println("E. Exit");
			System.out.println();
			System.out.println("Enter option: ");
			System.out.println();
			option = scanner.next().charAt(0);
			System.out.println();
			
			//Switch statement to hold the different cases (menus in this case)
			switch(option) {
			
			case 'A':
				System.out.println();
				System.out.println("Balance = " + balance);
				System.out.println();
				break;
				
			case 'B':
				System.out.println();
				System.out.println("Enter an amount to deposit: ");
				System.out.println();
				int amount = scanner.nextInt();
				deposit(amount);
				System.out.println();
				break;
				
			case 'C':
				System.out.println();
				System.out.println("Enter an amount to withdraw: ");
				System.out.println();
				int amount2 = scanner.nextInt();
				withdraw(amount2);
				System.out.println();
				break;
				
			case 'D':
				System.out.println();
				getPreviousTransaction();
				System.out.println();
				break;
				
			case 'E':
				System.out.println("Good Bye");
				break;
			
				
			default:
				System.out.println("Invalid Option, please enter another.");
				break;
			}
			
			}
			while(option != 'E');
				System.out.println("Thank you for using our services");
		}
	//creates an object for BankInput to show
	public static void main(String [] args) {
		BankInput obj1 = new BankInput("Test", "Test123");
		obj1.showMenu();
		
	}
		
	}
	

