package com.revature.banking;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App 
{
	//initializing the input/output Class
	static IO io = new IO();
	
	//Such a beautifully simple main makes me happy :D
    public static void main( String[] args )
    {
    	startup();
    }
    
    
    static void startup (){
    	//initializing a boolean to maintain the login screen
    	boolean on = true;
    	while (on) {
    		System.out.println("=================================================================\n"
    				+ 		   "================###===###===#########===#########================\n"
    				+ 		   "================###===###===###=========###======================\n"
    				+ 		   "================###===###===###=========######===================\n"
    				+ 		   "================###===###===###=========###======================\n"
    				+ 		   "================#########===#########===###======================\n"
    				+ 		   "=================================================================");
        System.out.println(	   "=========Thank you for choosing Union Central Financial =========\n"
        		+ 			   "=Type \"new\" to create a new account, or enter your username here=\n"
        		+ 			   "=================================================================");
        			//having the user input username, or create a new user, from this screen
        			//saves us from having an extra screen
        			Scanner input = new Scanner(System.in);
        			String response = input.nextLine();
    
    //since this app is intended to be running indefinitely, the option to terminate it is hidden
    if (response.equals("off")) {
    	System.out.println("Program shutting down...");
    	on = false;
    }
    //creating a new account from this screen; constructs the newCustomer Class
    else if (response.equals("new")) {
    	newCustomer cust = new newCustomer();
    	cust.usernameChoose();
    	//After applying, the applicant will need to wait for approval to access their account
    	System.out.println("Thank you for applying. \n"
    			+ "One of our team members will review your application and either\n approve or deny it shortly.\n"
    			+ "=================================================================\n"
    			+ "Have a Great Day!");
    }
    else {
    	//if not a new user, we construct the LogonAttempt Class, importing the 'response' input variable
    	LogonAttempt attempt = new LogonAttempt();
    	LogonAttempt.login(response);
    	
    }
}
    }
}