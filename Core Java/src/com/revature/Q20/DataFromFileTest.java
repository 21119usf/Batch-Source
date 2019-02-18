package com.revature.Q20;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

class DataFromFileTest {

	static ArrayList<Person> expected = new ArrayList<Person>();
	static {expected.addAll(Arrays.asList(new Person[] {
		new Person("Mickey","Mouse",35,"Arizona"),
		new Person("Hulk","Hogan",50,"Virginia"),
		new Person("Roger","Rabbit",22,"California"),
		new Person("Wonder","Woman",18,"Montana")
	}));}
	static ArrayList<String> p = new ArrayList<String>();
	static {p.addAll(Arrays.asList(new String[] {
			"Mickey:Mouse:35:Arizona",
			"Hulk:Hogan:50:Virginia",
			"Roger:Rabbit:22:California",
			"Wonder:Woman:18:Montana"
		}));}
	
	@BeforeAll
	static void beforeAll(){
		System.out.println("Testing Question 20...");
	}
	@BeforeEach
	void beforeEach(TestInfo info) {
		System.out.println("Initializing data for: "+info.getDisplayName());
	}
	@Test
	@DisplayName("check createPeople")
	void createPeople() {
		ArrayList<Person> actual = DataFromFile.createPeople(p);
		assertEquals(expected, actual);
	}

}
