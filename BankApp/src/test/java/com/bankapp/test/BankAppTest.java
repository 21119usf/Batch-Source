package com.bankapp.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.bankapp.account.Account;
import com.bankapp.dao.AccountDaoImp;
import com.bankapp.dao.CustomerDaoImp;
import com.bankapp.dao.EmployeeDaoImp;
import com.bankapp.user.Customer;
import com.bankapp.user.Employee;

class BankAppTest {
	private static Account account;
	private static Customer customer;
	private static Employee employee;
	private static AccountDaoImp adi;
	private static CustomerDaoImp cdi;
	private static EmployeeDaoImp edi;
	
	// Initialize objects
	// =========================================================================
	@BeforeAll
	static void beforeAll() {
		adi = new AccountDaoImp();
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
	@AfterAll
	static void afterAll() {
		try {
			adi.deleteAccount(account);
			cdi.deleteCustomer(customer);
			edi.deleteEmployee(employee);
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
	@Test
	void updateEmployeeTest() {
		String password = "newPassword";
		try {
			edi.addEmployee(employee);
			employee.setPassword(password);
			edi.updateEmployee(employee);
			Employee e = edi.getEmployee(employee.getUsername());
			assertEquals(password, e.getPassword());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@After
	void afterUpdateEmployeeTest() {
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
	@Test
	void updateCustomerTest() {
		String password = "newPassword";
		try {
			cdi.addCustomer(customer);
			customer.setPassword(password);
			cdi.updateCustomer(customer);
			Customer c = cdi.getCustomer(customer.getUsername());
			assertEquals(password, c.getPassword());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@After
	void afterUpdateCustomerTest() {
		try {
			cdi.deleteCustomer(customer);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// Testing Account Class
	// =========================================================================
	/*@Test
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
	}*/
	@Test
	void insertAccountTest() {
		try {
			adi.addAccount(account);
			Account a = adi.getAccount(account.getId());
			assertEquals(account.getId(), a.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@After
	void afterInsertAccountTest() {
		try {
			adi.deleteAccount(account);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Test
	void updateAccountTest() {
		double balance = 100.00;
		try {
			adi.addAccount(account);
			account.setBalance(balance);
			adi.updateAccount(account);
			Account a = adi.getAccount(account.getId());
			assertEquals(balance, a.getBalance());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@After
	void afterUpdateAccountTest() {
		try {
			adi.deleteAccount(account);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
