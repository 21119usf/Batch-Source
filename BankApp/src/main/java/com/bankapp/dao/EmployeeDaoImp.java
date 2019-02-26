package com.bankapp.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bankapp.controllers.ConnectionController;
import com.bankapp.user.Admin;
import com.bankapp.user.Employee;

public class EmployeeDaoImp implements EmployeeDao {
	private static ConnectionController cc = ConnectionController.getInstance();
	private Connection connection = cc.getConnection();

	// Add employee to database
	public void addEmployee(Employee e) throws SQLException {
		// Check if employee is an admin
		int isAdmin = e instanceof Admin ? 1 : 0;
		
		Statement statement = connection.createStatement();
		String sql = "INSERT INTO EMPLOYEE VALUES(" +
			e.getId() + ", '" + e.getUsername() + "', '" +
			e.getPassword() + "', " + isAdmin + ")";
		statement.executeUpdate(sql);
	}

	// Retrieve employee by id
	public Employee getEmployee(String un) throws SQLException {
		Statement statement = connection.createStatement();
		String sql = "SELECT * FROM EMPLOYEE " +
			"WHERE E_USERNAME = '" + un + "'";
		
		long id = 0; String password = ""; int isAdmin = 0;
		
		ResultSet rs = statement.executeQuery(sql);
		if (!rs.isBeforeFirst()) {
			return null;	// No data
		}
		while (rs.next()) {
			id = rs.getLong("E_ID");
			password = rs.getString("E_PASSWORD");
			isAdmin = rs.getInt("E_ISADMIN");
		}
		
		boolean admin = isAdmin == 0 ? false : true;
		if (admin) {
			Admin a = new Admin(un, password);
			a.setId((int)id);
			return a;
		}
		Employee e = new Employee(un, password);
		e.setId((int)id);
		return e;
	}

	// Update employee in database
	public void updateEmployee(Employee e) throws SQLException {
		// Check if employee is admin
		int isAdmin = e instanceof Admin ? 1 : 0;
		
		Statement statement = connection.createStatement();
		String sql = "UPDATE CUSTOMER SET " +
			"E_PASSWORD = '" + e.getPassword() + "', " +
			"E_ISADMIN = " + isAdmin + " WHERE E_ID = " + e.getId();
		statement.executeUpdate(sql);
	}

	// Delete employee in database
	public void deleteEmployee(Employee e) throws SQLException {
		Statement statement = connection.createStatement();
		String sql = "DELETE FROM EMPLOYEE WHERE E_ID = " + e.getId();
		statement.execute(sql);
	}
}
