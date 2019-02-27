package com.revature.submenu;

import com.revature.people.Accounts;
import com.revature.util.InputScan;

//not completed

public class DepositMunny {
	int amount;
	int balance;
	
	Accounts act = new Accounts();
	
	public void deposit() {
		if(amount != 0) {
			balance += amount;
		
		
		System.out.println();
		System.out.println("Enter an amount to deposit: ");
		System.out.println();
		amount = InputScan.scan.nextInt();
		System.out.println();
		}

}
}