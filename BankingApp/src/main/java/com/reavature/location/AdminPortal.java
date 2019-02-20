package com.reavature.location;

import java.util.Scanner;

import com.reavature.service.AccountsService;
import com.reavature.service.UserService;
import com.reavature.service.ValidationException;
import com.revature.beans.Account;
import com.revature.beans.Admin;

public class AdminPortal {
	
	Admin a;
	
	public AdminPortal(Admin a) {
		super();
		this.a = a;
	}


	public void display() {
		System.out.println("Welcome To The Admin Portal");
		System.out.println("Please Select An Option");
		System.out.println("(1) Create Employee");
		System.out.println("(2) View Applications");
		System.out.println("(3) Close Account");
		System.out.println("(4) Account Transactions");
		System.out.println("(5) Assing Customer To Employee");
		router();
	}
	
	private void router() {
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		
		switch(input) {
			case "1":
				UserService.createEmployee();
				break;
			case "2":
				new ViewApplications(a).display();
				break;
			case "3":
				closeAccount();
				break;
			case "4":
				accountTransactions();
				break;
			case "5":
				assignCustomer();
			default:
				System.out.println("Invalid Input");
				display();
		}
	}
	
	private void closeAccount() {
		Scanner in = new Scanner(System.in);
		int accountToCloseId;
		System.out.println("Select account to close");
		for (Account x : AccountsService.getAccounts()) {
			System.out.println("ID: " + x.getId() + "Balance: "  + x.getBalance());
		}
		accountToCloseId = in.nextInt();
		AccountsService.closeAccount(accountToCloseId);
		System.out.println("Account Clsoed");
	}
	
	private void accountTransactions() {
		System.out.println("Please select an option");
		System.out.println("(1) Deposit");
		System.out.println("(2) Withdraw");
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		switch (input) {
			case "1":
				deposit();
				break;
			case "2":
				withdraw();
				break;
			default:
				System.out.println("Invalid Input");
				accountTransactions();
		}
	}
	
	public void deposit() {
		Scanner in = new Scanner(System.in);
		int a1Id;
		int a2Id;
		double ammount;
		System.out.println("Please Enter Account to Withdraw From");
		a1Id = Integer.parseInt(in.nextLine());
		System.out.println("Please Enter Account to Deposit Into");
		a2Id = in.nextInt();
		System.out.println("please enter Ammount");
		ammount = in.nextDouble();
		Account a = AccountsService.getAccountById(a1Id);
		try {
			a.transferTo(a2Id, ammount);
		} catch (ValidationException e) {
			System.out.println(e.getMessage());
			display();
		}
	}
	
	private void withdraw() {
		Scanner in = new Scanner(System.in);
		int a1Id;
		int a2Id;
		double ammount;
		System.out.println("Please Enter Account to Withdraw From");
		a1Id = Integer.parseInt(in.nextLine());
		System.out.println("Please Enter Account to Deposit Into");
		a2Id = in.nextInt();
		System.out.println("Please Enter Ammount");
		ammount = in.nextDouble();
		Account a = AccountsService.getAccountById(a1Id);
		try {
			a.transferTo(a2Id, ammount);
		} catch (ValidationException e) {
			System.out.println(e.getMessage());
			display();
		}
	}
	
	private void assignCustomer() {
		Scanner in = new Scanner(System.in);
		int customerId;
		int employeeId;
		System.out.println("Please Enter Customer Id");
		customerId = in.nextInt();
		System.out.println("Please Enter Employeee Id");
		employeeId = in.nextInt();
	}
}
