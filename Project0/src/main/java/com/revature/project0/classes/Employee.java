package com.revature.project0.classes;


public class Employee extends User 
{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1997650520179075879L;
	
	private ApplicationManager applicationManager;
	
	public Employee(String username, String password) 
	{
		super(username, password);
		applicationManager = new ApplicationManager();
	}
	
	
	public void approveApplication(AccountApplication application)
	{
		applicationManager.approveApplication(application);
	}	
	
	public void denyApplication(AccountApplication application)
	{
		applicationManager.denyApplication(application);
	}
}
