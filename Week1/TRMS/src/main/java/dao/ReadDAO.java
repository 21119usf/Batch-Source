package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import beans.Employee;


public interface ReadDAO {
	public abstract ArrayList<Employee> getEmployeeList() throws SQLException;
}
