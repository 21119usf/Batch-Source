package com.revature.banking;

import java.util.Scanner;

public class menu {
	
	
	public static Scanner scan = new Scanner(System.in);
	
	int balance;
	int previousTransaction;
	String customerName;
	String customerID;
	String employeeName;
	String adminName;
	
	
	
	public menu(String cname, String cid) {
		customerName = cname;
		customerID = cid;
	}
	public menu() {
		super();
	}
		void showMainMenu() {
			
			/*Scanner scan = new Scanner(System.in);*/
			//System.out.println();
			//System.out.println("Enter an option: ");
			System.out.println();
			System.out.println("A. Customer");
			System.out.println("B. Employee");
			System.out.println("C. Admin");
			System.out.println();
			System.out.println("D. New Customer");
			System.out.println();
			System.out.println("E. Exit");
			System.out.println();
			showMenu();
			
			/*System.out.println("Enter an option: ");
			option = scan.next().charAt(0);*/
			//System.out.println();
			
			/*do {*/
				
		}		
			void showMenu() {
				
				
				System.out.println("Enter option: ");
				char option1 = scan.next().charAt(0);
				switch(option1) {
				
				case 'A':
					System.out.println("Welcome "+customerName);
					System.out.println("User ID "+customerID);
					System.out.println();
					System.out.println("1. Check Balance");
					System.out.println("2. Deposit");
					System.out.println("3. Withdraw");
					System.out.println("4. Previous Transactions");
					System.out.println("E. Exit");
					Account acc = new Account();
					showAcctMenu(acc);
					break;
				case 'B':
					System.out.println("Welcome "+employeeName);
					System.out.println();
					System.out.println("5. View Customer Account");
					System.out.println("6. View Account Balance");
					System.out.println("7. View Customer Information");
					System.out.println("E. Exit");
					break;
					//^ employee would need to view customer info by sysoutprint (customer info)
				case 'C':
					System.out.println("Welcome "+adminName);
					System.out.println();
					System.out.println("T. Approve/Deny Account");
					System.out.println("V. Deposit");
					System.out.println("W. Withdraw");
					System.out.println("X. Transfer");
					System.out.println("Y. Cancel Account");
					System.out.println("E. Exit");
					break;
					
				default:
					System.out.println("Invaild option, please enter again.");
					break;
				}
		}
		/*	} while(option  != 'E');
			System.out.println("Thank you for using our services! ");
			}*/
					
		void showAcctMenu(Account a){
			
			System.out.println();
			System.out.println("Enter option: ");
			char option1 = scan.next().charAt(0);
			switch(option1) {
			case '1':
				System.out.println();
				System.out.println("Balance: "+balance);
				System.out.println();
				showMenu();
				
				break;
			case '2':
				System.out.println();
				System.out.println("Enter an amount to deposit: ");
				System.out.println();
				int amount = scan.nextInt();
				a.deposit(amount);
				System.out.println();
				break;
			case '3':
				System.out.println();
				System.out.println("Enter an amount to withdraw: ");
				System.out.println();
				int amount2 = scan.nextInt();
				a.withdraw(amount2);
				System.out.println();
				break;
			case '4':
				System.out.println();
				a.getPreviousTransaction();
				System.out.println();
				break;
			case 'E':
				System.out.println("****");
				break;
			default:
				System.out.println("Invaild option, please enter again.");
				break;
			}
		}

					
				
		void customerMenu() {
			
			//This will allow a positive amount affect your balance
			
		}
		
		
		
		public static void main(String [] args) {
			menu mymenu = new menu();
			mymenu.showMainMenu();
		}

}
