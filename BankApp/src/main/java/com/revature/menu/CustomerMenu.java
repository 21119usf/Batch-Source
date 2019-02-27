package com.revature.menu;

import com.revature.input.CustSub;
import com.revature.people.Customer;
import com.revature.util.InputScan;

public class CustomerMenu {
	private Customer c = new Customer();
	
	public void CustMenu() {
		System.out.println(" Welcome " );
		System.out.println();
		System.out.println("A. Check Balance");
		System.out.println("B. Deposit");
		System.out.println("C. Withdraw");
		System.out.println("D. Previous Transactions");
		System.out.println("E. Exit");
		System.out.println();
		System.out.println("Enter option: ");
		System.out.println();
		String input = InputScan.scan.nextLine();
		new CustSub().SwitchCustSub(input);
	}

}
