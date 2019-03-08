package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.util.ConnFactory;

public class UserDaoImpl {

	public static ConnFactory cf = ConnFactory.getInstance();
	
	public void findForm(int caseNumber)throws SQLException {
		Connection conn = cf.getConnection();
        Statement statement = conn.createStatement();

        ResultSet results = statement.executeQuery("SELECT * FROM REIMBURSEMENT "
        		+ "WHERE FORMID = '" + caseNumber + "'");

        if(results.next()) {

            System.out.println("column index for row: " + results.getRow() + ", Form ID" + results.getInt(1) + ", Full Name"
            		+ results.getString(2) + ", Event Date" + results.getString(3) + ", Start Time" + results.getString(4) +
            		",End Time" + results.getString(5) + ", Event Location" + results.getString(6) + ", Description" +
            		results.getString(7) + ", Cost" + results.getDouble(8) + ", Grading" + results.getString(9));
        }
	}
}
