package util;

import java.io.FileNotFoundException;
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
		if(cf == null) {
			cf = new ConnFactory();
		}
		return cf;
	}
	public Connection getConnection() {
		Connection conn = null;
		Properties prop = PropsUtility.getProps();
		try {
			// prop.load(new FileReader("Database.properties"));
			Class.forName(prop.getProperty("driver"));
			conn = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("usr"), prop.getProperty("password"));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
}
