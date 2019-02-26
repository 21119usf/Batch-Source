package driver;

import java.sql.SQLException;

import beans.LoginAccount;
import beans.UserAccount;
import beans.BankAccount;
import daoImplementation.BankAccountDaoImpl;
import daoImplementation.LoginAccountDaoImpl;
import daoImplementation.UserAccountDaoImpl;

public class Driver {
	
	public static void main(String[] args) {
		LoginAccountDaoImpl ladi = new LoginAccountDaoImpl();
		BankAccountDaoImpl badi = new BankAccountDaoImpl();
		UserAccountDaoImpl uadi = new UserAccountDaoImpl();
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
		
		//TESTS FOR USERACCOUNTS
//		try {
//			uadi.createUserAccount("Mark", "Venegas", "8327 Serenity Ct.",
//									"markavenegas@hotmail.com", "6198312031", 0, 0);
//			uadi.createUserAccount("Erik", "Venegas", "8327 Serenity Ct.",
//					"mexiturtle321@gmail.com", "123456789", 0, 0);
//			uadi.createUserAccount("Luis", "Venegas", "8327 Serenity Ct.",
//					"mecpd@ci.el.cajon", "987654321", 0, 1);
//			for (UserAccount log: uadi.getAllUsers()) {
//				System.out.println(log);
//			}
//			System.out.println(uadi.getUser(3));
//			uadi.changeFirstName(3, "Luis");
//			uadi.changeLastName(3, "Venegas");
//			uadi.changeStreetAddress(3, "Somewhere");
//			uadi.changeEmail(3, "An Email");
//			uadi.changePhoneNum(3, "A Number");
//			uadi.changeApproval(3, 1);
//			uadi.removeUser(3);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
	}
}
