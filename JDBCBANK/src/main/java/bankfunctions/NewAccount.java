package bankfunctions;

import java.sql.SQLException;
import java.util.Scanner;

import bankdata.BankAccount;
import bankdata.Checks;

public class NewAccount {

	static void newACC(String x) throws SQLException {
		Scanner bankScans = new Scanner(System.in);
		System.out.println("Would you like to make a new account? "+ "1.) Yes  2.) No ");
		
		String userInput3 = bankScans.nextLine();
		String h = userInput3.toLowerCase();
		
		if (h.equals("1") ) {
			BankAccount.bankInfo(x);
			BankMenu2.entry(Checks.f);
		}
		else {
			BankMenu2.entry(Checks.f);
		}
		
		
	}
}
