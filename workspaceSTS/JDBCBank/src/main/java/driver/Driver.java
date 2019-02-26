package driver;

import java.sql.SQLException;

import beans.LoginAccount;
import daoImplementation.LoginAccountDaoImpl;

public class Driver {
	
	public static void main(String[] args) {
		LoginAccountDaoImpl ladi = new LoginAccountDaoImpl();
	
		try {
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
			if (ladi.verifyUniqueName("Mawrix"))
				System.out.println("unique");
			else
				System.out.println("not unique");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
