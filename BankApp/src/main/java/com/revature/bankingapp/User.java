package com.revature.bankingapp;

public abstract class User {
	
	String firstName;
	String lastName;	
	String userID;
	String passWord;
	
	abstract void viewBalance();
	abstract void viewTransactions();
	abstract void viewAccountInfo();
}
