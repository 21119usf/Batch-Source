package com.revature.bankingapp;

public abstract class Account {
	
	int accountNum;
	float balance;
	String custFirst;
	String custLast;
	
	abstract void transfer();
	abstract void view();
	void deposit(float a) {
		// TODO Auto-generated method stub
		
	}
	void withdraw(float b) {
		// TODO Auto-generated method stub
		
	}

}
