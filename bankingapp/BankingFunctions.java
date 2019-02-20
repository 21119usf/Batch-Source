package bankingapp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankingFunctions {

	static Scanner bankScans = new Scanner(System.in);
	static Scanner bankScans2 = new Scanner(System.in);
	static List<String> bankAccounts = new ArrayList<String>();
	
	static void entry() {
		
		System.out.println("Welcome to your account");
		System.out.println("What would you like to do? \n" + "1.) Deposit 2). Withdraw 3). Balance 4). Open New Account ");
		String userInput3 = bankScans.nextLine();
		bankAccounts.add("0.00");
		String h = userInput3.toLowerCase();
		
		if (h.equals("1") ) {
			menu2(1);
		}
		else if (h.equals("2")) {
			menu2(2);
		}
		
		else if (h.equals("3")) {
			menu2(3);
		}
	
		else if (h.equals("4")) {
			menu2(4);
		}
		else {
			System.out.println("Enter a correct numerical option");
			entry();
		}
	
		
	}
	static void menu2(int b) {
		
		switch(b) {
		
		case 1: 
				depositK();
				//List<String> l = bankAccounts;
				//System.out.println("You now have " + l +" In your account");
				//System.out.println();
				break;
		case 2:
			withdraw();
				break;
		case 3: 
			try {
				balDisplay();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				break;
				
		case 4:
				
				break;
		
		}
		
		
	}
			
			static void depositK() {
				//ask for deposit amount 
				System.out.println("How much would you like to deposit?");
				 String n = bankScans.nextLine();
				 Scanner y = bankScans2;
				double stringCon= Double.parseDouble(n);
				
				
				 if(stringCon < 0)
				 {
					 System.out.println("You entered a negative balance");
					 //depositK();
				 }
				 
				 //deposited integer will go into their account balance 
				// integer will be deposited to an the customer's arrayList 
				 List<String> def = bankAccounts;
				
				String currentBal = def.get(0);
				Double balConvert = Double.parseDouble(currentBal);
				Double sum = balConvert + stringCon;
				String banker = sum.toString();
				 def.add(0, banker);
				System.out.println(def.get(0));
				System.out.println("Would you like to make another deposit? \n"+ "1). Yes  2). No");
					String yy = y.next();
				if(yy.equals("Yes")) {
					depositK();
				}
				else if (yy.equals("No"))
				{
					entry();
				}
				else
				{
					entry();
				}
			}
			
			
			protected static void  withdraw() {
				System.out.println("How much would you like to withdraw?");
				 String n = bankScans.nextLine();
				 Scanner y = bankScans2;
				Double stringCon2= Double.parseDouble(n);
				List<String> c = bankAccounts;
				double accountCheck = Double.parseDouble(c.get(0));
				//checks for negative account balance
				 if(accountCheck < stringCon2)
				 {
					 System.out.println("You can't withdraw a negative amount from account");
					 withdraw();
				 }
				

					//String currentBal = c.get(0);
					//Double balConvert = Double.parseDouble(currentBal);
					Double sum = accountCheck - stringCon2;
					String banker = sum.toString();
					 c.add(0, banker);
					System.out.println(c.get(0));
					System.out.println("Would you like to make another Withdrawal? \n"+ "1). Yes  2). No");
						String yy = y.next();
					if(yy.equals("Yes")) {
						depositK();
					}
					else if (yy.equals("No"))
					{
						entry();
					}
					else
					{
						entry();
					}
				
				
			}
			
			protected static void balDisplay() throws IOException {
				Scanner u = bankScans;
				System.out.println("Your account balance is: "+bankAccounts.get(0));
				
				System.out.println("Would you like to go back to the main menu? \n"+ "1). Yes  2). No, Logout");
				String yy = u.next();
			if(yy.equals("Yes")) {
				entry();
			}
			else if (yy.equals("No"))
			{
				System.out.println("Now Logging off account");
				BankingDriver.main(null);
			}
			else
			{
				entry();
			}
		
			}
			
			protected void newAccount(boolean x) {
				// **if user wants to open new account is true
				// admin must first check true or false to open the new account
				// ask if joint or seperate account. joint account takes in two customers
				// account = new arraylist <integer>
				// will add and sum balance
				
			}
		
		
	
}

