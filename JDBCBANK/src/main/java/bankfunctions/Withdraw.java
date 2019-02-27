package bankfunctions;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import bankdata.Balance;
import bankdata.BankAccountDao;

public class Withdraw {
	
	protected static void  withdrawl(String x) throws SQLException {
		Scanner bankScans = new Scanner(System.in);
		Scanner bankScans2 = new Scanner(System.in);
		System.out.println("How much would you like to withdraw?");
		 String n = bankScans.nextLine();
		 Scanner y = bankScans2;
		 String bally=Balance.baldisplay(x);
		Double stringCon2= Double.parseDouble(n);
	
		double accountCheck = Double.parseDouble(bally);
		//checks for negative account balance
		 if(accountCheck < stringCon2)
		 {
			 System.out.println("You can't withdraw a negative amount from account");
			 withdrawl(x);
		 }
		

			//String currentBal = c.get(0);
			//Double balConvert = Double.parseDouble(currentBal);
			Double sum = accountCheck - stringCon2;
			String banker = sum.toString();
			BankAccountDao.updateBank(banker,x);
			Balance.baldisplay(x);
			System.out.println("Your balance is: "+ Balance.money);
			System.out.println("Would you like to make another Withdrawal? \n"+ "1). Yes  2). No");
				String yy = y.next();
				
				String g = yy.toLowerCase();
				if(g.equals("yes") || g.equals("1")) {
					withdrawl(x);
				}
				else 
				{
					BankMenu2.entry(x);
				}
		
		bankScans.close();
		bankScans2.close();
	}
}
