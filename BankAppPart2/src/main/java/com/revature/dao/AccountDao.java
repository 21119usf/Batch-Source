package com.revature.dao;

import java.sql.SQLException;
import java.util.List;
import com.revature.accounttype.*;

public interface AccountDao {
	
	//CRUD
	//this method we need to place an insert method, here we need a name, id would be sequence
	public abstract void createAccount(int userID, float accountBal)throws SQLException;
	//
	public abstract List<IndividualAccount> getAccountList() throws SQLException;

}
