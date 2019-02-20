package com.revature.fileIO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.LinkedList;

import com.revature.beans.Account;
import com.revature.beans.Customer;
import com.revature.beans.User;

/*This class is used to load and store the state of the app upon startup
 * and shut down. It does this in 6 methods. 3 read from files to fill our object
 * The last 3 overwrite to files. Each 1 of the 3 is for a specific object in the
 * driver class
 * 
 */


public class FileIO {
	private static final String USER_FILE="users.txt";
	private static final String APP_QUEUE_FILE="appQueue.txt";
	private static final String ACCOUNT_FILE="accounts.txt";
	
	public static void writeUserFile(ArrayList<User> users) {
		try {
			ObjectOutputStream objectOut = new ObjectOutputStream (new FileOutputStream(USER_FILE));
			objectOut.writeObject(users);
			objectOut.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void writeAppQueueFile(LinkedList<Customer> appQ) {
		try {
			ObjectOutputStream objectOut = new ObjectOutputStream (new FileOutputStream(APP_QUEUE_FILE));
			objectOut.writeObject(appQ);
			objectOut.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void writeAccountFile(ArrayList<Account> accounts) {
		try {
			ObjectOutputStream objectOut = new ObjectOutputStream (new FileOutputStream(ACCOUNT_FILE));
			objectOut.writeObject(accounts);
			objectOut.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public static ArrayList<User> readUserFile() {
		ObjectInputStream  objectIn;
		ArrayList<User> users = new ArrayList<User>();
		try {
			objectIn = new ObjectInputStream(new FileInputStream(USER_FILE));
			users = (ArrayList<User>) objectIn.readObject();
			objectIn.close();	
		} catch (FileNotFoundException e) {
			return users;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return users;
	}
	@SuppressWarnings("unchecked")
	public static LinkedList<Customer> readAppQueueFile() {
		ObjectInputStream  objectIn;
		LinkedList<Customer> appQueue = new LinkedList<Customer>();
		try {
			objectIn = new ObjectInputStream(new FileInputStream(APP_QUEUE_FILE));
			appQueue = (LinkedList<Customer>) objectIn.readObject();
			objectIn.close();	
		} catch (FileNotFoundException e) {
			return appQueue;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return appQueue;
	}
	@SuppressWarnings("unchecked")
	public static ArrayList<Account> readAccountFile() {
		ObjectInputStream  objectIn;
		ArrayList<Account> accounts = new ArrayList<Account>();
		try {
			objectIn = new ObjectInputStream(new FileInputStream(ACCOUNT_FILE));
			accounts = (ArrayList<Account>) objectIn.readObject();
			objectIn.close();	
		} catch (FileNotFoundException e) {
			return accounts;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return accounts;
	}

}
