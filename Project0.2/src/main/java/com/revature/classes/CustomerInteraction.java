package com.revature.classes;

import java.util.Scanner;

public class CustomerInteraction {
	static int balance;
	static int pastTransaction;

	
	static void deposit(int amount) 
	{
		if(amount!=0) 
		{
			balance = balance + amount;
			pastTransaction = amount;
		}
	}

	static void withdraw(int amount) 
	{
		if(amount!=0) 
		{
			balance = balance-amount;
			pastTransaction = -amount;
		}
		
	}
	
	static void getPastTransaction() 
	{
		if(pastTransaction > 0) 
		{
			System.out.println("Deposited: " + pastTransaction);
		}
		else if(pastTransaction < 0) 
		{
			System.out.println("Withdrawn: " + Math.abs(pastTransaction));
		}
		else 
		{
			System.out.println("No transaction went through.");
		}
	}
	
	public static void showMenu()
	{
		
		int selection = 0;
		Scanner scanner = new Scanner(System.in);
		System.out.println("\n");
		
		
		do 
		{
			System.out.println("=============================================");
			System.out.println("=============================================");
			System.out.println("==============  Merica Bank =================");
			System.out.println("=============================================");
			System.out.println("=============================================");
			System.out.println("\n");
			System.out.println("1. Check Balance?");
			System.out.println("2. Deposit?");
			System.out.println("3. Withdraw?");
			System.out.println("4. Last Transaction?");
			System.out.println("5. Exit!?");
			System.out.println("Select something");
			selection = scanner.nextInt();
			
			switch(selection) {
			case 1:
				System.out.println("Balance: " + balance);
				System.out.println("\n");
				break;
			case 2:
				System.out.println("Please enter an amount to deposit:");
				int depositAmount = scanner.nextInt();
				deposit(depositAmount);
				System.out.println("\n");
				break;
			case 3:
				System.out.println("Please enter an amount to withdraw:");
				int withdrawAmount = scanner.nextInt();
				withdraw(withdrawAmount);
				System.out.println("\n");
				break;
			case 4:
				getPastTransaction();
				System.out.println("\n");
				break;
			}
		}while(selection != 5);
		
		System.out.println("Thank you for using our services.");
		
	}
	
}
