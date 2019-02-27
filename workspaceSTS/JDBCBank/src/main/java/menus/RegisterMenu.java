package menus;

import java.sql.SQLException;
import java.util.Scanner;

import beans.*;
import daoImplementation.*;


public class RegisterMenu {
	public static LoginAccountDaoImpl ladi = new LoginAccountDaoImpl();
	public static UserAccountDaoImpl uadi = new UserAccountDaoImpl();

	public static void start() {
		Scanner input = new Scanner(System.in);
		UserAccount newUser = new UserAccount();
		System.out.print("Please enter the following information for your account"
					+ "\nFirst Name: ");
		newUser.setFirstName(input.nextLine());
		System.out.print("Last Name: ");
		newUser.setLastName(input.nextLine());
		System.out.print("Street Address: ");
		newUser.setStreetAddress(input.nextLine());
		System.out.print("E-mail address: ");
		newUser.setEmail(input.nextLine());
		System.out.print("Phone #: ");
		newUser.setPhoneNum(input.nextLine());
		System.out.print("Are you registering for an admin account? (Y/N): ");
		char c = input.nextLine().charAt(0);
		if (c == 'Y' || c == 'y')
			newUser.setIsAdmin(1);
		
		LoginAccount newLogin = new LoginAccount();
		boolean uniqueLogin = false;
		String username = "";
		while (!uniqueLogin || username.equals("")) {
			System.out.print("Username: ");
			username = input.nextLine();
			try {
				uniqueLogin = ladi.verifyUniqueName(username);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (username.equals(""))
				System.out.println("You must enter a username.");
			else if (!uniqueLogin)
				System.out.println("Sorry, that username is already taken.");
			
		}
		newLogin.setUserName(username);
		System.out.print("Password: ");
		newLogin.setPassword(input.nextLine());
		
		System.out.print("\nYour application shows...\n" + newUser.toString() + "\n"
						+ newLogin.toString() + "\nIs this what you would like to submit? (y/n)\n> ");
		c = input.nextLine().charAt(0);
		if (c == 'y' || c == 'Y') {
			try {
				ladi.createLoginAccount(newLogin.getUserName(), newLogin.getPassword());
				newLogin = ladi.getLogin(newLogin.getUserName());
				uadi.createUserAccount(newLogin.getUserID(), newUser.getFirstName(), newUser.getLastName(),
										newUser.getStreetAddress(), newUser.getEmail(), newUser.getPhoneNum(),
										newUser.getApproval(), newUser.getIsAdmin());
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("\nYour application was submitted successfully."
							+ "\nPlease wait for a staff member to approve your application."
							+ "\nOnce approved you may log in to your account and manage it.\n\n");
//			logger.info(newUser.getUserName() + " submitted an application for an account.");
		}
		else
			System.out.println("\nYour application was not submitted.\n\n");
	}
}
