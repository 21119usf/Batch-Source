package bank.beans;

public class Account 
{
	private int accountID;
	private double balance;
	private String type;
	private int customerID;
	public Account(int accountID, double balance, String type, int customerID) {
		super();
		this.accountID = accountID;
		this.balance = balance;
		this.type = type;
		this.customerID = customerID;
	}
	public int getAccountID() {
		return accountID;
	}
	public double getBalance() {
		return balance;
	}
	public String getType() {
		return type;
	}
	public int getCustomerID() {
		return customerID;
	}
	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	@Override
	public String toString() {
		return "Account [accountID=" + accountID + ", balance=" + balance + ", type=" + type + ", customerID="
				+ customerID + "]";
	}
	
	
}
