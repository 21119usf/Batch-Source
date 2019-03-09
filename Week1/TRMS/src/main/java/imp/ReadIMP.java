package imp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import util.ConnFactory;

import beans.Employee;
import dao.ReadDAO;

public class ReadIMP implements ReadDAO{
	public static ConnFactory cf = ConnFactory.getInstance();

	public ArrayList<Employee> getEmployeeList() throws SQLException {
		ArrayList<Employee> employeeList = new ArrayList<Employee>();
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM RE_EMPLOYEE");
		while (rs.next()) {
			Employee e = new Employee();
			e.setId(rs.getInt(1));
			e.setFirstname(rs.getString(2));
			e.setLastname(rs.getString(3));
			e.setUsername(rs.getString(4));
			e.setPassword(rs.getString(5));
			e.setEmail(rs.getString(6));
			e.setLeftover(rs.getDouble(7));
			e.setSupervisor(rs.getInt(8));
			e.setClearence(rs.getInt(9));
			employeeList.add(e);
		}
		return employeeList;
	}
	
}
