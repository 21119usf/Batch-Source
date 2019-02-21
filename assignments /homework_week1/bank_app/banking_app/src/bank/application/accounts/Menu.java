package bank.application.accounts;
import bank.application.entities.*;
import java.util.Scanner;

import bank.application.entities.Customer; 

public class Menu {
	//display welcome menu
	public void customer_menu(Customer c) {
		char option = '\0';
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Welcome " + c.getFirstname() + " " + c.getLastname());
		System.out.println("Your ID is: " + c.getCustomerID());
		System.out.println("==================================");
		System.out.println("A. Check Balance");
		System.out.println("B. Deposit");
		System.out.println("C. Withdraw");
		System.out.println("D. Exit");
		
		do {
			System.out.println("===============================");
			System.out.println("Enter an option");
			System.out.println("===============================");
			option = scanner.next().charAt(0);
			System.out.println("\n");
			
			switch(option)
			{
			case 'A': 
				System.out.println("-------------------------------");
				System.out.println("Balance = " + c.getBalance());
				System.out.println("-------------------------------");
				System.out.println("\n");
				
			case 'B':
				System.out.println("-------------------------------");
				System.out.println("Enter amount to deposit");
				System.out.println("-------------------------------");
				int amount = scanner.nextInt(); 
				c.deposit(amount);
				System.out.println("\n");
				break; 
				
			case 'C':
				System.out.println("-------------------------------");
				System.out.println("Enter amount to withdraw");
				System.out.println("-------------------------------");
				int amount2 = scanner.nextInt(); 
				c.withdraw(amount2);
				System.out.println("\n");
				break; 
			
			default: 
				System.out.println("You have to select a correct option");
			}
				
		} while(option != 'D');
	}
	
	public void employee_menu(Employee e) {
		char option = '\0';
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Your seeing " + e.getFirstname() + " " + e.getLastname() + "'s information");
		System.out.println("Your employee ID is: " + e.getEmployeeID());
		System.out.println("==================================");
		System.out.println("A. Check Customers information"); 
		System.out.println("B. Approve application");
		System.out.println("C. Deny Application");
		System.out.println("D. Exit");
		
	}
	

 }
