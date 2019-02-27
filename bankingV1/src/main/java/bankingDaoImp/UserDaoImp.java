package bankingDaoImp;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import banking.Account;
import banking.util.ConnFactory;
import bankingDAO.UserDAO;

public class UserDaoImp implements UserDAO{

	public static ConnFactory cf = ConnFactory.getInstance();
	@Override
	public boolean login(String username, String password) throws SQLException {
		Connection conn = cf.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rsA = stmt.executeQuery("SELECT * FROM USERS");
		while(rsA.next()) {
			if (rsA.getString(2).equals(username)) {
				if (rsA.getString(3).equals(password)) {
					if (rsA.getBoolean(5)) {
						return true;
					} else {
						System.out.println("That account is not approved yet.");
						return false;
					}
				} else {
					System.out.println("password not correct");
					return false;
				}
			}
		}
		System.out.println("username not found");
		return false;
	}

	@Override
	public void register(String username, String password, String realname, int SSN) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{call NEWUSER(?, ?, ?, ?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setString(1, username);
		call.setString(2, password);
		call.setString(3, realname);
		call.setInt(4, SSN);
		call.execute();
	}

	@Override
	public List<Account> getAccounts(String username) throws SQLException {
		List<Account> AccountList = new ArrayList<Account>();
		Connection conn = cf.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM ACCOUNTS");
		Account s = null;
		while(rs.next()) {
			if (rs.getString(4).equals(username)) {
				s = new Account(rs.getInt(2),rs.getDouble(3), rs.getString(4));
				AccountList.add(s);
				}
		}
		return AccountList;
	}

	@Override
	public void openacc(String username) throws SQLException {
		Integer ID = ThreadLocalRandom.current().nextInt(10000000, 100000000);
		Connection conn = cf.getConnection();
		String sql = "{call NEWACCOUNT(?, ?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, ID);
		call.setString(2, username);
		call.execute();
		
	}

	@Override
	public void closeacc(String username) throws SQLException {
		Connection conn = cf.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM ACCOUNTS");
		while(rs.next()) {
			if (rs.getString(4).equals(username)) {
				if(rs.getDouble(3) <= 0.01) {
					String sql = "{call DELACCOUNT(?)";
					CallableStatement call = conn.prepareCall(sql);
					call.setInt(1, rs.getInt(1));
					call.execute();
					//log that shit
					System.out.println(rs.getInt(2) + " deleted by " + username);
				} else {
					System.out.println("Account not empty, can't delete it yet.");
				}
			}
		}
	}	
}
