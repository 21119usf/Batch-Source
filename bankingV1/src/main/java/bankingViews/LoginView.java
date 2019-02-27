package bankingViews;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import banking.Driver;
import banking.User;
import bankingDaoImp.AdminDaoImp;
import bankingDaoImp.UserDaoImp;

public class LoginView implements View {
	private final static Set<String> USERTYPES = Collections.unmodifiableSet(
			new	HashSet<String>(Arrays.asList("Customer","Admin","New User")));
	private static final Logger logger = LogManager.getLogger(Driver.class);

	Scanner in = ViewStack.scanner;
	String usertype,username,password;


	@Override
	public void show(ViewStack vc) {
		do {System.out.println("\nWhat type of user are you?");
		System.out.print("Customer, Admin, or New User: ");
		usertype = in.nextLine();}
		while (!USERTYPES.contains(usertype));
		if(usertype.contains("New")) {
			vc.getNextView("new");
		} else {
			System.out.println("Welcome " + usertype + "!, Would you care to log in?");
			boolean verified = false;
			int logincount = 0;
			while (!verified && logincount < 3) {
				System.out.print("Username: ");
				username = in.nextLine();
				System.out.print("Password: ");
				password = in.nextLine();
				logincount++;
				switch (usertype) {
				case "Customer":
					UserDaoImp udi = new UserDaoImp();
					try {
						verified=udi.login(username, password);
						if(verified) {
							logger.trace("User " + username + " has logged in");
							vc.activeUser=username;
							vc.getNextView("user");
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
					break;
				case "Admin":
					AdminDaoImp adi = new AdminDaoImp();
					try {
						verified=adi.login(username, password);
						if(verified) {
							logger.trace("Admin " + username + " has logged in");
							vc.activeUser=username;
							vc.getNextView("admin");
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
					break;
				}
				if (logincount == 3) {
					System.out.println("You forgot your password, didn't you?");
					break;
				}
			}
		}
	}
}
