package com.bankapp.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.bankapp.account.Account;
import com.bankapp.dao.AccountDaoImp;
import com.bankapp.dao.CustomerAccountDaoImp;
import com.bankapp.dao.CustomerDaoImp;
import com.bankapp.dao.EmployeeDaoImp;
import com.bankapp.user.Customer;
import com.bankapp.user.Employee;

class BankAppTest {
	private static Account account;
	private static Customer customer;
	private static Employee employee;
	private static AccountDaoImp adi;
	private static CustomerAccountDaoImp cadi;
	private static CustomerDaoImp cdi;
	private static EmployeeDaoImp edi;
	
	// Initialize objects
	// =========================================================================
	@BeforeAll
	static void beforeAll() {
		adi = new AccountDaoImp();
		cadi = new CustomerAccountDaoImp();
		cdi = new CustomerDaoImp();
		edi = new EmployeeDaoImp();
		
		customer = new Customer(
			"testUser", "testPass", "Test", "Test", "test@test.com", 
			8135555555L
		);
		employee = new Employee("testEmployee", "testPass");
		account = new Account();
		account.setOpen(true);
	}
	
	// Testing Employee Class
	// =========================================================================
	@Test
	void insertEmployeeTest() {
		try {
			edi.addEmployee(employee);
			Employee e = edi.getEmployee(employee.getUsername());
			assertEquals(employee.getId(), e.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@After
	void afterInsertEmployeeTest() {
		try {
			edi.deleteEmployee(employee);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// Testing Customer Class
	// =========================================================================
	@Test
	void insertCustomerTest() {
		try {
			cdi.addCustomer(customer);
			Customer c = cdi.getCustomer(customer.getUsername());
			assertEquals(customer.getId(), c.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@After
	void afterInsertCustomerTest() {
		try {
			cdi.deleteCustomer(customer);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// Testing Account Class
	// =========================================================================
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
		Account account2 = new Account();
		account2.setOpen(true);
		double amount = 10.00;
		double expected = 10.00;
		if (account.transfer(account2, amount)) {
			assertEquals(account2.getBalance(), expected);
		} else {
			assertEquals(0.00, account2.getBalance());
		}
	}
}
