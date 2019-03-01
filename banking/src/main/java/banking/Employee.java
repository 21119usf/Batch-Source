package banking;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

public class Employee extends User {

	private String name;
	
	// Methods for customers: Constructor, approve account, list accounts 
		// withdraw, deposit, transfer are handled by the account class
			// Login and readAccount are inherited from the User Superclass
	
	public Employee () {
		// System.out.println("This is needed to fix implicit super constructor undefined error");
	}
	
	public Employee (String username) {
		this.setName(username);
		
	}
	
	public Employee(String username, String password) {
//		String hashpw = "";
//		for(int i = 0; i < password.length(); i++) {
//			hashpw += password.charAt(i);
//		}
//		System.out.println(hashpw.toString());
		String contents = username + ":" + password + "\n";
		OutputStream os = null;
		File file = new File("Employee.txt");
		try {
			// this needs to be false to make the file, but true to append.
			// tried to handle with try catch, but Java doesn't like it.
			os = new FileOutputStream(file, true);
			os.write(contents.getBytes());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// approve account() {}
	public void approve(Account ID) {
		ID.setActive(true);
	}
	
	public void deny(Account ID) {
		ID.setActive(false);
	}
	
	// accountList() {}
	public void accountList() {
		ArrayList<String> accounts = new ArrayList<String>();
		FileReader fr;
		try {
			fr = new FileReader("Accounts.txt");
			BufferedReader br = new BufferedReader(fr);
			while (br.ready()) {
				String[] args = br.readLine().split(":");
				accounts.add(args[0]);
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void displayAccounts(ArrayList<Account> accounts) {
		for(Account a: accounts) {
			String fu = String.format("%i:%.2f:%b:%s", a.getID(),a.getBalance(),a.isActive(),a.getCustomers());
			String bar[] = fu.split(":");
			System.out.println("Account ID: " + bar[0]);
			System.out.println("Account Balance: " + bar[1]);
			System.out.println("Account Active: " + bar[2]);
			// possibly should separate customers and print line by line, but to do later
			System.out.println("Account Customers:" + bar[3]);
		}
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
