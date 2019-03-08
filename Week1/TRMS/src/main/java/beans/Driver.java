package beans;

import java.sql.SQLException;
import java.util.ArrayList;

import imp.ReadIMP;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReadIMP ri = new ReadIMP();
		ArrayList<Employee> emp = new ArrayList<Employee>();
		try {
			emp = ri.getEmployeeList();
			System.out.println(emp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
