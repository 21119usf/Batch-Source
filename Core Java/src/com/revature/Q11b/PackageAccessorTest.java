package com.revature.Q11b;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

class PackageAccessorTest {

	@BeforeAll
	static void beforeAll(){
		System.out.println("Testing Question 11...");
	}
	
	@BeforeEach
	void beforeEach(TestInfo info) {
		System.out.println("Initializing data for: "+info.getDisplayName());

	}

	@Test
	@DisplayName("check f1")
	void f1() {
		assert(2.4f == PackageAccessor.f1());
	}
	@Test
	@DisplayName("check f2")
	void f2() {
		assert(3.4f == PackageAccessor.f2());
	}

}
