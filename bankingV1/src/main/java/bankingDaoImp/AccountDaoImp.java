package bankingDaoImp;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import banking.util.ConnFactory;
import bankingDAO.AccountDAO;

public class AccountDaoImp implements AccountDAO {
	
	public static ConnFactory cd = ConnFactory.getInstance();
	
	@Override
	public void withdraw(int accountNum, double amount) throws SQLException {
		Connection conn = cd.getConnection();
		String sql = "{call WITHDRAW(?,?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, accountNum);
		call.setDouble(2, amount);
		call.execute();
		
	}

	@Override
	public void deposit(int accountNum, double amount) throws SQLException {
		Connection conn = cd.getConnection();
		String sql = "{call DEPOSIT(?,?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, accountNum);
		call.setDouble(2, amount);
		call.execute();
	}

	@Override
	public void transfer(int fromID, int toID, double amount) throws SQLException {
		Connection conn = cd.getConnection();
		String sql = "{call WITHDRAW(?,?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, fromID);
		call.setDouble(2, amount);
		call.execute();
		sql = "{call DEPOSIT(?,?)";
		call = conn.prepareCall(sql);
		call.setInt(1, toID);
		call.setDouble(2, amount);
		call.execute();
	}

}
