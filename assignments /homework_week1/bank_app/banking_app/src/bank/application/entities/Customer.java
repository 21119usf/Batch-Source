package bank.application.entities;
import java.util.*;

public class Customer extends User {	
	
	private String username; 
	private String password; 
	private boolean applyJointAccount;
	private double balance; 
	private int level_of_approval; 
	private String CustomerID; 
	private int type_of_entity; 
	
	public Customer(String firstname, String lastname, String address, String userID, String email, String pn) {
		super(firstname, lastname, address, userID, email, pn);
		// TODO Auto-generated constructor stub
		Random rd = new Random();
		this.password = "N/A"; 
		this.username = "N/A"; 
		this.CustomerID = firstname.charAt(0) + lastname.charAt(0) + userID.charAt(userID.length()-1) + "" + rd.nextInt(99999) ; 
		applyJointAccount = false; 
		balance = 0.0; 
		level_of_approval = 1; 
		setType_of_entity(1); 
	}
	//setters and getters 
	//get balance
	
	public boolean isApplyJointAccount() {
		return applyJointAccount;
	}

	public int getType_of_entity() {
		return type_of_entity;
	}

	public void setType_of_entity(int type_of_entity) {
		this.type_of_entity = type_of_entity;
	}

	public void setApplyJointAccount(boolean applyJointAccount) {
		this.applyJointAccount = applyJointAccount;
		
	}


	public int getLevel_of_approval() {
		return level_of_approval;
	}


	public void setLevel_of_approval(int level_of_approval) {
		this.level_of_approval = level_of_approval;
	}

	public String getCustomerID() {
		return CustomerID;
	}
	
	public void setCustomerID(String customerID) {
		CustomerID = customerID;
	}
	
	public double getBalance() {
		return balance;
	}
	
	//set balance
	public void setBalance(double balance) {
		this.balance = balance; 
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

	//utility methods 
	//deposit

	public void deposit(double amount) { //gotta be multiple of 20s only
		if(level_of_approval == 2) {
				if(amount <= 0 || amount/20 != 0)
					System.out.println("Ammount deposited is either negative or "
							+ "not multiple of 20");
				else
					setBalance(getBalance() + amount); 
		}else {
			System.out.println("You have to open an account to make a deposit");
		}
	}
	//withdraw 
	public void withdraw(int amount) {
		if(level_of_approval == 2) {
		if(amount <= 0 || amount/20 != 0)
			System.out.println("Ammount trying to withdraw is either negative or "
					+ "not multiple of 20");
		else if (amount > getBalance())
			System.out.println("not suffitient balance");
		else
			setBalance(getBalance() - amount); 
		}else {
			System.out.println("You have to open an account to make a Withdrawl");
		}
	}
	//transfer
	public void transfer(Customer recipient, double amount) {
		if(level_of_approval == 2) {
				if(negative_amount(amount))
					System.out.println("negative ammount cannot be transfered!");
				else if (over_drawing(amount))
					System.out.println("not sufficient balance");
				else {
					setBalance(getBalance() - amount); 
					recipient.setBalance(recipient.getBalance() + amount);
				}
		}else {
			System.out.println("You have to open an account to make a transfer");
		}
	}
	//check for overdrawing
	public boolean over_drawing(double amount) {
		return (amount > getBalance()) ? true : false; 
	}
	//check for negative values
	public boolean negative_amount(double amount) {
		return (amount < 0) ? true : false; 
	}

	
	
}	

