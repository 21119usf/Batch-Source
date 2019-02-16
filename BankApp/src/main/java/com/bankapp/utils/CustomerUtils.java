package com.bankapp.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.bankapp.person.Customer;

public class CustomerUtils {
	public static String customersFile = "Customers.ser";
	public static ArrayList<Customer> customers = new ArrayList<Customer>();
	
	// Load customers from file
	@SuppressWarnings("unchecked")
	public static void loadCustomers() {
		try {
			FileInputStream cf = new FileInputStream(customersFile);
			ObjectInputStream ois = new ObjectInputStream(cf);
			customers = (ArrayList<Customer>)ois.readObject();
			ois.close();
			cf.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	// Save customers to file
	public static void saveCustomers() {
		try {
			FileOutputStream cf = new FileOutputStream(customersFile);
			ObjectOutputStream oos = new ObjectOutputStream(cf);
			oos.writeObject(customers);
			oos.close();
			cf.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
