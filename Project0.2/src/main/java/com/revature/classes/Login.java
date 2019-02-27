package com.revature.classes;

import java.sql.SQLException;
import java.util.Scanner;

public class Login 
{

	
	public static void login() throws SQLException 
	{
		CustomerDaoImpl cdi= new CustomerDaoImpl();
		
		Scanner scanner = new Scanner(System.in);
		String username = "", password = "";
		
		
		System.out.println("=====================");
		System.out.println("====    LOGIN    ====");
		System.out.println("=====================\n");
		
		System.out.println("Enter username...");
		username=scanner.nextLine();
		
		System.out.println("Enter password...");
		password=scanner.nextLine();
		
		
		  for(int i = 0; i < cdi.getCustomerList().size(); i++)
          {
              if(cdi.getCustomerList().get(i).getCustomerUsername().compareTo(username) == 0 && cdi.getCustomerList().get(i).getCustomerPassword().compareTo(password) == 0)
              {
            	  System.out.println("You are logged in.");
            	  

        		  if(cdi.getCustomerList().get(i).getCustomerPermissions() == 0) 
        		  {
        			  	
        				CustomerInteraction.showMenu();
        		  }
            	  
            	  if(cdi.getCustomerList().get(i).getCustomerPermissions() == 2)
            	  {
            		  System.out.println("You are an Admin.");
            		  System.out.println("==========================");
            		  System.out.println("====   ADMIN POWERS  =====");
            		  System.out.println("==========================\n");
            		  System.out.println("1. Access Customer Info");
            		  System.out.println("2. Delete Account");
            		  System.out.println("3. Create Account");
            		  System.out.println("4. Delete Customer");
            		  System.out.println("5. Create Customer");
            		  System.out.println("6. Exit");
            		  int selection = 0;
            		do {   
          		  	selection = scanner.nextInt();
      				switch(selection) 
      				{
      				case 1:
      					AdministratorStuff.getCustomerInfo();
      					break;
      				case 3:
      					CreateCustomer.getCreateCustomer();
      					break;
      				case 6:
      					System.out.println("Goodbye SeventhJoker");
      					break;
      				default:
      					System.out.println("other options are unavailable at this time.");
      					break;
      				}}while(selection != 6);
      				
      				
      				
      				
      				
      				
      				
      				
            	  }
            	  
            	  

            	  
            	  
            	  break;
              }

              else
              {
                  System.out.println("User and Pass did not match."); 
              }
         }
		
         System.out.println("End Login Prompt.");
		
        
		
		
     }
}

	
	

