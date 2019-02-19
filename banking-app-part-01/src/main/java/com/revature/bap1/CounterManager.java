package com.revature.bap1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class CounterManager {

	private Counter c;
	
	private static final String COUNTER_FILE = "counter.ser";
	
	public CounterManager() {
		c = new Counter();
	}
	
	public void readFile() {
		File file = new File(COUNTER_FILE);
		
		if (file.exists()) {
			try {
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(COUNTER_FILE));
				c = (Counter) ois.readObject();
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
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(COUNTER_FILE));
			oos.writeObject(c);
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int getNewUserCount() {
		c.incrementUserCounter();
		return c.getUserCounter();
	}
	
	public int getNewAccountCount() {
		c.incrementAccountCounter();
		return c.getUserCounter();
	}
	
	public int getNewAppCount() {
		c.incrementAppCounter();
		return c.getAppCounter();
	}
}
