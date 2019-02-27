package com.revature.submenu;

import com.revature.util.InputScan;

public class WithdrawMunny{
	int amount;
	int balance;
	
	public void withdraw() {
		if(amount != 0) {
			balance = balance - amount;
		
		
		System.out.println();
		System.out.println("Enter an amount to withdraw: ");
		System.out.println();
		amount = InputScan.scan.nextInt();
		System.out.println();
		}

}

}
