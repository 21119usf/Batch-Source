package com.revature.input;

import java.sql.SQLException;
import java.util.ArrayList;

import com.reavature.validate.ValidatorException;
import com.reavture.beans.Account;
import com.reavture.beans.User;
import com.revature.utilities.DAOUtilities;
import com.revature.utilities.LoggerUtil;
import com.revature.utilities.ScannerInstance;
import com.revature.view.CustomerPortalHomeView;
import com.revature.view.HomeView;

public class CustomerAccountPageInput implements CanTakeInput {

	Account a;
	ArrayList<Account> accounts;
	User u;
	String input;
	public CustomerAccountPageInput(Account a, ArrayList<Account> accounts, User u) {
		this.a = a;
		this.accounts = accounts;
		this.u = u;
	}

	@Override
	public int getInput() {
		input = ScannerInstance.scan.next();
		try {
			validate();
		} catch (ValidatorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public void validate() throws ValidatorException {
		switch (input) {
			case "1":
				deposit();
				break;
			case "2":
				withdraw();
				break;
			case "3":
				close();
				break;
			case "4":
				new HomeView().display();
				break;
			default:
				throw new ValidatorException("Invalid Input");
		}

	}

	@Override
	public void onInvalidInput(Exception e) {
		// TODO Auto-generated method stub

	}
	
	public void deposit() {
		System.out.println("Please Select Account To Transfer From");
		for (Account x : accounts) {
			if (x.getAccountId() == a.getAccountId()) {
				// DO NOTHING
			} else {
				System.out.println("Account Id: " + x.getAccountId());
				System.out.println("Balance: " + x.getBalance());
			}
		}
		input = ScannerInstance.scan.next();
		for (Account z : accounts) {
			if (z.getAccountId() == Integer.parseInt(input)) {
				System.out.println("Ammount To Deposit");
				double depositAmmount = Double.parseDouble(ScannerInstance.scan.next());
				try {
					DAOUtilities.getUserAccountDAO().transfer(a, z.getAccountId(), depositAmmount);
					LoggerUtil.LOGGER.info("Money Transfered: " + input + "$ " + "From: " + a.getAccountId() + "To: " );
					new CustomerPortalHomeView(u).display();
				} catch (NumberFormatException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public void withdraw() {
		System.out.println("Please Select Account To Transfer From");
		for (Account x : accounts) {
			if (x.getAccountId() == a.getAccountId()) {
				// DO NOTHING
			} else {
				System.out.println("Account Id: " + x.getAccountId());
				System.out.println("Balance: " + x.getBalance());
			}
		}
		input = ScannerInstance.scan.next();
		for (Account z : accounts) {
			if (z.getAccountId() == Integer.parseInt(input)) {
				System.out.println("Ammount To Deposit");
				double depositAmmount = Double.parseDouble(ScannerInstance.scan.next());
				try {
					DAOUtilities.getUserAccountDAO().transfer(z, a.getAccountId(), depositAmmount);
					new CustomerPortalHomeView(u).display();
				} catch (NumberFormatException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public void close() {
		if (a.getBalance() == 0) {
			try {
				DAOUtilities.getUserAccountDAO().closeAccount(a.getAccountId());
				System.out.println("Account Closed");
				new CustomerPortalHomeView(u).display();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Can Not Close Account That Still Has Money");
		}
	}

}
