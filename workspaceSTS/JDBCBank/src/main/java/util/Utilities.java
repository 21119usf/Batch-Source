package util;

import java.util.ArrayList;

import beans.BankAccount;
import beans.LoginAccount;
import beans.UserAccount;

public class Utilities {

	public static void PrintUserInfo(LoginAccount login, UserAccount user, ArrayList<BankAccount> banks) {
		System.out.println("User ID: " + user.getUserID()
						  +"\nFirst Name: " + user.getFirstName()
						  +"\nLast Name: " + user.getLastName()
						  +"\nStreet Address: " + user.getStreetAddress()
						  +"\nE-mail: " + user.getEmail()
						  +"\nPhone #: " + user.getPhoneNum()
						  +"\nUsername: " + login.getUserName());
		System.out.println("\nBank ID\t\tBalance\t\tType");
		for (BankAccount b: banks)
			System.out.println(b.getBankAccountID() + "\t\t" + b.getBalance() + "\t\t"
								+ b.getAccountType());
		System.out.println();
	}
	
}
