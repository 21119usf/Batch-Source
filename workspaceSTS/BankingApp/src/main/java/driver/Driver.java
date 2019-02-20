package driver;

import beans.*;

public class Driver {
	public static Bank bank = new Bank();
	
	public static void main(String[] args) {
		int option;
		boolean restart = true;
		while (restart) {
			option = bank.start();
			bank.readInfo();
			switch (option) {
			case 1:
				bank.login();
				break;
			case 2:
				bank.registerApplication();
				break;
			default:
				restart = false;
			}
			bank.printContents();
			if (!restart)
				break;
		}
		System.out.println("Exiting");
	}
}
