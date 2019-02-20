package banking;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.ThreadLocalRandom;

public class Customer extends User{

	// Fields
	private String name; 
	
	// Methods for customers: Constructor, open account, 
		// withdraw, deposit, transfer are handled by the account class
			// Login and readAccount are inherited from the User Superclass
	public Customer(String username) {
		this.setName(username);
	}
	
	public Customer(String username, String password) {
		this.setName(username);
		String contents = username + ":" + password + "\n";
		OutputStream os = null;
		File file = new File("Customer.txt");
		try {
			os = new FileOutputStream(file, true);
			
			os.write(contents.getBytes());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Account openAccount(Double deposit, String ... jointusers ) {
		String accountUsers = this.getName();
		for(String user: jointusers) {
			accountUsers = accountUsers + ";" + user;
		}
		// N.B. I am relying on the statistical unlikelihood of generating two accounts with the same number.
		// There should be some checks done, but I just don't feel like it at the second
		Integer ID = ThreadLocalRandom.current().nextInt(10000000, 100000000);
		String line = ID.toString() + ":" + deposit.toString() + ":false:" + accountUsers;
		OutputStream os = null;
		File file = new File("Accounts.txt");
		try {
			os = new FileOutputStream(file, false);
			os.write(line.getBytes());
			os.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Account newAccount = new Account(line);
		return newAccount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	
}
