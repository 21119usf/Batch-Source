package com.revature.project0.classes;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.revature.project0.jdbc.ApprovedCustomerDAOImp;

public class AccountManager 
{
	private static Map<Account, Customer> accountOwnershipMap
		= new HashMap<Account, Customer>();
	
	private static ApprovedCustomerDAOImp customerDAO = new ApprovedCustomerDAOImp();
	
	public void addNewAccount(Customer customer, double initialBalance)
	{
		Account account = new Account(initialBalance,0);
		CustomerManager.getAccountOwnershipMap().put(customer, account);
		accountOwnershipMap.put(account, customer);
		try 
		{
			customerDAO.insertNewCustomer(customer,account);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
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
