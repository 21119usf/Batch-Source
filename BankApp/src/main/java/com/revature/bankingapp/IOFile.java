package com.revature.bankingapp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class IOFile {//userfile, accountfile, applicationfile
		
	private static final String applicationFile="ApplicationInfo.txt";
	public static ArrayList<Individual> individualApplication = new ArrayList<Individual>();
	public static ArrayList<Joint> jointApplication = new ArrayList<Joint>();
		
	public static void writeApplicationFile() {
		try {
			ObjectOutputStream objectOut= new ObjectOutputStream(new FileOutputStream(applicationFile));
			objectOut.writeObject(individualApplication);
			objectOut.writeObject(jointApplication);
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
	public static void readApplicationFile() {
		ObjectInputStream objectIn;
		try {
			objectIn = new ObjectInputStream(new FileInputStream(applicationFile));
			individualApplication=(ArrayList<Individual>)objectIn.readObject();
			jointApplication=(ArrayList<Joint>)objectIn.readObject();
			objectIn.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static final String accountFile="AccountInfo.txt";
	public static ArrayList<Individual> individualList = new ArrayList<Individual>();
	public static ArrayList<Joint> jointList = new ArrayList<Joint>();
	
	public static void writeAccountFile() {
		try {
			ObjectOutputStream objectOut= new ObjectOutputStream(new FileOutputStream(accountFile));
			objectOut.writeObject(individualList);
			objectOut.writeObject(jointList);
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
	public static void readAccountFile() {
		ObjectInputStream objectIn;
		try {
			objectIn = new ObjectInputStream(new FileInputStream(accountFile));
			individualList=(ArrayList<Individual>)objectIn.readObject();
			jointList=(ArrayList<Joint>)objectIn.readObject();
			objectIn.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static final String userFile="UserInfo.txt";
	public static ArrayList<Customer> userCust = new ArrayList<Customer>();
	public static ArrayList<Admin> userAdmin = new ArrayList<Admin>();
	public static ArrayList<Employee> userEmp = new ArrayList<Employee>();
	
	public static void writeUserFile() {
		try {
			ObjectOutputStream objectOut= new ObjectOutputStream(new FileOutputStream(userFile));
			objectOut.writeObject(userCust);
			objectOut.writeObject(userAdmin);
			objectOut.writeObject(userEmp);
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
	public static void readUserFile() {
		ObjectInputStream objectIn;
		try {
			objectIn = new ObjectInputStream(new FileInputStream(userFile));
			userCust=(ArrayList<Customer>)objectIn.readObject();
			userAdmin=(ArrayList<Admin>)objectIn.readObject();
			userEmp=(ArrayList<Employee>)objectIn.readObject();
			objectIn.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}