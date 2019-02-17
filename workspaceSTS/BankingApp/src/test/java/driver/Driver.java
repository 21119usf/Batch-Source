package driver;

import beans.*;

public class Driver {
	public static Bank bank = new Bank();
	
	public static void main(String[] args) {
		int option;
		User user = null;
		boolean restart = true;
		while (restart) {
			option = bank.start();
		
			switch (option) {
			case 1:
				user = bank.login();
				//System.out.println(user);
				break;
			case 2:
				bank.registerApplication();
				break;
			default:
				restart = false;
			}
			if (!restart)
				break;
			bank.loggedInMenu(user);
		}
		System.out.println("Exiting");
	}
}
