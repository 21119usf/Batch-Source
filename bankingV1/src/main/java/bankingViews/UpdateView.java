package bankingViews;

import java.sql.SQLException;
import java.util.Scanner;

import bankingDaoImp.AdminDaoImp;

public class UpdateView implements View {

	@Override
	public void show(ViewStack views) {
		Scanner in = ViewStack.scanner;
		String options, console;
		AdminDaoImp adi = new AdminDaoImp();
		System.out.println("What account do you want to edit?");
		String username = in.nextLine();
		System.out.println("What is the new password?");
		String newPW = in.nextLine();
		System.out.println("What is the new name?");
		String newname = in.nextLine();
		System.out.println("What is the social?");
		Integer SSN = Integer.parseInt(in.nextLine().replaceAll("-", ""));
		System.out.println("The account will have to be approved again");
		try {
			adi.update(username, newPW, newname, SSN, false);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
