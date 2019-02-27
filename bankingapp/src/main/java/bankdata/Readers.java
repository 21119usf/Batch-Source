package bankdata;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import bankfunctions.Customer;
import bankdata.ConnFactory;


public class Readers {
	

public static void fileReader() throws FileNotFoundException {
	File customer = new File("customer.txt");	
	Scanner read = new Scanner (customer);
	read.useDelimiter(":");
	String userName;
	while (read.hasNext())
	{
	   userName = read.next();
	   //**reads data from array
	  // readFiler.add(userName);
	  // password = read.nextLine();
	  // name = read.nextLine();
	  //social = read.nextLine();
	   
	  //cus System.out.println(userName  + "\n"); // just for debugging
	}
	read.close();
	
		//System.out.println(readFiler.toString());
	}




	
public static ConnFactory cf = ConnFactory.getInstance();

	public static List<Customer> getCustomerInfo() throws SQLException{
		Connection conn =  cf.getConnection();
		
		
		List<Customer> superList = new ArrayList<Customer>();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM BANKCUSTOMERS");
		Customer s = null;
		while(rs.next())
		{
			s = new Customer(rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5) );
			superList.add(s);
			
		}
		return superList;
	}
	
	
	public static List<BankAccInfo> getBankInfo() throws SQLException{
		Connection conn =  cf.getConnection();
		
		
		List<BankAccInfo> bankList = new ArrayList<BankAccInfo>();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM BANKACCOUNTS");
		BankAccInfo s = null;
		while(rs.next())
		{
			s = new BankAccInfo(rs.getString(1), rs.getString(2), rs.getString(3) );
			bankList.add(s);
			
		}
		return bankList;
	}
	
}
