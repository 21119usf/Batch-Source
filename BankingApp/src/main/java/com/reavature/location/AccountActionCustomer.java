package com.reavature.location;

import java.util.Scanner;

import com.reavature.service.AccountsService;
import com.reavature.service.ValidationException;
import com.revature.beans.Account;

public class AccountActionCustomer {
	
	Account a;
	
	
	public AccountActionCustomer(Account a) {
		super();
		this.a = a;
	}

	public void display() {
		System.out.println("Please Select An Option");
		System.out.println("(1) Withdraw");
		System.out.println("(2) Deposit");
		System.out.println("(3) Add User To Account");
		parseInput();
	}
	
	private void parseInput() {
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		
		switch(input) {
			case "1":
				withdraw();
				break;
			case "2":
				deposit();
				break;
			case "3":
				addUser();
				break;
			default:
				System.out.println("Invalid Input");
				display();
		}
	}
	
	private void withdraw() {
		Double ammount;
		int accountToTransferToId;
		
		System.out.println("Please enter ammount to withdraw");
		System.out.println("Balance: " + a.getBalance());
		Scanner in = new Scanner(System.in);
		ammount = Double.parseDouble(in.nextLine());
		System.out.println("Account Id To Deposit Into");
		accountToTransferToId = Integer.parseInt(in.nextLine());
		try {
			a.transferTo(accountToTransferToId, ammount);
		} catch (ValidationException e) {
			e.getMessage();
			display();
		}
	}
	
	private void deposit() {
		Double ammount;
		int accountToTransferToId;
		
		System.out.println("Please enter ammount to deposit");
		System.out.println("Balance: " + a.getBalance());
		Scanner in = new Scanner(System.in);
		ammount = Double.parseDouble(in.nextLine());
		System.out.println("Account Id To Withdraw Into");
		accountToTransferToId = Integer.parseInt(in.nextLine());
		try {
			a.transferFrom(accountToTransferToId, ammount);
		} catch (ValidationException e) {
			e.getMessage();
			display();
		}
	}
	
	private void addUser() {
		System.out.println("Enter User Id To Add");
		Scanner in = new Scanner(System.in);
		int accountIdToAdd = Integer.parseInt(in.nextLine());
		AccountsService.addUserToAccount(a, accountIdToAdd);
	}
}
