package bankfunctions;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import bankdata.Balance;
import bankdata.Checks;


public class BankMenu2 {
	
	
	public static void entry(String x) throws SQLException {
	if (x.equals(Checks.f) ) {
		List<String> bankAccounts = new ArrayList<String>();
		Scanner bankScans = new Scanner(System.in);
		System.out.println("Welcome to your account " + Balance.namedisplay(x));
		System.out.println("What would you like to do? \n" + "1.) Deposit 2). Withdraw 3). Open New Account 4). Balance Display 5). Logout ");
		String userInput3 = bankScans.nextLine();
		String h = userInput3.toLowerCase();
		
		if (h.equals("1") ) {
			menu2(1);
		}
		else if (h.equals("2")) {
			menu2(2);
		}
		
		else if (h.equals("3")) {
			menu2(3);
		}
	
		else if (h.equals("4")) {
			System.out.println("Your balance is: "+ Balance.baldisplay(x));
			BankMenu2.entry(x);
		}
		else if(h.equals("5")) {
			
			System.out.println("Now Logging off account");
			try {
				BankMenu.menuStart();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else {
			System.out.println("Enter a correct numerical option");
			entry(x);
		}

		}
	else {
		System.out.println("Validation error: Logging out");
		try {
			BankMenu.menuStart();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
	static String y=Checks.f;
static void menu2(int b) throws SQLException {
	
	switch(b) {
	
	case 1: 
		
			Deposit.depositK(y);
			//List<String> l = bankAccounts;
			//System.out.println("You now have " + l +" In your account");
			//System.out.println();
			break;
	case 2:
		Withdraw.withdrawl(y);
			break;
	case 3: 
		NewAccount.newACC(y);
			break;
			
	
	}
	
	
}
	
	
}
