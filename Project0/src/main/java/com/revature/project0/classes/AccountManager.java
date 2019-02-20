package com.revature.project0.classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class AccountManager 
{
	private static Map<Account, Customer> accountOwnershipMap
		= new HashMap<Account, Customer>();
	
	public void addNewAccount(Customer customer, double initialBalance)
	{
		CustomerManager manager = new CustomerManager();
		Account account = new Account(initialBalance, this.generateAccountNumber());
		manager.getAccountOwnershipMap().put(customer, account);
		accountOwnershipMap.put(account, customer);
	}
	
//	public void addCustomerToExistingAccount(Account account, Customer customer)
//	{
//		if(accountOwnershipMap.containsKey(account))
//		{
//			accountOwnershipMap.get(account).add(customer);
//		}
//		else
//		{
//			System.out.println("That account does not exist.");
//		}
//	}
	
	private int generateAccountNumber()
	{
		Random random = new Random();
		
		return random.nextInt((19999 - 10000) + 1) + 10000;
	}

	public static Map<Account, Customer> getAccountOwnershipMap() 
	{
		return accountOwnershipMap;
	}

	public static void setAccountOwnershipMap(Map<Account, Customer> accountOwnershipMap) {
		AccountManager.accountOwnershipMap = accountOwnershipMap;
	}
}
