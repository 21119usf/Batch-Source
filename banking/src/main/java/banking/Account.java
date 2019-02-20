package banking;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class Account implements Serializable {
	
	// Fields
	private static final long serialVersionUID = 262112665433916580L;
	private Integer ID;
	private boolean active;
	private double balance;
	private String customers;
	
	// Getters, and setters
	public Integer getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public Boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getCustomers() {
		return customers;
	}
	public void setCustomers(String customers) {
		this.customers = customers;
	}

	// Account Methods: Constructor, Withdraw, Deposit, Transfer, Close
	// Line format: ID:balance:active:customers
	public Account(String line) {
		String[] args = line.split(":");
		this.ID = Integer.parseInt(args[0]);
		this.balance = Double.parseDouble(args[1]);
		this.active = Boolean.parseBoolean(args[2]);
		this.customers = args[3];
		}
	
	// make sure the toString() is in the format I like
	@Override
	public String toString() {
		String fu = String.format("%d:%.2f:%b:%s", this.ID,this.balance,this.active,this.customers);
		return fu;
	}
	
	public void display() {
		System.out.println("Account ID: " + this.getID().toString());
		System.out.println(String.format("Account Balance: %.2f", this.getBalance()));
		if (this.isActive()) {
			System.out.println("Activated");
		} else {
			System.out.println("Unactivated");
		}
		String customLine ="Customers: ";
		for(String name: this.getCustomers().split(";")) {
			customLine = customLine + name + "\n";
		}
		System.out.println(customLine);
	}
	// I'm going to try to save myself some work and automate the process of getting the accounts
	public static ArrayList<Account> populateAccounts() {
		ArrayList<Account> accounts = new ArrayList<Account>();
		try {
			FileReader fr = new FileReader("Accounts.txt");
			BufferedReader br = new BufferedReader(fr);
			while (br.ready()) {
				String fu = br.readLine();
				if (fu.contains(":")) {
					Account active = new Account(fu);
					accounts.add(active);
				}
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return accounts;
	}
	
	// and saving the accounts
	public static void saveAccounts(ArrayList<Account> accounts) {
		FileOutputStream os = null;
		File file = new File("Accounts.txt");
		try {
			os = new FileOutputStream(file, false);
			for(Account a : accounts) {
				String contents = a.toString();
				os.write(contents.getBytes());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// now onto the UI methods (these are only accessible by specific instances
	public void withdraw(User username, double withdrawal) throws NegativeInputException, OverdrawException {
		if (withdrawal < 0) {
			throw new NegativeInputException();
		} else if (withdrawal > balance) {
			throw new OverdrawException();
		} else {
			this.balance += -1*withdrawal;
			// Handle persistence at application opening and closing
		}
	}
	// deposit(Customer, amount)
	public void deposit(User username, double deposit) throws NegativeInputException {
		if (deposit < 0) {
			throw new NegativeInputException();
		} else {
			this.balance += deposit;
			// Handle persistence at application opening and closing
		}
	}
	
	// transfer(User, TargetAccountID, amount)
	public void transfer(User username, Account target, double amount )	throws NegativeInputException, OverdrawException{
		if (amount < 0 ) {
			throw new NegativeInputException();
		} else if (amount > balance) {
			throw new OverdrawException();
		} 
		try {
			this.withdraw(username, amount);
			target.deposit(username, amount);
		} catch (AccountNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
}
