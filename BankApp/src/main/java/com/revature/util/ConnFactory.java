package com.revature.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.revature.bankinterface.CustomerDAOImpl;

public class ConnFactory {

    private static ConnFactory cf = new ConnFactory();
    private ConnFactory() {
        super();
    }
    public static synchronized ConnFactory getInstance() {
        if (cf == null) {
            cf = new ConnFactory();
        }
        return cf;
    }
    
    public Connection getConnection() {
        Connection conn = null;
        
        Properties Props = new Properties();
        
        try {
			Props.load(new FileReader("database.properties"));
			Class.forName(Props.getProperty("driver"));
			conn = DriverManager.getConnection(Props.getProperty("url"),
					Props.getProperty("usr"),
					Props.getProperty("password"));
        }catch (FileNotFoundException e) {
        	e.printStackTrace();
        }catch (IOException e) {
        	e.printStackTrace();
        }catch (ClassNotFoundException e) {
        	e.printStackTrace();
        }catch (SQLException e) {
        	e.printStackTrace();
        }return conn;
        }
    
    public static CustomerDAOImpl CustomerDAO() {
		return new CustomerDAOImpl();
	}
	
		
	
}