package bankingDaoImp;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import banking.Account;
import banking.User;
import banking.util.ConnFactory;
import bankingDAO.AdminDAO;

public class AdminDaoImp implements AdminDAO {

	public static ConnFactory cf = ConnFactory.getInstance();
	@Override
	public boolean login(String username, String password) throws SQLException {
		Connection conn = cf.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rsA = stmt.executeQuery("SELECT * FROM ADMINS");
		while(rsA.next()) {
			if (rsA.getString(2).equals(username)) {
				if (rsA.getString(3).equals(password)) {
					return true;
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
	public void register(String username, String password) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{call NEWADMIN(?,?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setString(1, username);
		call.setString(2, password);
		call.execute();
	}
	
	@Override
	public void delete(String username, String password) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{call DELADMIN(?,?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setString(1, username);
		call.setString(2, password);
		call.execute();
	}
	
	@Override
	public void approve(String username) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{call APPROVEUSR(?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setString(1, username);
		call.execute();
		
	}
	
	@Override
	public List<Account> getAccounts() throws SQLException {
		List<Account> AccountList = new ArrayList<Account>();
		Connection conn = cf.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM ACCOUNTS");
		Account s = null;
		while(rs.next()) {
			s = new Account(rs.getInt(2),rs.getDouble(3), rs.getString(4));
			AccountList.add(s);
		}
		return AccountList;
	}

	@Override
	public List<User> getUsers() throws SQLException {
		List<User> UserList = new ArrayList<User>();
		Connection conn = cf.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM USERS");
		User s = null;
		while(rs.next()) {
			s = new User(rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getBoolean(6));
			UserList.add(s);
		}
		return UserList;
	}

	@Override
	public void update(String username, String newPW, String newname, int SSN, boolean approved) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{call EDITUSR(?,?,?,?,?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setString(1, username);
		call.setString(2, newPW);
		call.setString(3, newname);
		call.setInt(4, SSN);
		if (approved) {
			call.setInt(5, 1);
		} else {
			call.setInt(5, 0);
		}
		call.execute();
		
	}



}
