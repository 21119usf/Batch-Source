package first.half.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import first.half.PrimeNumbers;

class PrimeNumbersTest {

	@Test
	void isPrimeTest() {
		assertTrue(PrimeNumbers.isPrime(5));
		assertTrue(PrimeNumbers.isPrime(7));
		assertTrue(PrimeNumbers.isPrime(11));
		assertTrue(PrimeNumbers.isPrime(73));
		assertFalse(PrimeNumbers.isPrime(70));
		assertFalse(PrimeNumbers.isPrime(6));
		assertFalse(PrimeNumbers.isPrime(15));
		assertFalse(PrimeNumbers.isPrime(2));
	}

}
