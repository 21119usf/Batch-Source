package com.revature.person;

import java.util.ArrayList;
import java.util.Scanner;

public class Customer extends Person {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6382811326504511529L;
	private int userID;
	private String userName;
	private String password;
	private String email;
	private long phoneNumber;
	private String firstName;
	private String lastName;
	private ArrayList<Integer> accountID;
	int balance;
	int previousTransaction;
	
	void deposit(int amount) {
		if(amount != 0) {
			balance = balance + amount;
			previousTransaction = amount;
		}
	}
	void withdraw(int amount) {
		if(amount != 0) {
			balance = balance - amount;
			previousTransaction = amount;
		}
	}
		void getPreviousTransaction() {
			if(previousTransaction < 0) {
				System.out.println("Deposited: "+ previousTransaction);
			}
			else if(previousTransaction > 0) {
				System.out.println("Withdrawn: "+ previousTransaction);
				// Math.abs changes the negative amount to a positive
			}
			else{
				System.out.println("No Transaction Occured");
			}
		}
		
	void custMenu(String userName, int userID) {
		char option = 0;
		Scanner scanner = new Scanner(System.in);
	
	do {
		System.out.println();
		System.out.println("Enter an option: ");
		option = scanner.next().charAt(0);
		System.out.println();
		
	switch(option) {
	
	
	case 'A':
		System.out.println("Welcome "+userName);
		System.out.println("User ID "+userID);
		System.out.println();
		System.out.println("1. Check Balance");
		System.out.println("2. Deposit");
		System.out.println("3. Withdraw");
		System.out.println("4. Previous Transactions");
		System.out.println("E. Exit");
		break;
	case '1':
		System.out.println();
		System.out.println("Balance: "+balance);
		System.out.println();
		break;
	case '2':
		System.out.println();
		System.out.println("Enter an amount to deposit: ");
		System.out.println();
		int amount = scanner.nextInt();
		deposit(amount);
		System.out.println();
		break;
	case '3':
		System.out.println();
		System.out.println("Enter an amount to withdraw: ");
		System.out.println();
		int amount2 = scanner.nextInt();
		withdraw(amount2);
		System.out.println();
		break;
	case '4':
		System.out.println();
		getPreviousTransaction();
		System.out.println();
		break;
	case 'E':
		System.out.println("****");
		break;
		
	default:
		System.out.println("Invaild option, please enter again.");
		break;
	}
	}  while(option != 'E');
System.out.println("Thank you for using our services! ");
}
		

	
	
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public ArrayList<Integer> getAccountID() {
		return accountID;
	}
	public void setAccountID(ArrayList<Integer> accountID) {
		this.accountID = accountID;
	}
	public Customer(int userID, String userName, String password, String email, long phoneNumber, String firstName,
			String lastName, ArrayList<Integer> accountID) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.accountID = accountID;
	}
	@Override
	public String toString() {
		return "Customer [userID=" + userID + ", userName=" + userName + ", password=" + password + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", accountID=" + accountID + "]";
	}
	
	
}
