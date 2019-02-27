package bankfunctions;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import bankdata.Balance;
import bankdata.BankAccInfo;
import bankdata.BankAccountDao;
import bankdata.Readers;

public class Deposit {

	
	static void depositK(String x) throws SQLException {
		//ask for deposit amount 
	Scanner bankScans = new Scanner(System.in);
	Scanner bankScans2 = new Scanner(System.in);
	//List<BankAccInfo> g = Readers.getBankInfo();
	String bally=Balance.baldisplay(x);
	
	
		System.out.println("How much would you like to deposit?");
		 String n = bankScans.nextLine();
		 Scanner y = bankScans2;
		double stringCon= Double.parseDouble(n);
		
		
		 if(stringCon < 0)
		 {
			 System.out.println("You entered a negative balance");
			 //depositK();
		 }
		 
		 //deposited integer will go into their account balance 
		// integer will be deposited to an the customer's arrayList 
		 
		String currentBal = bally;
		Double balConvert = Double.parseDouble(currentBal);
		Double sum = balConvert + stringCon;
		String banker = sum.toString();
		
		 try {
			BankAccountDao.updateBank(banker,x);
			Balance.baldisplay(x);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Your balance is: "+ Balance.money);
		System.out.println("Would you like to make another deposit? \n"+ "1). Yes  2). No");
			String yy = y.nextLine();
			String rety = yy.toLowerCase();
		if(rety.equals("yes") || rety.equals("1")) {
			depositK(x);
		}
		else 
		{
			BankMenu2.entry(x);
		}
		
	}
	
	
	
	
	
	
	
	
	
}
