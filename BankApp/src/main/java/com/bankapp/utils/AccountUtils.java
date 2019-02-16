package com.bankapp.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.bankapp.account.Account;

public class AccountUtils {
	public static String accountsFile = "Accounts.ser";
	public static ArrayList<Account> accounts = new ArrayList<Account>();
	
	// Load accounts from file
	@SuppressWarnings("unchecked")
	public static void loadAccounts() {
		try {
			FileInputStream af = new FileInputStream(accountsFile);
			ObjectInputStream ois = new ObjectInputStream(af);
			accounts = (ArrayList<Account>)ois.readObject();
			ois.close();
			af.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	// Save accounts to file
	public static void saveAccounts() {
		try {
			FileOutputStream af = new FileOutputStream(accountsFile);
			ObjectOutputStream oos = new ObjectOutputStream(af);
			oos.writeObject(accounts);
			oos.close();
			af.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
