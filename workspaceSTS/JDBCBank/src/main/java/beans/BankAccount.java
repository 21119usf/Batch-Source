package beans;

public class BankAccount {

	protected int bankAccountID;
	protected int userID;
	protected double balance;
	protected String accountType;
	
	//Constructors
	public BankAccount() {
		this.bankAccountID = -1;
		this.userID = -1;
		this.balance = 0.0;
		this.accountType = "N/A";
	}

	public BankAccount(int bankAccountID, int userID, double balance, String accountType) {
		this.bankAccountID = bankAccountID;
		this.userID = userID;
		this.balance = balance;
		this.accountType = accountType;
	}

	
	//Mutator and Accessors
	public int getBankAccountID() {
		return bankAccountID;
	}

	public void setBankAccountID(int bankAccountID) {
		this.bankAccountID = bankAccountID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	
}
