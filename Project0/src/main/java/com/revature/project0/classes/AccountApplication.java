package com.revature.project0.classes;

import java.io.Serializable;

public class AccountApplication implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6471022586696891991L;

	private boolean applicationStatus;
	
	private final Customer customer;
	
	private final double initialBalance;
	
	public AccountApplication(Customer customer)
	{
		this.customer = customer;
		
		this.initialBalance = 0;
		
		this.applicationStatus = false;
	}
	
	public AccountApplication(Customer customer, double initialBalance)
	{
		this.customer = customer;
		
		this.initialBalance = initialBalance;
		
		this.applicationStatus = false;
	}

	public boolean isApplicationStatus() 
	{
		return applicationStatus;
	}

	public void setApplicationStatus(boolean applicationStatus) 
	{
		this.applicationStatus = applicationStatus;
	}

	public Customer getCustomer() 
	{
		return customer;
	}

	public double getInitialBalance() 
	{
		return initialBalance;
	}
}
