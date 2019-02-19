package test.beans;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import banking.beans.Admin;
import banking.beans.Customer;
import banking.beans.Employee;
import banking.beans.Session;

class SessionTest {

	@Test
	void beforeActionsTest() {
		Session.currentSession().Login(new Employee());
		assertTrue(Session.currentSession().employeeIsLoggedIn());
		assertTrue(Session.currentSession().userIsLoggedIn());
		assertFalse(Session.currentSession().adminIsLoggedIn());
		assertFalse(Session.currentSession().customerIsLoggedIn());
		
		Session.currentSession().Login(new Customer());
		assertFalse(Session.currentSession().employeeIsLoggedIn());
		assertTrue(Session.currentSession().userIsLoggedIn());
		assertFalse(Session.currentSession().adminIsLoggedIn());
		assertTrue(Session.currentSession().customerIsLoggedIn());
		
		Session.currentSession().Login(new Admin());
		assertFalse(Session.currentSession().employeeIsLoggedIn());
		assertTrue(Session.currentSession().userIsLoggedIn());
		assertTrue(Session.currentSession().adminIsLoggedIn());
		assertFalse(Session.currentSession().customerIsLoggedIn());
	}

}
