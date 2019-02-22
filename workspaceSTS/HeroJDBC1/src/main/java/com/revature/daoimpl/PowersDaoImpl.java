package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;

import com.revature.dao.PowersDao;
import com.revature.util.ConnFactory;

public class PowersDaoImpl implements PowersDao{
	public static ConnFactory cf = ConnFactory.getInstance();
	
	@Override
	public void createPower(String powerName) throws SQLException {
		Connection conn = cf.getConnection();
		Savepoint s = conn.setSavepoint("SP1");
		conn.rollback(s);
		conn.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
		String sql = "INSERT INTO POWERS VALUES(POWSEQ.NEXTvAL, ?)";// the '?' acts as a placeholder
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, powerName); //first arg indicates which '?' in the statement we are referring to 
		ps.executeUpdate();			//second arg indicates what i am replacing the '?' with
	}
}
