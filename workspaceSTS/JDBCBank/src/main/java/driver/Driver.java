package driver;

import daoImplementation.UserAccountDaoImpl;
import menus.MainMenu;

public class Driver {
	public static UserAccountDaoImpl uadi = new UserAccountDaoImpl();
	
	public static void main(String[] args) {
		MainMenu.start();
	}
}
