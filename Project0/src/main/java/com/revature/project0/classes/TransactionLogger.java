package com.revature.project0.classes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TransactionLogger 
{
	static Logger transactionLogger = LogManager.getLogger(TransactionLogger.class);
	
	public void logWithdrawl(String username, double amount)
	{
		transactionLogger.info(username 
				+ " withdrew $" + String.valueOf(amount));
	}
	
	public void logDeposit(String username, double amount)
	{
		transactionLogger.info(username 
				+ " deposited $" + String.valueOf(amount));
	}
	
	public void logTransfer(String username1, String username2, double amount)
	{
		transactionLogger.info(username1 
				+ " transferred $" + String.valueOf(amount) + " to " + username2);
	}
}
