package com.revature.junit5;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import beans.Bank;

class BankingTests {
	public static Bank bank = new Bank();
	
	@BeforeEach
	void beforeEach(TestInfo info) {
		System.out.println("Initialize data for " + info.getDisplayName());
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

	@Test
    public void testEmptyCollection() {
        Collection collection = new ArrayList();
        assertTrue(collection.isEmpty());
    }
}
