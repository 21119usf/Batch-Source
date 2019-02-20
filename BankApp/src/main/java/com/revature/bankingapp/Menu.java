package com.revature.bankingapp;

import java.util.Scanner;

public class Menu {

	static Scanner in = new Scanner(System.in);
	static float transactionAmount;
	public void mainMenu(String user) {
		
		System.out.println("==============================================================================================");
        System.out.println("Choose from the following menu:");
        System.out.println("1. View Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Transfer");
        System.out.println("5. View Transaction History");
        System.out.println("9. Exit");
        System.out.println("==============================================================================================");
        System.out.println("Please enter an option:");
        System.out.println("==============================================================================================");
      
        int choice = in.nextInt();
        switch(choice) {
        	case 1:
        		getBalance(user);
        		mainMenu(user);
        		break;
        	case 2:
        		depositMoney(user);
        		mainMenu(user);
        		break;
        	case 3:
        		withdrawMoney(user);
        		mainMenu(user);
        		break;
        	case 4:
        		transferMoney();
        		mainMenu(user);
        		break;
        	case 5:
        		getTransactionHisotry(user);
        		mainMenu(user);
        		break;
        	case 9:
        		System.out.println("You have chosen to exit. Goodbye!\n\n\n\n");
        		WelcomeScreen w = new WelcomeScreen();
        		w.introduction();
        		break;
        	default:
        		mainMenu(user);
        		break;
        }
	}
	
	public void transferMoney() {
		IOFile.readAccountFile();
		System.out.println("Enter account number where you're transferring from :");
		int a = in.nextInt();
		for(int i=0;i<IOFile.individualList.size();i++) {
        	if(IOFile.individualList.get(i).getAccountNum()== a) {
        		System.out.println("Balance is: "+IOFile.individualList.get(i).getBalance());
        	}
		}
		for(int i=0;i<IOFile.jointList.size();i++) {
        	if(IOFile.jointList.get(i).getAccountNum()== a) {
        		System.out.println("Balance is: "+IOFile.jointList.get(i).getBalance());
        	}
		}
		System.out.println("Enter account number where you're transferring to :");
		int b = in.nextInt();
		for(int i=0;i<IOFile.individualList.size();i++) {
        	if(IOFile.individualList.get(i).getAccountNum()== b) {
        		System.out.println("Balance is now: "+IOFile.individualList.get(i).getBalance());
        	}
		}
		for(int i=0;i<IOFile.jointList.size();i++) {
        	if(IOFile.jointList.get(i).getAccountNum()== b) {
        		System.out.println("Balance is now: "+IOFile.jointList.get(i).getBalance());
        	}
		}
		System.out.println("How much do you want to transfer?");
		float m = in.nextFloat();
		for(int i=0;i<IOFile.individualList.size();i++) {
        	if(IOFile.individualList.get(i).getAccountNum()== b) {
        		float j = IOFile.individualList.get(i).getBalance()+m;
        		IOFile.individualList.get(i).setBalance(j);
        		System.out.println("Balance of "+b+" is now: "+IOFile.individualList.get(i).getBalance());
        	}
		}
		for(int i=0;i<IOFile.jointList.size();i++) {
        	if(IOFile.jointList.get(i).getAccountNum()== b) {
        		float j = IOFile.jointList.get(i).getBalance()+m;
        		IOFile.jointList.get(i).setBalance(j);
        		System.out.println("Balance of "+b+" is now: "+IOFile.jointList.get(i).getBalance());
        	}
		}
		for(int i=0;i<IOFile.individualList.size();i++) {
        	if(IOFile.individualList.get(i).getAccountNum()== a) {
        		float k = IOFile.individualList.get(i).getBalance()-m;
        		IOFile.individualList.get(i).setBalance(k);
        		System.out.println("Balance of "+a+" is now: "+IOFile.individualList.get(i).getBalance());
        	}
		}
		for(int i=0;i<IOFile.jointList.size();i++) {
        	if(IOFile.jointList.get(i).getAccountNum()== a) {
        		float k = IOFile.jointList.get(i).getBalance()-m;
        		IOFile.jointList.get(i).setBalance(k);
        		System.out.println("Balance of "+a+" is now: "+IOFile.individualList.get(i).getBalance());
        	}
		}
		IOFile.writeAccountFile();
	}
	public void getBalance(String userBal) {
		IOFile.readAccountFile();
        for(int i=0;i<IOFile.individualList.size();i++) {
        	if(IOFile.individualList.get(i).getUserName().equals(userBal)) {
        		System.out.print("Your balance is: ");
        		System.out.println("$"+IOFile.individualList.get(i).getBalance());
        	}
        }
	}
	
	public void depositMoney(String userDep) {
		float bal;
		getBalance(userDep);
		System.out.println("How much would you like to deposit?");
		float amount=in.nextFloat();
		transactionAmount=amount;
		IOFile.readAccountFile();
        for(int i=0;i<IOFile.individualList.size();i++) {
        	if(IOFile.individualList.get(i).getUserName().equals(userDep)) {
        		bal = IOFile.individualList.get(i).getBalance()+amount;
        		IOFile.individualList.get(i).setBalance(bal);
        		System.out.print("Your balance is now: ");
        		System.out.println("$"+IOFile.individualList.get(i).getBalance());
        		IOFile.writeAccountFile();
        	}
        }
	}
	
	public void withdrawMoney(String userWith) {
		float bal;
		getBalance(userWith);
		System.out.println("How much would you like to withdraw?");
		float amount=in.nextFloat();
		transactionAmount=-amount;
		IOFile.readAccountFile();
        for(int i=0;i<IOFile.individualList.size();i++) {
        	if(IOFile.individualList.get(i).getUserName().equals(userWith)) {
        		bal = IOFile.individualList.get(i).getBalance()-amount;
        		IOFile.individualList.get(i).setBalance(bal);
        		System.out.print("Your balance is now: ");
        		System.out.println("$"+IOFile.individualList.get(i).getBalance());
        		IOFile.writeAccountFile();
        	}
        }
	}
	
	public void getTransactionHisotry(String user) {
		System.out.print("History shows your most recent transaction was");
		if (transactionAmount < 0) {
            System.out.println("a withdrawal of $" + (-transactionAmount));
        } else if (transactionAmount > 0) {
            System.out.println("a deposit for $" + transactionAmount);
        } else {
            System.out.println("not recorded.");
        }
		
	}
}
