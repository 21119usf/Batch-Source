package menus;

import java.sql.SQLException;
import java.util.Scanner;

import beans.*;
import daoImplementation.*;

public class MainMenu {

	static LoginAccountDaoImpl ladi = new LoginAccountDaoImpl();
	static UserAccountDaoImpl uadi = new UserAccountDaoImpl();

	public static void start() {
		boolean restart = true;
		do {
			System.out.print("Welcome to the Marx Bank"
					+ "\nTo select options, please type the number next to your choice and hit enter"
					+ "\n\nWould you like to login, register, or exit?"
					+ "\n(0) - Login"
					+ "\n(1) - Register"
					+ "\n(2) - Exit"
					+ "\n> ");
			Scanner input = new Scanner(System.in);
			int option = input.nextInt();
			switch (option) {
			case 0:
				login();
				break;
			case 1:
				RegisterMenu.start();
				break;
			default:
				restart = false;
			}
		} while (restart);
		System.out.println("Exiting");
	}

	public static void login() {
		Scanner input = new Scanner(System.in);
		LoginAccount login = new LoginAccount();
		String username = "";
		String password = "";
		boolean successfulLogin = false;
		do {
			System.out.print("Username: ");
			username = input.nextLine();
			System.out.print("Password: ");
			password = input.nextLine();
			try {
				if (!ladi.authenticateLogin(username, password))
					System.out.println("Invalid username/password combination");
				else {
					successfulLogin = true;
					login = ladi.getLogin(username);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} while (!successfulLogin);
		UserAccount user = new UserAccount();
		try {
			user = uadi.getUser(login.getUserID());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (user.getApproval() == 0) {
			System.out.println("\nSorry, but your account has not yet been approved by a representative.\n"
								+ "Please try again at a later time.\n\n");
			return;
		}
		switch (user.getIsAdmin()) {
			case 0:
				UserMenu.start(login, user);
				break;
			case 1:
				AdminMenu.start(login, user);
				break;
		}
	}
}
