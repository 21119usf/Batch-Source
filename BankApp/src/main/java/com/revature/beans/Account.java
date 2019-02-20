package com.revature.beans;

import java.io.Serializable;
import java.text.DecimalFormat;


import com.revature.bank.Utility;

public class Account implements Serializable{
	
	/*Account contains information on a customers account including its owner/s, balance and id.
	 * It contains basic getter/setter/contructors as well as deposit/withdraw/transfer methods to
	 * facilitate banking functionality needed in other classes.
	 * 
	 */
	private static final long serialVersionUID = 4887677321543437179L;
	private static DecimalFormat df = new DecimalFormat("#.##");
	
	private int id;
	private double balance;
	Customer cust1;
	Customer cust2;
	boolean isJoint;
	
	public static double format(double d) {
		String s = df.format(d);
		return Double.parseDouble(s);
	}
	public Account(int id, double balance, Customer cust1, Customer cust2, boolean isJoint) {
		super();
		this.id = id;
		this.balance = format(balance);
		this.cust1 = cust1;
		this.cust2 = cust2;
		this.isJoint = isJoint;
	}
	public void withdraw(double amount) {
		if(balance - amount >= 0 && amount > 0) {
			balance = format(balance - amount);
			System.out.println("Successfuly withdrawn: "+amount);
			System.out.println("Remaining balance : "+balance);
		}else if(balance - amount < 0){
			System.out.println("Insufficient funds :(");
		}else {
			System.out.println("Haha nice try");
		}
	}
	public void deposit(double amount) {
		if(amount > 0) {
			balance = format(balance + amount);
			System.out.println("Successfuly deposited: "+amount);
			System.out.println("Current balance : "+balance);
		}
		else {
			System.out.println("Cannot deposit a negative amount, that's what withdraw is for");
		}
	}
	
	public void transfer(double amount, int accountNum) {
		if(balance > amount && (Utility.findAccount(accountNum) != null)) {
			balance = format(balance - amount);
			Utility.findAccount(accountNum).transferReceived(amount);;
		}else if(balance <= amount){
			System.out.println("Insufficient funds");
		}else {
			System.out.println("Account does not exist");
		}
	}
	
	public void transferReceived(double amount) {
		balance = format(balance + amount);
		System.out.println(amount+" dollars succesfully transfered");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBalance() {
		return format(balance);
	}

	public void setBalance(double balance) {
		this.balance = format(balance);
	}

	public Customer getCust1() {
		return cust1;
	}

	public void setCust1(Customer cust1) {
		this.cust1 = cust1;
	}

	public Customer getCust2() {
		return cust2;
	}

	public void setCust2(Customer cust2) {
		this.cust2 = cust2;
	}

	public boolean isJoint() {
		return isJoint;
	}

	public void setJoint(boolean isJoint) {
		this.isJoint = isJoint;
	}
	@Override
	public String toString() {
		String joint = "";
		if(isJoint)joint = "\n\tJoint with 	: "+cust2.getUsername();
		return 	"\n\tAccount ID	: "+id+ 
				"\n\tBalance		: "+format(balance)+joint+"\n";
	}

}
