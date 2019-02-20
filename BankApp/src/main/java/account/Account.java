package account;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

import bankactors.Customer;

public class Account implements Serializable, Comparator<Account>
{
	private static final long serialVersionUID = -1867442308947344661L;
	private int accountID;
	private String name;
	private String status;
	private boolean open;
	private double balance;
	private ArrayList<Customer> users;
	
	
	public Account(Customer c)
	{
		Random r = new Random();
		accountID = r.nextInt(100);
		setName("Account: " + accountID);
		setOpen(false);
		setBalance(0.00);
		users = new ArrayList<Customer>();
		setUsers(c);
	}
	

	public int getAccountID() {return accountID;}
	public String getName() { return name;}
	public String getStatus() {return status;}
	public boolean isOpen() {return open;}
	public double getBalance() {return balance;}
	public ArrayList<Customer> getUsers() {return users;}
	
	public void setAccountID(int accountID) {this.accountID = accountID;}
	public void setName(String name) {this.name = name;}
	public void setStatus(String status) {this.status = status;}
	public void setOpen(boolean open) 
	{
		if(open)
		{
			this.open = true;
			this.status = "Open";
		}
		else
		{
			this.open = false;
			this.status = "Closes";
		}
	}
	public void setBalance(double balance) {this.balance = balance;}
	public void setUsers(Customer users) {this.users.add(users);}
	
	
	public boolean deposit(double amount)
	{
		if(isOpen() && amount > 0.0)
		{
			balance += amount;
			return true;
		}
		System.out.println("Denied");
		return false;
	}
	
	public boolean withdraw(double amount)
	{
		if(isOpen() && !overdraw(amount))
		{
			balance = balance - amount;
			return true;
		}
		System.out.println("Denied");
		return false;
	}
	
	public boolean overdraw(double amount)
	{
		if(amount > balance)
		{
			System.out.println("You are overdrawing!");
			return true;
		}
		return false;
	}
	
	public boolean transfer(Account a, double amount)
	{
		if(isOpen() && a.isOpen())
		{
			if(withdraw(amount) && a.deposit(amount))
			{
				return true;
			}
		}
		return false;
	}
	
	public void addUser(Customer c)
	{
		users.add(c);
	}
	
	public void removeUser(Customer c)
	{
		users.remove(c);
	}
	
	public int compare(Account a1, Account a2)
	{
		return a1.getAccountID()-a2.getAccountID();
	}
}
