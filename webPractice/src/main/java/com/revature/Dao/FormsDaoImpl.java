package com.revature.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Employee;
import com.revature.beans.ReimbursementForm;
import com.revature.beans.Student;

public class FormsDaoImpl {
	public ReimbursementForm getStudentForm(int sID) throws ClassNotFoundException{
		ReimbursementForm form = null;
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@bankapp1.clkgfudo2lkd.us-east-1.rds.amazonaws.com:1521:ORCL","forsaken","halo0221");
				Statement stmt = conn.createStatement();
				String sql ="SELECT STUDENTFIRSTNAME, STUDENTLASTNAME, STUDENTSTREET,STUDENTCITY, STUDENTSTATE, STUDENTZIPCODE, STUDENTPHONENUMBER, "
						+ "STUDENTEMAIL, STUDENTSTUDENTID "
						+"FROM REIMBURSEMENTFORMS WHERE STUDENTSTUDENTID= ";
				ResultSet rs  = stmt.executeQuery(sql+sID);
				rs.next();
				form = new ReimbursementForm(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),
						rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),
						Integer.toString(rs.getInt(9)));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return form;
	}
	
	public List<Object>getReimbursementInfo(int sID) throws ClassNotFoundException{
		List<Object> info = new ArrayList<Object>();
		ReimbursementForm form = null;
		Employee employee = null;
		Student student = null;
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@bankapp1.clkgfudo2lkd.us-east-1.rds.amazonaws.com:1521:ORCL","forsaken","halo0221");
				Statement stmt = conn.createStatement();
				String sql ="SELECT STUDENTFIRSTNAME, STUDENTLASTNAME, STUDENTSTUDENTID,DATEE," + 
						"EMPLOYEEFIRSTNAME,EMPLYOYEELASTNAME,TIMEE,COST,GRADINGFORMAT,EVENTTYPE,WORK_RELATED_JUSTIFICATION,"
						+"STUDENTLETTERGRADES,STUDENTGRADES FROM REIMBURSEMENTFORMS WHERE STUDENTSTUDENTID= ";
				ResultSet rs  = stmt.executeQuery(sql+sID);
				rs.next();
				form = new ReimbursementForm(rs.getString(4),rs.getString(7),rs.getDouble(8),rs.getString(9),
						rs.getString(10),rs.getString(11),rs.getString(12),rs.getDouble(13));
				employee = new Employee(rs.getString(5),rs.getString(6));
				student = new Student(rs.getString(1),rs.getString(2), rs.getInt(3));
				info.add(form);
				info.add(employee);
				info.add(student);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return info;
	}
	
	
	public void submitStudentForm(ReimbursementForm form) throws ClassNotFoundException {
		
		
		String sql = "{ call NEWSTUDENTFORM(?,?,?,?,?,?,?,?,?)";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			 Connection connector = DriverManager.getConnection("jdbc:oracle:thin:@bankapp1.clkgfudo2lkd.us-east-1.rds.amazonaws.com:1521:ORCL", 
					"forsaken", "halo0221");
			PreparedStatement ps = connector.prepareStatement(sql);
			ps.setString(1, form.getFname());
			ps.setString(2,form.getLname());
			ps.setString(3,form.getStreet());
			ps.setString(4,form.getCity());
			ps.setString(5,form.getState());
			ps.setString(6,form.getZipCode());
			ps.setString(7,form.getPhoneNumber());
			ps.setString(8,form.getEmail());
			ps.setInt(9,form.getsID());
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void submitEmployeeForm(ReimbursementForm form, int sID) throws ClassNotFoundException {
		String date = form.getMonth()+"/"+form.getDay()+"/"+form.getYear();
		
		String sql = "{ call NEWSEMPLOYEEFORM(?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			 Connection connector = DriverManager.getConnection("jdbc:oracle:thin:@bankapp1.clkgfudo2lkd.us-east-1.rds.amazonaws.com:1521:ORCL", 
					"forsaken", "halo0221");
			PreparedStatement ps = connector.prepareStatement(sql);
			ps.setString(1, form.getFname());
			ps.setString(2,form.getLname());
			ps.setInt(3,form.getsID());
			ps.setDouble(4, form.getCost());
			ps.setDouble(5, form.getGrade());
			ps.setString(6, form.getEventType());
			ps.setString(7, form.getJustification());
			ps.setString(8, date);
			ps.setString(9,form.getStreet());
			ps.setString(10,form.getCity());
			ps.setString(11,form.getState());
			ps.setInt(12, sID);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
