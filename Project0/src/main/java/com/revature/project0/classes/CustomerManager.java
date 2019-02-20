package com.revature.project0.classes;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class CustomerManager implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -586381320477593170L;
	
	private static TransactionLogger logger = new TransactionLogger();
	
	private static Map<Customer, Account> accountOwnershipMap 
		= new HashMap<Customer, Account>(); 
	
	public void deposit(Customer user, double amount)
	{
		accountOwnershipMap.get(user).deposit(amount);
		logger.logDeposit(user.getUsername(), amount);
	}
	
	public void withdraw(Customer user, double amount)
	{
		accountOwnershipMap.get(user).withdraw(amount);
		logger.logWithdrawl(user.getUsername(), amount);
	}
	
	public void transfer(Customer user1, Customer user2, double amount)
	{
		accountOwnershipMap.get(user1).withdraw(amount);
		accountOwnershipMap.get(user2).deposit(amount);
		logger.logTransfer(user1.getUsername(), user2.getUsername(), amount);
	}
	
	public void addNewUser(Customer newUser, Account account)
	{
		accountOwnershipMap.put(newUser, account);
	}
	
	public void removeUser(Customer user)
	{
		accountOwnershipMap.remove(user);
	}
	
	public Customer findCustomerWithUserName(String username)
	{
		Customer foundCustomer = null;
		
		for(Customer customer : this.accountOwnershipMap.keySet())
		{
			if(customer.getUsername().equals(username))
			{
				foundCustomer = customer;
				break;
			}
		}
		
		return foundCustomer;
	}

	public static void setAccountOwnershipMap(Map<Customer, Account> accountOwnershipMap) {
		CustomerManager.accountOwnershipMap = accountOwnershipMap;
	}

	public static Map<Customer, Account> getAccountOwnershipMap() 
	{
		return accountOwnershipMap;
	}
}
