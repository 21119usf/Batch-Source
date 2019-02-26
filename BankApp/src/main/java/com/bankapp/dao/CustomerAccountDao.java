package com.bankapp.dao;

import java.sql.SQLException;

public interface CustomerAccountDao {
	public abstract void addCustomerAccount(int cId, int aId) throws SQLException;
	public abstract void deleteCustomerAccount(int cId, int aId) throws SQLException;
}
