package com.revature.bap1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class AccountManager {
	
	private List<Account> accountList;
	
	private static final String ACCOUNT_FILE = "account.ser";
	
	public AccountManager() {
		accountList = new ArrayList<Account>();
	}
	
	public void readFile() {
		File file = new File(ACCOUNT_FILE);
		
		if (file.exists()) {
			try {
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ACCOUNT_FILE));
				accountList = (ArrayList<Account>) ois.readObject();
				ois.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void writeFile() {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ACCOUNT_FILE));
			oos.writeObject(accountList);
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
