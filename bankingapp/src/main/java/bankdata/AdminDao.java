package bankdata;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class AdminDao {

	static ConnFactory cf = ConnFactory.getInstance();
	public static void deleteUser (String custid) throws SQLException 
	{
		// TODO Auto-generated method stub
		Connection conn = cf.getConnection();
		
		conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
		String sql = "{ call USERDELETE (?)";
		CallableStatement q = conn.prepareCall(sql);
		
		q.setString(1, custid);
		
		q.execute();
	}
	
	
	
	
	
	
	
	
	
	
}
