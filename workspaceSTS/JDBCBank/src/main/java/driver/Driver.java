package driver;

import java.sql.SQLException;

import beans.BankAccount;
import daoImplementation.BankAccountDaoImpl;
import daoImplementation.LoginAccountDaoImpl;

public class Driver {
	
	public static void main(String[] args) {
		LoginAccountDaoImpl ladi = new LoginAccountDaoImpl();
		BankAccountDaoImpl badi = new BankAccountDaoImpl();
		//TESTS FOR LOGINACCOUNT
//		try {
//			ladi.createLoginAccount("Marky", "Seraph", 15);
//			for (LoginAccount log: ladi.getAllLogins()) {
//				System.out.println(log);
//			}
//			System.out.println(ladi.getLogin("Marx"));
//			ladi.changeUsername("Marx", "Mawrix");
//			ladi.changePassword("Mawrix", "Mexiturtle");
//			ladi.removeLoginAccount("Mark");
//			if (ladi.authenticateLogin("Mawrix", "Mexiturtle"))
//				System.out.println("TRUE");
//			else
//				System.out.println("FALSE");
//			if (ladi.verifyUniqueName("Mawrix"))
//				System.out.println("unique");
//			else
//				System.out.println("not unique");
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		
		//TESTS FOR BANKACCOUNTS
//		try {
//			badi.createBankAccount(18, 2.521, "Savings");
//			for (BankAccount log: badi.getAllBankAccounts()) {
//				System.out.println(log);
//			}
//			System.out.println(badi.getBankAccountsOfUser(18));
//			badi.changeBalance(6, 999.99);
//			badi.changeAccountType(6, "Savings");
//			badi.removeBankAccount(6);
//			badi.removeAllBankAccounts(18);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
	}
}
