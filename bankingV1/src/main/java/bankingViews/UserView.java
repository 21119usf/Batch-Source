package bankingViews;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import banking.Account;
import banking.Driver;
import bankingDaoImp.AccountDaoImp;
import bankingDaoImp.UserDaoImp;

public class UserView implements View {
	private static final Logger logger = LogManager.getLogger(Driver.class);
	
	@Override
	public void show(ViewStack vc) {
		Scanner in = ViewStack.scanner;
		String options, console;
		UserDaoImp udi = new UserDaoImp();
		AccountDaoImp accdi = new AccountDaoImp();
		
		
		while(true) {
			options ="View Accounts, Open Account, Withdraw, Deposit, Transfer, Close Accounts, or Log Out";
			System.out.println(options);
			console = in.nextLine();
			List<Account> myAccounts;
			if (console.contains("View")) {
				try {
					myAccounts = udi.getAccounts(vc.activeUser);
					for (Account a: myAccounts) {
						a.display();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} else if (console.contains("Open")) {
				try {
					udi.openacc(vc.activeUser);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} else if (console.contains("Withdraw")) {
				try {
					myAccounts = udi.getAccounts(vc.activeUser);
					for (Account a: myAccounts) {
						a.display();
						System.out.println("Is this the account you wish to draw from? (Y/N)");
						if (in.nextLine().contains("Y")) {
							System.out.println("How much would you like to withdraw?");
							Double amount = Double.parseDouble(in.nextLine());
							if (amount <= a.getBalance()) {
								accdi.withdraw(a.getID(), amount);
								logger.trace("User " + vc.activeUser + " has withdrawn " + amount + " from account " + a.getID());
							} else {
								System.out.println("You can't withdraw that much, peasant!");
							}
							break;
						}
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} else if (console.contains("Deposit")) {
				try {
					myAccounts = udi.getAccounts(vc.activeUser);
					for (Account a: myAccounts) {
						a.display();
						System.out.println("Is this the account you wish to deposit into? (Y/N)");
						if (in.nextLine().contains("Y")) {
							System.out.println("How much would you like to deposit?");
							Double amount = Double.parseDouble(in.nextLine());
							accdi.deposit(a.getID(), amount);
							logger.trace("User " + vc.activeUser + " has deposited " + amount + " into account " + a.getID());
							break;
						}
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} else if (console.contains("Transfer")) {
				try {
					myAccounts = udi.getAccounts(vc.activeUser);
					for (Account a: myAccounts) {
						a.display();
						System.out.println("Is this the account you wish to transfer from? (Y/N)");
						if (in.nextLine().contains("Y")) {
							System.out.println("How much would you like to transfer?");
							Double amount = Double.parseDouble(in.nextLine());
							if (amount <= a.getBalance()) {
								for (Account b: myAccounts) {
									b.display();
									System.out.println("Is this the account you wish to transfer to? (Y/N)");
									if (in.nextLine().contains("Y")) {
										accdi.transfer(a.getID(), b.getID(), amount);
										logger.trace("User " + vc.activeUser + " has transfered " + amount + " from account " + a.getID() + " to account " + b.getID());
									}
								}
							} else {
								System.out.println("You can't transfer that much, peasant!");
							}
							break;
						}
					} 
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} else if (console.contains("Close")) {
				try {
					udi.closeacc(vc.activeUser);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} else if (console.contains("Log Out")) {
				vc.getLastView();
				break;
			}
		}

	}

}
