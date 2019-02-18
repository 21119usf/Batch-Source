package com.revature.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import com.revature.beans.Person;

public class IOWithCollectons {
	private static final String personFile = "person.txt"; 
	public static ArrayList<Person> personList = new ArrayList<Person>(); 
	
	public static void writePersonFile() {
		try {
		ObjectInputStream objectOut = new ObjectInputStream (new FileOutputStream(personfile)); 
		objectOut.writeObject(personList); 
		objectOut.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void readPersonFile() {
		ObjectInputStream objectIn;
		try {
		objectIn = new ObjectInputStream(new FileInputStream(personFile));
		personList = (ArrayList<Person>)objectIn.readObject();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
