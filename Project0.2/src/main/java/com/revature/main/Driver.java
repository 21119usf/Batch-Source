package com.revature.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.revature.classes.AdministratorStuff;
import com.revature.classes.CreateCustomer;
import com.revature.classes.Login;
//import com.revature.classes.CustomerDaoImpl;


public class Driver {


	public static void main(String[] args) throws SQLException {
		Scanner scanner = new Scanner(System.in);
		
		
		
		int selection = 0;
		do {  
			
			
			System.out.println("==================================");
			System.out.println("=======     MERICA BANK    =======");
			System.out.println("==================================\n");
			System.out.println("1. Login");
			System.out.println("2. Register\n");
  		  	selection = scanner.nextInt();
				switch(selection) 
				{
				case 1:
					//registered user can login
					Login.login();
					break;
				case 2:
					//An unregistered user can register by creating a username and password 
					CreateCustomer.getCreateCustomer();
					break;
				case 3:
					//end application.
				default:
					System.out.println("Please pick option 1, 2 , or 3.");
					break;
				}}while(selection != 3);
		
		
		
		
		
		//CreateCustomer.getCreateCustomer();
		//AdministratorStuff.getCustomerInfo();
		

		
		
		
			
		

	}}

