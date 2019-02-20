package com.revature.project0.classes;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class ApplicationManager implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3190714050416592140L;
	
	private static Map<AccountApplication, Customer> applicationOwnershipMap 
		= new HashMap<AccountApplication, Customer>();
	
	public void createNewApplication(Customer user)
	{
		this.createNewApplication(user, 0);
	}
	
	public void createNewApplication(Customer user, double intitialBalance)
	{
		AccountApplication application = new AccountApplication(user, intitialBalance);
		applicationOwnershipMap.put(application, user);
	}
	
	public void approveApplication(AccountApplication application)
	{
		application.setApplicationStatus(true);
		
		AccountManager accountManager = new AccountManager();
		
		accountManager.addNewAccount(application.getCustomer(), application.getInitialBalance());
		
		applicationOwnershipMap.remove(application);
	}
	
	public void denyApplication(AccountApplication application)
	{
		application.setApplicationStatus(false);
		
		this.applicationOwnershipMap.remove(application);
	}
	
	public AccountApplication findApplicationByUsername(String username)
	{
		AccountApplication foundApplication = null;
		
		for(AccountApplication application : this.applicationOwnershipMap.keySet())
		{
			if(this.applicationOwnershipMap.get(application).getUsername().equals(username))
			{
				foundApplication = application;
				break;
			}
		}
		
		return foundApplication;
	}

	public static Map<AccountApplication, Customer> getApplicationOwnershipMap() 
	{
		return applicationOwnershipMap;
	}

	public static void setApplicationOwnershipMap(Map<AccountApplication, Customer> applicationOwnershipMap) {
		ApplicationManager.applicationOwnershipMap = applicationOwnershipMap;
	}
	
}
