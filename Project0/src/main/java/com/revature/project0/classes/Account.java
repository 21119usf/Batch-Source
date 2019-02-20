package com.revature.project0.classes;

import java.io.Serializable;
import java.util.Random;

public class Account implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1124949625755851922L;

	private double balance;
	
	private final int accountNumber;
	
	public Account(int accountNumber)
	{
		this.balance = 0;
		this.accountNumber = accountNumber;
	}
	
	public Account(double balance, int accountNumber)
	{
		this.balance = balance;
		this.accountNumber = accountNumber;
	}
	
	public double getBalance() 
	{
		return balance;
	}

	public double withdraw(double withdrawlAmount)
	{
		if(this.balance > withdrawlAmount)
		{
			this.balance -= withdrawlAmount;
		}
		else
		{
			System.out.println("Your balance is to low");
		}
		
		return this.balance;
	}
	
	public double deposit(double depositAmount)
	{
		this.balance += depositAmount;
		
		return this.balance;
	}

	public int getAccountNumber() 
	{
		return accountNumber;
	}
}
