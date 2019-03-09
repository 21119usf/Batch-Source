package com.revature.daoimplementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.dao.PowersDao;
import com.revature.util.ConnFactory;

public class PowersDaoImplementation implements PowersDao{
	public static ConnFactory cf = ConnFactory.getInstance();
	
	@Override
	public void createPower(String powerName) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = cf.getConnection();
		String sql = "INSERT INTO POWERS VALUES(POWSEQ.NEXTVAL,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, powerName);
		ps.executeUpdate();
	}
}
