package com.revature.bankingapp;

import java.util.Scanner;

public class AdminMenu extends EmpMenu{
	
	static Scanner in = new Scanner(System.in);
	static float transactionAmount;
	public void adminMenu(String user) {
		System.out.println("==============================================================================================");
        System.out.println("Choose from the following menu:");
        System.out.println("1. View Applicants");
        System.out.println("2. View Customer Info");
        System.out.println("3. Delete Customer Account");
        System.out.println("4. Deposit");
        System.out.println("5. Withdraw");
        System.out.println("6. Transfer");
        System.out.println("9. Exit");
        System.out.println("==============================================================================================");
        System.out.println("Please enter an option:");
        System.out.println("==============================================================================================");
		
        int choice = in.nextInt();
        switch(choice) {
        	case 1:
        		System.out.println("Press '1' for individual applications, '2' for joint applications");
        		int n = in.nextInt();
        		if(n==1) {
        			viewApplicants(user);
        		}else
        			viewJointApplicants(user);
        		break;
        	case 2:
        		viewCustomerInfo();
        		adminMenu(user);
        		break;
        	case 3:
        		System.out.println("Press '1' for individual account, '2' for joint accounts");
        		int t = in.nextInt();
        		if(t==1) {
        			deleteCustAcct(user);
        		}else
        			deleteJointAcct(user);
        		break;
        	case 4:
        		System.out.println("Enter account number:");
        		int num = in.nextInt();
        		depositMoney(num);
        		adminMenu(user);
        		break;
        	case 5:
        		System.out.println("Enter account number:");
        		int num1 = in.nextInt();withdrawMoney(num1);
        		adminMenu(user);
        		break;	
        	case 6:
        		transferMoney();
        		adminMenu(user);
        		break;	
        	case 9:
        		System.out.println("You have chosen to exit. Goodbye!\n\n\n\n");
        		WelcomeScreen w = new WelcomeScreen();
        		w.introduction();
        		break;
        	default:
        		adminMenu(user);
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
	
	public void viewApplicants(String user) {
		IOFile.readApplicationFile();
		for(int i = 0;i<IOFile.individualApplication.size();i++) {
			String first = IOFile.individualApplication.get(i).getCustFirst();
			String last = IOFile.individualApplication.get(i).getCustLast();
			System.out.println((i+1)+" "+first+" "+last+ "'s Application");
			System.out.println("Press 'A' to approve or 'D' to deny?");
			char entry = in.next().charAt(0);
			if(entry == 'A'||entry == 'a') {
				IOFile.individualList.add(IOFile.individualApplication.get(i));
				IOFile.individualApplication.remove(IOFile.individualApplication.get(i));
				System.out.println(first+" "+last+ "'s Application has been APPROVED.\n\n");
			}else
				if(entry == 'D'|| entry =='d') {
					IOFile.individualApplication.remove(IOFile.individualApplication.get(i));
					System.out.println(first+" "+last+ "'s Application has been DENIED.\n\n");
				}else {
					System.out.println("Invalid Entry.");
					continue;
				}
		}
		IOFile.writeAccountFile();
		IOFile.writeApplicationFile();
		adminMenu(user);
	}
	
	public void viewJointApplicants(String user) {
		IOFile.readApplicationFile();
		for(int i = 0;i<IOFile.jointApplication.size();i++) {
			String first = IOFile.jointApplication.get(i).getCustFirst();
			String last = IOFile.jointApplication.get(i).getCustLast();
			String cofirst = IOFile.jointApplication.get(i).getCoFirst();
			String colast = IOFile.jointApplication.get(i).getCoLast();
			System.out.println((i+1)+" "+first+" "+last+ " and "+cofirst+" "+colast+"'s Application");
			System.out.println("Press 'A' to approve or 'D' to deny?");
			char entry = in.next().charAt(0);
			if(entry == 'A'||entry == 'a') {
				IOFile.jointList.add(IOFile.jointApplication.get(i));
				IOFile.jointApplication.remove(IOFile.jointApplication.get(i));
				System.out.println(first+" "+last+ " and "+cofirst+" "+colast+"'s Application has been APPROVED.\n\n");
			}else
				if(entry == 'D'|| entry =='d') {
					IOFile.jointApplication.remove(IOFile.jointApplication.get(i));
					System.out.println(first+" "+last+ " and "+cofirst+" "+colast+"'s Application has been DENIED.\n\n");
				}else {
					System.out.println("Invalid Entry.");
					continue;
				}
		}
		IOFile.writeAccountFile();
		IOFile.writeApplicationFile();
		adminMenu(user);
		
	}
	public void deleteCustAcct(String b){
		
		System.out.println("Enter Account number to delete: ");
		int g = in.nextInt();
		for(int i = 0;i<IOFile.individualList.size();i++) {
			int num = IOFile.individualList.get(i).getAccountNum();
			if(num == g) {
				System.out.println("Account "+num+" will be deleted\n");
				IOFile.individualList.remove(i);
			}
		}
		System.out.println("Account has been deleted:");
		IOFile.writeAccountFile();
		adminMenu(b);
	}
	
	public void deleteJointAcct(String b){
		
		System.out.println("Enter Account number to delete: ");
		int g = in.nextInt();
		for(int i = 0;i<IOFile.jointList.size();i++) {
			int num = IOFile.jointList.get(i).getAccountNum();
			if(num == g) {
				System.out.println("Account "+num+" will be deleted\n");
				IOFile.jointList.remove(i);
			}
		}
		System.out.println("Account has been deleted:");
		IOFile.writeAccountFile();
		adminMenu(b);
	}
	
	public void depositMoney(int a) {
		float bal;
		System.out.println("How much would you like to deposit?");
		float amount=in.nextFloat();
		transactionAmount=amount;
		IOFile.readAccountFile();
        for(int i=0;i<IOFile.individualList.size();i++) {
        	if(IOFile.individualList.get(i).getAccountNum()== a) {
        		bal = IOFile.individualList.get(i).getBalance()+amount;
        		IOFile.individualList.get(i).setBalance(bal);
        		System.out.print("Your balance is now: ");
        		System.out.println("$"+IOFile.individualList.get(i).getBalance());
        		IOFile.writeAccountFile();
        	}
        }
        for(int i=0;i<IOFile.jointList.size();i++) {
        	if(IOFile.jointList.get(i).getAccountNum()== a) {
        		bal = IOFile.jointList.get(i).getBalance()+amount;
        		IOFile.jointList.get(i).setBalance(bal);
        		System.out.print("Your balance is now: ");
        		System.out.println("$"+IOFile.jointList.get(i).getBalance());
        		IOFile.writeAccountFile();
        	}
        }
	}
	
	public void withdrawMoney(int a) {
		float bal;
		System.out.println("How much would you like to withdraw?");
		float amount=in.nextFloat();
		transactionAmount=-amount;
		IOFile.readAccountFile();
        for(int i=0;i<IOFile.individualList.size();i++) {
        	if(IOFile.individualList.get(i).getAccountNum()== a) {
        		bal = IOFile.individualList.get(i).getBalance()-amount;
        		IOFile.individualList.get(i).setBalance(bal);
        		System.out.print("Your balance is now: ");
        		System.out.println("$"+IOFile.individualList.get(i).getBalance());
        		IOFile.writeAccountFile();
        	}
        }
        for(int i=0;i<IOFile.jointList.size();i++) {
        	if(IOFile.jointList.get(i).getAccountNum()== a) {
        		bal = IOFile.jointList.get(i).getBalance()-amount;
        		IOFile.jointList.get(i).setBalance(bal);
        		System.out.print("Your balance is now: ");
        		System.out.println("$"+IOFile.jointList.get(i).getBalance());
        		IOFile.writeAccountFile();
        	}
        }
	}
	
	public static void viewCustomerInfo() {
		IOFile.readAccountFile();
		for(int i = 0;i<IOFile.individualList.size();i++) {
			System.out.println(IOFile.individualList.get(i).toString());
		}
		for(int i = 0;i<IOFile.jointList.size();i++) {
			System.out.println(IOFile.jointList.get(i).toString());
		}
	}

}
