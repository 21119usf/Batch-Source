package com.revature.test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.SQLException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.reavture.beans.User;
import com.reavture.beans.UserRole;
import com.revature.utilities.DAOUtilities;

class UserDAOTest {
	
	User u;
	@BeforeAll
	void setupUser() {
		u = new User();
		u.setUsername("Testtest");
		u.setHash("testtset");
		u.setFirstName("testtest");
		u.setSSN("123456789");
		u.setEmail("test@test.com");
		u.setRole(UserRole.customer);
	}

	@Test
	void createUser() {
		try {
			DAOUtilities.getUserDAO().createUser(u);
		} catch (SQLException e) {
			fail(e);
		}
	}
	
	@Test 
	void getUser() {
		try {
			User u2 = DAOUtilities.getUserDAO().getUser(u.getId());
			assertTrue(u.equals(u2));
		} catch (SQLException e) {
			fail(e);
		}
	}

}
