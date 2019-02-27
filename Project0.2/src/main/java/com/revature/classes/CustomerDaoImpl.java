package com.revature.classes;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class CustomerDaoImpl {

    public static ConnectorToDatabase cf = ConnectorToDatabase.getInstance();

    public void createCustomer(String username, String userpassword,
            String firstName, String lastName, int permissions) throws SQLException{
        Connection conn = cf.getConnection();
        //Savepoint s = conn.setSavepoint("SP1");
       // conn.rollback(s);
        //conn.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
       // conn.setAutoCommit(false);
		//String sql= "INSERT INTO POWERS VALUES(CUSTOMERSEQ.NEXTVAL,?,?,?,?)";
        String sql = "{ call INSERTUSER(?,?,?,?,?)";
		CallableStatement call = conn.prepareCall(sql);
        //PreparedStatement ps = conn.prepareStatement(sql);
        call.setString(1, username);
        call.setString(2, userpassword);
        call.setString(3, firstName);
        call.setString(4, lastName);
        call.setInt(5, permissions);
        call.executeUpdate();
    }
    
    
//    //login stuff
//    public void thisWillCallSomething(String username, String userpassword,
//            String firstName, String lastName, int permissions) throws SQLException{
//        Connection conn = cf.getConnection();
//        // conn.setAutoCommit(false);
//		//String sql= "INSERT INTO BANKCUSTOMER VALUES(CUSTOMERSEQ.NEXTVAL,?,?,?,?)";
//        String sql = "{ call INSERTUSER(?,?,?,?,?)";
//		CallableStatement call = conn.prepareCall(sql);
//        //PreparedStatement ps = conn.prepareStatement(sql);
//        call.setString(1, username);
//        call.setString(2, userpassword);
//        call.setString(3, firstName);
//        call.setString(4, lastName);
//        call.setInt(5, permissions);
//        call.executeUpdate();
//    }
    
    
    
//    public void getCustomerList(int cust_id, String username, String password, String firstname, String lastname, int permission) throws SQLException {
//		Connection conn= cf.getConnection();
//		Statement stmt=conn.createStatement();
//		ResultSet rs= stmt.executeQuery("SELECT * FROM BANKCUSTOMER");
//		//CustomerBean s=null;
//		while(rs.next()) {
//			//s= new CustomerBean
//			int cust_id = rs.getInt(1);
//			String username1 = rs.getString(2); 
//			String password1 = rs.getString(3);
//			String firstname1 = rs.getString(4);
//			String lastname1 = rs.getString(5);
//			int permission1 = rs.getInt(6);
//		}
//		
//	}
    
//    public void getCustomerAuthentication () throws SQLException
//    {
//    	Connection conn= cf.getConnection();
//		Statement stmt=conn.createStatement();
//		ResultSet rs= stmt.executeQuery("SELECT CUSTID, USERNAME, USERPASSWORD FROM BANKCUSTOMER");
//		while(rs.next()) 
//		{
//			int custid = rs.getInt(1); 
//			String username = rs.getString(2); 
//			String password = rs.getString(3);
//		}
//		
//	}
    
    
    public List<CustomerBean> getCustomerList() throws SQLException
    {
		List<CustomerBean> customerList= new ArrayList<CustomerBean>();
		Connection conn= cf.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs= stmt.executeQuery("SELECT * FROM BANKCUSTOMER");
		CustomerBean s=null;
		while(rs.next()) {
			s= new CustomerBean(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6));
			customerList.add(s);
		}
		return customerList;
	}
    
}