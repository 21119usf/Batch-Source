package com.revature.classes;

import java.sql.SQLException;
import java.util.Scanner;

public class CreateCustomer {

	
	public static void getCreateCustomer() throws SQLException {
	Scanner scanner = new Scanner(System.in);
	String username = "", password = "", firstname = "", lastname = " ";
	CustomerDaoImpl cdi= new CustomerDaoImpl();
	
	/*===================================
	 * CREATE A CUSTOMER
	 * ================================== */
	System.out.println("==================================");
	System.out.println("=====   CREATE AN CUSTOMER   =====");
	System.out.println("==================================");
	System.out.println("\n");
	System.out.println("Enter a username");
	username=scanner.nextLine();
	
	System.out.println("Enter a password");
	password=scanner.nextLine();
	
	System.out.println("Enter a first name");
	firstname=scanner.nextLine();
	
	System.out.println("Enter a last name");
	lastname=scanner.nextLine();
	
	try 
	{
		cdi.createCustomer(username, password, firstname, lastname, 0);
		System.out.println(firstname + "'s" + " account has been created.");
	} 
	catch (SQLException e) 
	{
		e.printStackTrace();
	}
	/*===================================
	 * CREATE A CUSTOMER----------END
	 * ================================== */
	
	    
	
	
	
	}
}
