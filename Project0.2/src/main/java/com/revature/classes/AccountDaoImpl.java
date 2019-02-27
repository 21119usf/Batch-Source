package com.revature.classes;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class AccountDaoImpl {
	
	public static ConnectorToDatabase cf = ConnectorToDatabase.getInstance();

    public void createAccount(int accountNumber, int balance) throws SQLException{
        Connection conn = cf.getConnection();
        String sql = "{ call INSERTACCOUNT(?,?)";
		CallableStatement call = conn.prepareCall(sql);
        //PreparedStatement ps = conn.prepareStatement(sql);
        call.setInt(1, accountNumber);
        call.setLong(2, balance);
        call.executeUpdate();
        
        
    }
}
