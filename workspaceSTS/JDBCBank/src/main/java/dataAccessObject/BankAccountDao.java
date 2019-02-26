package dataAccessObject;

import java.util.ArrayList;

import beans.BankAccount;
import java.sql.SQLException;

public interface BankAccountDao {
	
	//Create
	public void createBankAccount(int userID, double balance, String accountType) throws SQLException;
	
	//Read
	public ArrayList<BankAccount> getAllBankAccounts() throws SQLException;
	public ArrayList<BankAccount> getBankAccountsOfUser(int userID) throws SQLException;
	
	//Update
	public void changeBalance(int bankAccountID, double newBalance) throws SQLException;
	public void changeAccountType(int bankAccountID, String accountType) throws SQLException;
	
	//Delete
	public void removeBankAccount(int bankAccountID) throws SQLException;
	public void removeAllBankAccounts(int userID) throws SQLException;

}
