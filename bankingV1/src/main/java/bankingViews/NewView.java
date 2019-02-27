package bankingViews;

import java.sql.SQLException;
import java.util.Scanner;

import bankingDaoImp.UserDaoImp;

public class NewView implements View {

	@Override
	public void show(ViewStack vc) {
		Scanner in = ViewStack.scanner;
		UserDaoImp udi = new UserDaoImp();
		
		System.out.println("I'll need to get some information to open your account.");
		System.out.println("First, what will your username be?");
		String fu = in.nextLine();
		System.out.println("Next, could you kindly set a password. Don't forget it!");
		String bar = in.nextLine();
		System.out.println("And I'll need your full name as it appears on your Social Security Card.");
		String name = in.nextLine();
		System.out.println("Finally, I'll need your social security number");
		Integer social = Integer.parseInt(in.nextLine().replaceAll("-", ""));
		try {
			udi.register(fu, bar, name, social);
			// Log this
			System.out.println("Thank you for registering, " + name +"\nAn Admin will approve your account shortly");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		vc.getLastView();
	}

}
