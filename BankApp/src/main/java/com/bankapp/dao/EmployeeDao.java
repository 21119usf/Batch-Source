package com.bankapp.dao;

import java.sql.SQLException;

import com.bankapp.user.Employee;

public interface EmployeeDao {
	public abstract void addEmployee(Employee e) throws SQLException;
	public abstract Employee getEmployee(String un) throws SQLException;
	public abstract void updateEmployee(Employee e) throws SQLException;
	public abstract void deleteEmployee(Employee e) throws SQLException;
}
