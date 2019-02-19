package first.half.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import first.half.Fibonacci;

class FibonacciTest {

	@Test
	void nextFibonacciTest() {
		assertEquals(Fibonacci.nextFibonacci(0), 0);
		assertEquals(Fibonacci.nextFibonacci(2), 1);
		assertEquals(Fibonacci.nextFibonacci(3), 2);
		assertEquals(Fibonacci.nextFibonacci(11), 89);
		assertEquals(Fibonacci.nextFibonacci(25), 75025);
		
		
	}

}
