package com.revature.project0.classes;

public class Customer extends User 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 346129078310983645L;

	private String address;
	
	private String firstName;
	
	private String lastName;
	
	public Customer(String username, String password) 
	{
		super(username, password);
		
		address = "";
		
		firstName = "";
		
		lastName = "";
	}

	public String getAddress() 
	{
		return address;
	}

	public void setAddress(String address) 
	{
		this.address = address;
	}

	public String getFirstName() 
	{
		return firstName;
	}

	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}

	public String getLastName() 
	{
		return lastName;
	}

	public void setLastName(String lastName) 
	{
		this.lastName = lastName;
	}
	
	

}
