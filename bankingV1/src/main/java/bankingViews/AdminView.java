package bankingViews;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import banking.Account;
import banking.User;
import bankingDaoImp.AccountDaoImp;
import bankingDaoImp.AdminDaoImp;

public class AdminView implements View {

	@Override
	public void show(ViewStack vc) {
		Scanner in = ViewStack.scanner;
		String options, console;
		AdminDaoImp adi = new AdminDaoImp();
		
		while(true) {
			options = "Approve Accounts, Edit Users, List Accounts, or Log Out";
			System.out.println(options);
			console = in.nextLine();
			if (console.contains("Approve")) {
				try {
					List<User> myUsers = adi.getUsers();
					for (User u: myUsers) {
						if (!u.getApproved()) {
							u.display();
							System.out.println("Approve? (Y/N)");
							if (in.nextLine().contains("Y")) {
								u.setApproved(true);
							}
						}
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} else if (console.contains("Edit Users")){
				vc.getNextView("update");
				
			} else if (console.contains("List")){				try {
					List<Account> myAccounts = adi.getAccounts();
					for (Account a: myAccounts) {
						a.display();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			} else if (console.contains("Log Out")){
				vc.getLastView();
				break;
			}
			
		}
		

	}

}
