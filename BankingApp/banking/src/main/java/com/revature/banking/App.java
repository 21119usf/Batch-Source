package com.revature.banking;

import java.util.Scanner;

public class App 
{
	IO io = new IO();
    public static void main( String[] args )
    {
    	startup();
    }
    
    
    static void startup (){

    	boolean on = true;
    	while (on) {
    		System.out.println("=================================================================\n"
    				+ 		   "================###===###===#########===#########================\n"
    				+ 		   "================###===###===###=========###======================\n"
    				+ 		   "================###===###===###=========######===================\n"
    				+ 		   "================###===###===###=========###======================\n"
    				+ 		   "================#########===#########===###======================\n"
    				+ 		   "=================================================================");
        System.out.println("=========Thank you for choosing Union Central Financial =========\n"
        		+ "=Type \"new\" to create a new account, or enter your username here=\n"
        		+ "=================================================================");
    
    Scanner input = new Scanner(System.in);
    String response = input.nextLine();
    //System.out.println(response);
    if (response.equals("off")) {
    	System.out.println("Program shutting down...");
    	on = false;
    }
    else if (response.equals("new")) {
    	newCustomer cust = new newCustomer();
    	cust.usernameChoose();
    	System.out.println("Thank you for applying. \n"
    			+ "One of our team members will review your application and either\n approve or deny it shortly.\n"
    			+ "=================================================================\n"
    			+ "Have a Great Day!");
    }
    else {
    	LogonAttempt attempt = new LogonAttempt();
    	LogonAttempt.login(response);
    	
    }
    
    
    
}
    }
}