package test.beans;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import banking.beans.Customer;

class CustomerTest {

	@Test
	void customerConstructorTest() {
		Customer newcus = new Customer("name", "owner");
		assertTrue(newcus != null);
	}
	
	@Test
	void validCustomerNameTest() {
		assertFalse(Customer.validUsername("inva"));
		assertTrue(Customer.validUsername("validname"));
	}
	
	@Test
	void validPasswordTest() {
		assertFalse(Customer.validPassword("inva"));
		assertTrue(Customer.validPassword("validpassword"));
	}

}
