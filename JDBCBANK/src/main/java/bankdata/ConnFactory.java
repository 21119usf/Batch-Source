package bankdata;


import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnFactory {
 private static ConnFactory cf = new ConnFactory();
 private ConnFactory() {
	 super();
 }
 
 public static synchronized ConnFactory getInstance() {
	  if( cf == null) {
		  cf = new ConnFactory();
		  
	  }
	  return cf;
 }
 
 	public Connection getConnection() {
 		Connection conn = null;
 		Properties prop = new Properties();
 		try {
			prop.load(new FileReader("database.properties"));
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
 		try {
			Class.forName(prop.getProperty("driver"));
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
 		try {
			conn = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("usr"), prop.getProperty("password"));
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
 	}
 	
 	
 	
 	
 	
 
}

