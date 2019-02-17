package driver;

import java.util.Scanner;

import beans.*;

public class Driver {
	public static Bank bank = new Bank();
	
	public static void main(String[] args) {
		int option;
		User user = null;
		option = bank.start();
		
		switch (option) {
		case 1:
			user = bank.login();
			System.out.println(user);
			break;
		case 2:
			bank.registerApplication();
		}
	}
}
