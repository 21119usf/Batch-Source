package com.reavature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.reavature.validate.ValidatorException;
import com.reavture.beans.User;
import com.reavture.beans.UserRole;
import com.revature.utilities.DAOUtilities;
/*
 * Class thats handles all user logic of CURD on the database
 */
public class UserDAOImpl implements UserDAO {

	Connection conn;
	PreparedStatement stmt;

	@Override
	public boolean createUser(User u) throws SQLException {
		// get DB connection
		conn = DAOUtilities.getConnection();
		// SQL string to run in DB
		String sql = "INSERT INTO U5ER VALUES(U5ER_ID_SEQUENCE.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)";
		stmt = conn.prepareStatement(sql);
		// setting of placeholder (?)
		stmt.setString(1, u.getFirstName());
		stmt.setString(2, u.getLastName());
		stmt.setString(3, u.getSSN());
		stmt.setString(4, u.getRole().toString());
		stmt.setString(5, u.getUsername());
		stmt.setString(6, u.getHash());
		stmt.setString(7, u.getEmail());
		// run SQL update
		stmt.executeUpdate();
		return true;
	}

	public User getUser(String username) throws SQLException, UsernameException {
		// instance user to return
		User u = new User();
		// get connection
		conn = DAOUtilities.getConnection();
		// gets all data for a user
		String sql = "SELECT * FROM U5ER WHERE USERNAME=?";
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, username);
		ResultSet rs = stmt.executeQuery();
		if (rs.next()) {
			u.setId(rs.getInt("USER_ID"));
			u.setUsername(rs.getString("USERNAME"));
			u.setFirstName(rs.getString("FIRST_NAME"));
			u.setLastName(rs.getString("LAST_NAME"));
			u.setHash(rs.getString("HA5H"));
			u.setSSN(rs.getString("SSN"));
			u.setEmail(rs.getString("EMAIL"));
			u.setRole(UserRole.valueOf(rs.getString("ROL3")));
		} else {
			throw new UsernameException("Invlid Login");
		}
		return u;
	}

	@Override
	public User getUser(int userId) throws SQLException {
		User u = new User();
		// get connection
		conn = DAOUtilities.getConnection();
		// gets all data for a user
		String sql = "SELECT * FROM U5ER WHERE USER_ID=?";
		stmt = conn.prepareStatement(sql);
		stmt.setInt(1, userId);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			u.setId(rs.getInt("USER_ID"));
			u.setUsername(rs.getString("USERNAME"));
			u.setFirstName(rs.getString("FIRST_NAME"));
			u.setLastName(rs.getString("LAST_NAME"));
			u.setHash(rs.getString("HA5H"));
			u.setSSN(rs.getString("SSN"));
			u.setEmail(rs.getString("EMAIL"));
			u.setRole(UserRole.valueOf(rs.getString("ROL3")));
		}
		return u;
	}
	
	public void deleteUser() throws SQLException {}

}
