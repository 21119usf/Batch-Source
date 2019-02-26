package dataAccessObject;

import java.util.ArrayList;

import beans.BankAccount;

public interface BankAccountDao {
	
	//Create
	public void createBankAccount(int userID, double balance, String accountType);
	
	//Read
	public ArrayList<BankAccount> getAllBankAccounts();
	public BankAccount getBankAccount(int userID);
	
	//Update
	public void changeBalance(int userID, double newBalance);
	public void changeAccountType(int userID);
	
	//Delete
	public void removeBankAccount(int bankAccountID);
	public void removeAllBankAccounts(int userID);

}
