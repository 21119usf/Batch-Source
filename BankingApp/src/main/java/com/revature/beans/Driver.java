package com.revature.beans;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class Driver {

	static Scanner input = new Scanner(System.in);
	
	public static String username = "";
	public static String password = "";
	public static String lookup = "";
	private static String outFile = "Accounts.txt";
	private static String inFile = "Accounts.txt";
	
	
	public static Employee e1 = new Employee("Employee", "Enter", "Worker");
	public static BankAdmin b1 = new BankAdmin("BankAdmin", "Enter", "Boss");
	
	//---------Customer tracker---------------------------
	public static String[] currentUser;
	public static String[] currentJoin1;
	public static String[] currentJoin2;
	public static int customerPlaceholder;	//DONT FORGET TO SAVE AFTER LOGGING OFF
	public static boolean customerFound = false;
	
	public static Customer userCustomer = new Customer();
	public static int joint1;
	public static int joint2;
	public static int jointBalance1;
	public static int jointBalance2;
	public static int jointPlaceholder1;
	public static int jointPlaceholder2;
	
	static public void writeOutputStreamContents(String[] contents) {
		OutputStream os = null;
		File file = new File(outFile);
		
		//false would overwrite, true appends to end
		try {
			os = new FileOutputStream(file, true);
			os.write(contents.length);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(os != null) {
			try {
				os.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static String[] readInputStreamContents() {
		InputStream is = null;
		File file = new File(inFile);
		StringBuilder s = new StringBuilder();
		try {
			is = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int b = 0;
		try {
			while((b = is.read())!= -1) {
				char c = (char)b;
				s.append(c);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if(is!=null) {
			try {
				is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return s.toString().split("\n");
	}
	
	
	public static void login(int a) {
		System.out.println("Enter username: ");
		username = input.next();
		System.out.println("Enter password: ");
		password = input.next();
	}
	
	//finds if user is an employee, bankadmin, or customer
	public static String search(){
		if (username.equals(e1.getUsername()) && password.equals(e1.getPassword())) {
			return "Employee";
		}
		else if (username.equals(b1.getUsername()) && password.equals(b1.getPassword())){
			return "BankAdmin";
		}
		else {
			return "Customer";
		}
	}
	//finds customer from Account file
	public static void customerSearch(String[] a) {
		for (int i = 0; i < a.length; i++) {
			if(lookup == "BankAdmin" || lookup == "Employee") {
				if(username.equals(a[i].substring(0, username.length()))) {
					customerFound = true;
					customerPlaceholder = i;
					currentUser = a[i].split(" ");
					userCustomer.setUsername(currentUser[0]);
					userCustomer.setPassword(currentUser[1]);
					userCustomer.setName(currentUser[2]);
					userCustomer.setAccountValue(Integer.parseInt(currentUser[4]));
					userCustomer.setAccountNumber(Integer.parseInt(currentUser[3]));
					if(currentUser.length > 6){
						userCustomer.setJoint1(Integer.parseInt(currentUser[5]));
					}
					if(currentUser.length > 7){
						userCustomer.setJoint2(Integer.parseInt(currentUser[6]));
					}
					System.out.println(userCustomer.toString());
					return;
				}
			}
			if(username.equals(a[i].substring(0, username.length()))){
				if(password.equals(a[i].substring(username.length()+1, 
						username.length()+password.length()+1))) {
					customerFound = true;
					customerPlaceholder = i;
					currentUser = a[i].split(" ");
					userCustomer.setUsername(currentUser[0]);
					userCustomer.setPassword(currentUser[1]);
					userCustomer.setName(currentUser[2]);
					userCustomer.setAccountValue(Integer.parseInt(currentUser[4]));
					userCustomer.setAccountNumber(Integer.parseInt(currentUser[3]));
					if(currentUser.length > 6){
						userCustomer.setJoint1(Integer.parseInt(currentUser[5]));
					}
					if(currentUser.length > 7){
						userCustomer.setJoint2(Integer.parseInt(currentUser[6]));
					}
					System.out.println(userCustomer.toString());
				}
			}
		}
	}
	//finds joint accounts for current customer
	public static void jointAccountSearch(String[] a) {
		if(currentUser.length > 6) {
			if(currentUser.length > 7) {
				for (int i = 0; i < a.length; i++) {
					if(userCustomer.getJoint1() == Integer.parseInt(a[i].substring(0, 
							currentUser[5].length()))) {
						jointPlaceholder1 = i;
						currentJoin1 = a[i].split(" ");
						joint1 = Integer.parseInt(currentJoin1[0]);
						jointBalance1 = Integer.parseInt(currentJoin1[1]);
					}
				}
			}
			for (int i = 0; i < a.length; i++) {
				if(userCustomer.getJoint2() == Integer.parseInt(a[i].substring(0, 
						currentUser[6].length()))) {
					jointPlaceholder2 = i;
					currentJoin2 = a[i].split(" ");
					joint2 = Integer.parseInt(currentJoin2[0]);
					jointBalance2 = Integer.parseInt(currentJoin2[1]);
					
				}
			}
		}
	}
	//deposits to an account
	public static void deposit() {
		System.out.println("Choose Account to Deposit to:");
		System.out.println("1. Account 1. Balance = " + userCustomer.getAccountValue());
		if(currentUser.length > 6) {
			System.out.println("2: Joint Account 1. Balance = " + jointBalance1);
		}
		if(currentUser.length > 7) {
			System.out.println("3: Joint Account 2. Balanc = " + jointBalance2);
		}
		int a = input.nextInt();
		int b = -1;
		while(b < 0) {
			System.out.println("How much would you like to Deposit?");
			b = input.nextInt();
			if(b < 0) {
				System.out.println("Cannot Deposit A Negative.");
				continue;
			}
		}
		switch (a) {
		case 1:
			userCustomer.setAccountValue(b + userCustomer.getAccountValue());
			System.out.println("New Balance: "+ userCustomer.getAccountValue());
			break;
		case 2:
			jointBalance1 += b;
			System.out.println("New Balance: "+ jointBalance1);
			break;
		case 3:
			jointBalance2 += b;
			System.out.println("New Balance: "+ jointBalance2);
			break;
		}
	}
	//withdraws from an account
	public static void withdraw() {
		System.out.println("Choose Account to Withdraw From:");
		System.out.println("1. Account 1. Balance = " + userCustomer.getAccountValue());
		if(currentUser.length > 6) {
			System.out.println("2: Joint Account 1. Balance = " + jointBalance1);
		}
		if(currentUser.length > 7) {
			System.out.println("3: Joint Account 2. Balanc = " + jointBalance2);
		}
		int a = input.nextInt();
		int b = 1;
		while(b < 0) {
			System.out.println("How much would you like to Withdraw?");
			b = input.nextInt();
			if(b < 0) {
				System.out.println("Cannot Withdraw A Negative.");
				continue;
			}
		}
		switch (a) {
		case 1:
			if(b > userCustomer.getAccountValue()) {
				System.out.println("Error: Insufficient Funds");
				break;
			}
			userCustomer.setAccountValue(b - userCustomer.getAccountValue());
			System.out.println("New Balance: "+ userCustomer.getAccountNumber());
			break;
		case 2:
			if(b > jointBalance1) {
				System.out.println("Error: Insufficient Funds");
				break;
			}
			jointBalance1 -= b;
			System.out.println("New Balance: "+ jointBalance1);
			break;
		case 3:
			if(b > jointBalance2) {
				System.out.println("Error: Insufficient Funds");
				break;
			}
			jointBalance2 -= b;
			System.out.println("New Balance: "+ jointBalance2);
			break;
		}
	}
	//to get saved on the Applications file
	public static void apply() {
		
	}
	//to transfer funds
	public static void transfer() {
		System.out.println("Choose Account to Transfer From:");
		System.out.println("1. Account 1. Balance = " + userCustomer.getAccountValue());
		System.out.println("2: Joint Account 1. Balance = " + jointBalance1);
		if(currentUser.length > 7) {
			System.out.println("3: Joint Account 2. Balanc = " + jointBalance2);
		}
		int a = input.nextInt();
		System.out.println("Choose Account to Recieve Transfer: ");
		int c = input.nextInt();
		int b = 1;
		while(b < 0) {
			System.out.println("How much would you like to Deposit?");
			b = input.nextInt();
			if(b < 0) {
				System.out.println("Cannot Deposit A Negative.");
				continue;
			}
		}
		switch (a) {
		case 1:
			if(c == 2){
				if(b > userCustomer.getAccountValue()) {
					System.out.println("Error: Insufficient Funds");
					break;
				}
			
				userCustomer.setAccountValue(b - userCustomer.getAccountValue());
				jointBalance1 += b;
				System.out.println("New Balance: "+ jointBalance1);
				break;
			}
			if(c == 3){
				if(b > userCustomer.getAccountValue()) {
					System.out.println("Error: Insufficient Funds");
					break;
				}
				userCustomer.setAccountValue(b - userCustomer.getAccountValue());
				jointBalance2 += b;
				System.out.println("New Balance: "+ jointBalance1);
				break;
			}
			break;
		case 2:
			if(c == 1) {
				if(b > jointBalance1) {
					System.out.println("Error: Insufficient Funds");
					break;
				}
				userCustomer.setAccountValue(b + userCustomer.getAccountValue());
				jointBalance1 -= b;
				System.out.println("New Balance: "+ jointBalance1);
				break;
				
			}
			if(c == 3) {
				if(b > jointBalance1) {
					System.out.println("Error: Insufficient Funds");
					break;
				}
				jointBalance1 -= b;
				jointBalance2 += b;
				System.out.println("New Balance: "+ jointBalance1);
				break;
				
				
			}
			break;
		case 3:
			if(c == 1) {
				if(b > jointBalance2) {
					System.out.println("Error: Insufficient Funds");
					break;
				}
				userCustomer.setAccountValue(b + userCustomer.getAccountValue());
				jointBalance2 -= b;
				System.out.println("New Balance: "+ jointBalance1);
				break;
			}
			if(c == 2) {
				if(b > jointBalance2) {
					System.out.println("Error: Insufficient Funds");
					break;
					}
				jointBalance1 += b;
				jointBalance2 -= b;
				System.out.println("New Balance: "+ jointBalance1);
				break;
			}
			break;
		}
	}
		
	
	/*
	 * End of functions
	 * --------------------------------------------------
	 * Start of main
	 */
	
	public static void main(String[] args) {
		
		String[] accounts = readInputStreamContents();
		inFile = "Applications.txt";
		String[] applications = readInputStreamContents();
		inFile = "JointAccounts.txt";
		String[] jointaccounts = readInputStreamContents();
		
		
		int i = 0;
		while (i != -1){
			//user input: 
			//create account or account login
			System.out.println("Type integer to proceed: ");
			System.out.println("1 = Login");
			System.out.println("2 = Create Account");
			System.out.println("-1 = Shut Down");
			i = input.nextInt();
			if (i == -1) {
				//Terminate program
				System.out.println("Goodbye!");
				return;
			}
			if(i == 1) {
				login(i);
				
				lookup = search();
				System.out.println(lookup);
				switch(lookup) {
				case "Employee":
					while(i != -1) {
						System.out.println("What would you like to do?");
						System.out.println("1: View Customer Account Information");
						System.out.println("2: Approve/Deny Applications");
						System.out.println("-1: Shut Down");
		
						i = input.nextInt();
						switch(i) {
						case 1:
							System.out.println("Enter customer username: ");
							username = input.next();
							customerSearch(accounts);
							break;
						case 2:
							//review();
							break;
						default:
							break;
						}
					}
					
					break;
				case "BankAdmin":
					//view/edit all accounts
					//close accounts
					//approve/deny application
					//withdraw/deposit/transfer
					System.out.println("What would you like to do?");
					System.out.println("1: View Customer Account Information");
					System.out.println("2: Approve/Deny Applications");
					System.out.println("-1: Shut Down");
	
					i = input.nextInt();
					switch(i) {
					case 1:
						System.out.println("Enter customer username: ");
						username = input.next();
						customerSearch(accounts);

						System.out.println("What would you like to do?");
						System.out.println("1: Deposit");
						System.out.println("2: Withdraw");
						if(currentUser.length > 6) {
							System.out.println("3: Transfer");
						}
						i = input.nextInt();
						switch (i) {
						case 1:
							deposit();
							break;
						case 2:
							withdraw();
							break;
						case 3:
							transfer();
							break;
						}
						
						break;
					case 2:
						//review();
						break;
					}
					break;
				case "Customer":
					//view -their- account info
					customerSearch(accounts);
					if(customerFound == false) {
						System.out.println("Username/Password not found.");
						break;
					}else {
						jointAccountSearch(jointaccounts);
						System.out.println("What would you like to do?");
						System.out.println("1: Deposit");
						System.out.println("2: Withdraw");
						System.out.println("3: Apply For A Joint Account: ");
						if(currentUser.length > 6) {
							System.out.println("4: Transfer");
						}
						i = input.nextInt();
						switch (i) {
						case 1:
							deposit();
							break;
						case 2:
							withdraw();
							break;
						case 3:
							apply();
							break;
						case 4:
							transfer();
							break;
						}
					}
					break;
				}
				for(int a = 0; a < accounts.length; a++) {
					
				}
			}
			if(i == 2) {
				apply();
			}else if(i != 1){
				System.out.println("ERROR: Enter a correct value.");
			}
			outFile = "Accounts.txt";
			for(int x = 0; x < accounts.length; x++) {
				if(x == customerPlaceholder) {
					writeOutputStreamContents(currentUser);
					continue;
				}
				writeOutputStreamContents(accounts);
			}
			outFile = "JointAccounts.txt";
			for(int x = 0; x < jointaccounts.length; x++) {
				if(x == jointPlaceholder1) {
					writeOutputStreamContents(currentUser);
					continue;
				}
				if(x == jointPlaceholder2) {
					writeOutputStreamContents(currentUser);
					continue;
				}
				writeOutputStreamContents(jointaccounts);
			}
			outFile = "Applications.txt";
			for(int x = 0; x < applications.length; x++) {
				if(x == jointPlaceholder1) {
					writeOutputStreamContents(currentUser);
					continue;
				}
				writeOutputStreamContents(applications);
			}
		}
		
	}
	
	

}
