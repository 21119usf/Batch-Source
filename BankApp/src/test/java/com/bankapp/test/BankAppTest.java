package com.bankapp.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.bankapp.account.Account;
import com.bankapp.user.Customer;
import com.bankapp.user.Employee;

class BankAppTest {
	private static Account account;
	private static Customer customer;
	private static Employee employee;
	
	// Initialize objects
	// =========================================================================
	@BeforeAll
	static void beforeAll() {
		customer = new Customer(
			"username", "password", "first", "last", "email", 
			8135555555L, 938763232L);
		employee = new Employee("username", "password", "first", "last");
		account = new Account(customer);
		account.setOpen(true);
	}
	
	// Testing Account Class
	// =========================================================================
	@SuppressWarnings("unchecked")
	@Test
	void accountFileIOTest() {
		String testFile = "test.ser";
		File file = new File(testFile);
		ArrayList<Account> alOut = new ArrayList<Account>();
		alOut.add(account);
		try {
			FileOutputStream af = new FileOutputStream(testFile);
			ObjectOutputStream oos = new ObjectOutputStream(af);
			oos.writeObject(alOut);
			oos.close();
			af.close();
		} catch (FileNotFoundException e) {
			// e.printStackTrace();
		} catch (IOException e) {
			// e.printStackTrace();
		}
		ArrayList<Account> alIn = new ArrayList<Account>();
		try {
			FileInputStream af = new FileInputStream(testFile);
			ObjectInputStream ois = new ObjectInputStream(af);
			alIn = (ArrayList<Account>)ois.readObject();
			ois.close();
			af.close();
		} catch (FileNotFoundException e) {
			// e.printStackTrace();
		} catch (IOException e) {
			// e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// e.printStackTrace();
		}
		assertEquals(alOut.get(0).toString(), alIn.get(0).toString());
		file.delete();
	}
	@Test
	void depositTest() {
		account.setBalance(0.00);
		double amount = 20.00;
		double expected = 20.00;
		if (account.deposit(amount)) {
			assertEquals(expected, account.getBalance());
		} else {
			assertEquals(0.0, account.getBalance());
		}
	}
	@Test
	void withdrawTest() {
		account.setBalance(100.00);
		double amount = 10.00;
		double expected = 90.00;
		if (account.withdraw(amount)) {
			assertEquals(expected, account.getBalance());
		} else {
			assertEquals(100.00, account.getBalance());
		}
	}
	@Test
	void transferTest() {
		account.setBalance(100.00);
		Customer customer2;
		customer2 = new Customer(
				"username", "password", "first", "last", "email", 
				8135555555L, 938763232L);
		Account account2 = new Account(customer2);
		account2.setOpen(true);
		double amount = 10.00;
		double expected = 10.00;
		if (account.transfer(account2, amount)) {
			assertEquals(account2.getBalance(), expected);
		} else {
			assertEquals(0.00, account2.getBalance());
		}
	}
	@Test
	void willOverdrawTest() {
		account.setBalance(0.00);
		double amount = 10.00;
		assertEquals(true, account.willOverdraw(amount));
	}
	
	// Testing Customer Class
	// =========================================================================
	@SuppressWarnings("unchecked")
	@Test
	void customerFileIOTest() {
		String testFile = "test.ser";
		File file = new File(testFile);
		ArrayList<Customer> alOut = new ArrayList<Customer>();
		alOut.add(customer);
		try {
			FileOutputStream af = new FileOutputStream(testFile);
			ObjectOutputStream oos = new ObjectOutputStream(af);
			oos.writeObject(alOut);
			oos.close();
			af.close();
		} catch (FileNotFoundException e) {
			// e.printStackTrace();
		} catch (IOException e) {
			// e.printStackTrace();
		}
		ArrayList<Customer> alIn = new ArrayList<Customer>();
		try {
			FileInputStream af = new FileInputStream(testFile);
			ObjectInputStream ois = new ObjectInputStream(af);
			alIn = (ArrayList<Customer>)ois.readObject();
			ois.close();
			af.close();
		} catch (FileNotFoundException e) {
			// e.printStackTrace();
		} catch (IOException e) {
			// e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// e.printStackTrace();
		}
		assertEquals(alOut.get(0).toString(), alIn.get(0).toString());
		file.delete();
	}
	
	// Testing Employee Class
	// =========================================================================
	@SuppressWarnings("unchecked")
	@Test
	void employeeFileIOTest() {
		String testFile = "test.ser";
		File file = new File(testFile);
		ArrayList<Employee> alOut = new ArrayList<Employee>();
		alOut.add(employee);
		try {
			FileOutputStream af = new FileOutputStream(testFile);
			ObjectOutputStream oos = new ObjectOutputStream(af);
			oos.writeObject(alOut);
			oos.close();
			af.close();
		} catch (FileNotFoundException e) {
			// e.printStackTrace();
		} catch (IOException e) {
			// e.printStackTrace();
		}
		ArrayList<Employee> alIn = new ArrayList<Employee>();
		try {
			FileInputStream af = new FileInputStream(testFile);
			ObjectInputStream ois = new ObjectInputStream(af);
			alIn = (ArrayList<Employee>)ois.readObject();
			ois.close();
			af.close();
		} catch (FileNotFoundException e) {
			// e.printStackTrace();
		} catch (IOException e) {
			// e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// e.printStackTrace();
		}
		assertEquals(alOut.get(0).toString(), alIn.get(0).toString());
		file.delete();
	}
}
