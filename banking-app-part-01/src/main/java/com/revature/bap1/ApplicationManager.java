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

public class ApplicationManager {
	
	private List<Application> appList;
	
	private static final String APP_FILE = "app.ser";
	
	public ApplicationManager() {
		appList = new ArrayList<Application>();
	}
	
	public void readFile() {
		File file = new File(APP_FILE);
		
		if (file.exists()) {
			try {
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(APP_FILE));
				appList = (ArrayList<Application>) ois.readObject();
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
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(APP_FILE));
			oos.writeObject(appList);
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void printAppList() {
		for (Application a : appList) {
			System.out.println(a);
		}
	}
	
	public void applySingleAccount(int accountID, int customerID, int applicationID) {
		appList.add(new Application(accountID, customerID, applicationID));
	}
}
