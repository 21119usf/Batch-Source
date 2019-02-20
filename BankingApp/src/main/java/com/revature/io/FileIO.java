package com.revature.io;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.revature.beans.Admin;
import com.revature.beans.User;

public class FileIO {
	
	public static boolean isAdmin() {
		ArrayList<User> users = getFromFile("users.txt");
		for (User x : users) {
			if (x instanceof Admin) {
				return true;
			}
		}
		return false;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> ArrayList<T> getFromFile(String file) {
		try {
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream os = new ObjectInputStream(fis);
			return (ArrayList<T>) os.readObject();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EOFException e) {
			return new ArrayList<T>();
		} 
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ArrayList<T>();
	}
	
	public static <T> void savedata(ArrayList<T> items, String file) {
		try {
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(items);
			oos.writeObject(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
