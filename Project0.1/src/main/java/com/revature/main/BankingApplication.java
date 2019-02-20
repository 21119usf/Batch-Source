package com.revature.main;

import java.io.IOException;

import com.revature.classes.AccountCreator;
import com.revature.classes.CustomerAccount;

/*
 * banking application by Dustyn Fletcher
 * project0
 */
   
public class BankingApplication {

	public static void main(String[] args) throws IOException {
	
		AccountCreator.CreateAccount();
		CustomerAccount.showMenu();
		
	}
}
