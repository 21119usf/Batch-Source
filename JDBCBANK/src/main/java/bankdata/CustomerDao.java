package bankdata;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;

import bankdata.ConnFactory;

public class CustomerDao {

		ConnFactory cf = ConnFactory.getInstance();
	
		public void createCustomers (String custID, String custNM, String custPS, String custNamer, String custSoc ) throws SQLException 
		{
			// TODO Auto-generated method stub
			Connection conn = cf.getConnection();
		
			//conn.setAutoCommit(false);
			conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
			String sql = "{ call INSERTCUSTOMER (?,?, ?, ? ,?)";
			CallableStatement q = conn.prepareCall(sql);
			//PreparedStatement ps = conn.prepareStatement(sql);
			
			q.setString(1, custID);
			q.setString(2, custNM);
			q.setString(3, custPS);
			q.setString(4, custNamer);
			q.setString(5, custSoc);
			q.execute();
			
			//ps.setString(1, custID);
			//ps.setString(2, custNM);
			//ps.setString(3, custPS);
			//ps.setString(4, custNamer);
			//ps.setString(5, custSoc);
			
			//ps.executeUpdate();
			
		}
		
	

}
