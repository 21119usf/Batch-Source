package com.revature.Q7;


import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;



class sortByTest {

	@BeforeAll
	static void beforeAll(){
		System.out.println("Testing Question 7...");
	}
	@BeforeEach
	void beforeEach(TestInfo info) {
		System.out.println("Initializing data for: "+info.getDisplayName());
	}
	static ArrayList<Employee> actual = new ArrayList<Employee>();
	static {actual.addAll(Arrays.asList(new Employee[] {
			new Employee("Mark","Accounting",22),
			new Employee("Megan","HR",27),
			new Employee("Gerry","Engineering",30),
			new Employee("Garett","Quality Control",26)
	}));}

	@Test
	@DisplayName("check sortByName")
	void sortByName() {
		ArrayList<Employee> expected = new ArrayList<Employee>();
		expected.addAll(Arrays.asList(new Employee[] {
				new Employee("Garett","Quality Control",26),
				new Employee("Gerry","Engineering",30),
				new Employee("Mark","Accounting",22),
				new Employee("Megan","HR",27)				
		}));
		Driver.sortByName(actual);
		assertEquals(expected,actual);
	}
	
	@Test
	@DisplayName("check sortByDepartment")
	void sortByDepartment() {
		ArrayList<Employee> expected = new ArrayList<Employee>();
		expected.addAll(Arrays.asList(new Employee[] {
				new Employee("Mark","Accounting",22),
				new Employee("Gerry","Engineering",30),
				new Employee("Megan","HR",27),
				new Employee("Garett","Quality Control",26)
		}));
		Driver.sortByDepartment(actual);
		assertEquals(expected,actual);
	}
	
	@Test
	@DisplayName("check sortByAge")
	void sortByAge() {
		ArrayList<Employee> expected = new ArrayList<Employee>();
		expected.addAll(Arrays.asList(new Employee[] {
				new Employee("Mark","Accounting",22),
				new Employee("Garett","Quality Control",26),
				new Employee("Megan","HR",27),
				new Employee("Gerry","Engineering",30),
		}));
		Driver.sortByAge(actual);
		assertEquals(expected,actual);
	}

}
