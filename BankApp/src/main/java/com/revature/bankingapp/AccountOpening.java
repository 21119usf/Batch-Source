package com.revature.bankingapp;

import java.util.Scanner;

public class AccountOpening {

	public Scanner in = new Scanner(System.in);
	
	public void openIndividual(String logName, String logPW) {
		
		String fn;
		String ln;
		int acctNum;
		float deposit;
		Individual acct1 = new Individual();
		Customer user1 = new Customer();
				
		user1.setUserID(logName);
		user1.setPassWord(logPW);


		acct1.setUserName(logName);
		
		System.out.println("Enter your first name");
		fn=in.nextLine();
		String fnn = toUpperCase(fn);
		acct1.setCustFirst(fnn);
		user1.setFirstName(fnn);
		
		System.out.println("Enter your last name");
		ln=in.nextLine();
		String lnn = toUpperCase(ln);
		acct1.setCustLast(lnn);
		user1.setLastName(lnn);
		
		acctNum=(int)(Math.random()*100+1)+100000;
		acct1.setAccountNum(acctNum);
		
		System.out.println("How much would you like to deposit? ");
		deposit=in.nextFloat();
		acct1.setBalance(deposit);
		
		
		IOFile.individualApplication.add(acct1);
		IOFile.writeApplicationFile();
		
		/*IOFile.userCust.add(user1);
		IOFile.individualList.add(acct1);
		IOFile.writeUserFile();
		IOFile.writeAccountFile();*/
		
		System.out.println("Your application is being processed for approval");
		System.out.println("===============================================\n\n\n\n\n\n");
		
		
		WelcomeScreen w = new WelcomeScreen();
		w.introduction();
	}
	
	public void openJoint(String logName, String logPW) {
		String fn, fn2;
		String ln, ln2;
		int acctNum;
		float deposit;
		
		Joint acct2 = new Joint();
		Customer user2 = new Customer();
		
		user2.setUserID(logName);
		user2.setPassWord(logPW);

		System.out.println("Enter your first name");
		fn=in.nextLine();
		String fnn = toUpperCase(fn);
		acct2.setCustFirst(fnn);
		System.out.println("Enter your last name");
		ln=in.nextLine();
		String lnn = toUpperCase(ln);
		acct2.setCustLast(lnn);
		
		System.out.println("Enter co-owner's first name");
		fn2=in.nextLine();
		String fnn2 = toUpperCase(fn2);
		acct2.setCoFirst(fnn2);
		System.out.println("Enter co-owner's last name");
		ln2=in.nextLine();
		String lnn2 = toUpperCase(ln2);
		acct2.setCoLast(lnn2);
		
		
		acctNum=(int)(Math.random()*100+1)+100000;
		acct2.setAccountNum(acctNum);
		System.out.println("How much would you like to deposit? ");
		deposit=in.nextFloat();
		acct2.setBalance(deposit);
		
		IOFile.jointApplication.add(acct2);
		IOFile.writeApplicationFile();
		System.out.println("Your application is being processed for approval");
		System.out.println("===============================================\n\n\n\n\n\n");
		
		WelcomeScreen w = new WelcomeScreen();
		w.introduction();
	}
	
	public void createEmployee(String logName, String logPW) {
		String fn;
		String ln;
		Employee empl1 = new Employee();
				
		empl1.setUserID(logName);
		empl1.setPassWord(logPW);
	
		System.out.println("Enter your first name");
		fn=in.nextLine();
		String fnn = toUpperCase(fn);
		empl1.setFirstName(fnn);
		
		System.out.println("Enter your last name");
		ln=in.nextLine();
		String lnn = toUpperCase(ln);
		empl1.setLastName(lnn);
				
		IOFile.userEmp.add(empl1);
		IOFile.writeUserFile();
		
		WelcomeScreen w = new WelcomeScreen();
		w.introduction();
	}
	public void createAdmin(String logName, String logPW) {
		String fn;
		String ln;
		Admin admin1 = new Admin();
				
		admin1.setUserID(logName);
		admin1.setPassWord(logPW);
	
		System.out.println("Enter your first name");
		fn=in.nextLine();
		String fnn = toUpperCase(fn);
		admin1.setFirstName(fnn);
		
		System.out.println("Enter your last name");
		ln=in.nextLine();
		String lnn = toUpperCase(ln);
		admin1.setLastName(lnn);
				
		IOFile.userAdmin.add(admin1);
		IOFile.writeUserFile();
		
		WelcomeScreen w = new WelcomeScreen();
		w.introduction();
	}
	public static String toUpperCase(String str) {
		char[] f = new char[str.length()];
		for(int i=0;i<str.length();i++) {
			f[i]=Character.toUpperCase(str.charAt(i));	
		}
		String name = new String(f);
		return name;
	}
}
