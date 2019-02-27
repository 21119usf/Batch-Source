package daoImplementation;

import java.util.ArrayList;

import beans.LoginAccount;
import dataAccessObject.LoginAccountsDao;
import util.ConnFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;


public class LoginAccountDaoImpl implements LoginAccountsDao{
	public static ConnFactory cf = ConnFactory.getInstance();
	
	@Override
	public void createLoginAccount(String username, String password) throws SQLException {
		Connection con = cf.getConnection();
		String sql = "INSERT INTO LOGIN_TABLE VALUES(?, ?, 1)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, username);
		ps.setString(2, password);
		ps.executeUpdate();
	}

	@Override
	public ArrayList<LoginAccount> getAllLogins() throws SQLException{
		ArrayList<LoginAccount> logins = new ArrayList<LoginAccount>();
		Connection con = cf.getConnection();
		String sql = "SELECT * FROM LOGIN_TABLE";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		LoginAccount login = null;
		while (rs.next()) {
			login = new LoginAccount(rs.getString(1), rs.getString(2), rs.getInt(3));
			logins.add(login);
		}
		return logins;
	}

	@Override
	public LoginAccount getLogin(String username) throws SQLException{
		LoginAccount login = null;
		Connection con = cf.getConnection();
		String sql = "SELECT * FROM LOGIN_TABLE WHERE USERNAME = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, username);
		ResultSet rs = ps.executeQuery();
		if (rs.next())
			login = new LoginAccount(rs.getString(1), rs.getString(2), rs.getInt(3));
		return login;
	}

	@Override
	public void changeUsername(String username, String newUsername) throws SQLException{
		Connection con = cf.getConnection();
		String sql = "UPDATE LOGIN_TABLE SET USERNAME = ?"
						+ "WHERE USERNAME = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, newUsername);
		ps.setString(2, username);
		ps.executeUpdate();
	}

	@Override
	public void changePassword(String username, String newPassword) throws SQLException{
		Connection con = cf.getConnection();
		String sql = "UPDATE LOGIN_TABLE SET PASS = ?"
						+ "WHERE USERNAME = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, newPassword);
		ps.setString(2, username);
		ps.executeUpdate();
	}

	@Override
	public void removeLoginAccount(String username) throws SQLException{
		Connection con = cf.getConnection();
		String sql = "DELETE FROM LOGIN_TABLE WHERE USERNAME = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, username);
		ps.executeUpdate();
	}

	@Override
	public boolean authenticateLogin(String username, String password) throws SQLException{
		boolean auth = false;
		Connection con = cf.getConnection();
		String sql = "SELECT * FROM LOGIN_TABLE WHERE USERNAME = ? AND PASS = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, username);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();
		auth = rs.next();
		return auth;
	}

	@Override
	public boolean verifyUniqueName(String username) throws SQLException{
		boolean unique = false;
		Connection con = cf.getConnection();
		String sql = "SELECT * FROM LOGIN_TABLE WHERE USERNAME = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, username);
		ResultSet rs = ps.executeQuery();
		unique = !rs.next();			//if i find something, then i know the username is not unique
		return unique;
	}

}
