package driver;

import daoImplementation.UserAccountDaoImpl;
import menus.MainMenu;

public class Driver {
	public static UserAccountDaoImpl uadi = new UserAccountDaoImpl();
	
	public static void main(String[] args) {
		MainMenu.start();
//		try {
//			for (UserAccount u: uadi.getAllAdmins()) {
//				System.out.println(u.toString());
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
}
