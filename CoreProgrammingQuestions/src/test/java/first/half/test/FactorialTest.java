package first.half.test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import first.half.Factorial;

class FactorialTest {

	@Test
	void factorialOfTest() {
		assertEquals(120, Factorial.factorialOf(5));
		assertEquals(24, Factorial.factorialOf(4));
	}

}
