package first.half.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import first.half.EvenOrNot;

class EvenOrNotTest {

	@Test
	void isEvenTest() {
		assertFalse(EvenOrNot.isEven(5));
		assertFalse(EvenOrNot.isEven(2341));
		assertFalse(EvenOrNot.isEven(1));
		assertFalse(EvenOrNot.isEven(987));
		assertTrue(EvenOrNot.isEven(0));
		assertTrue(EvenOrNot.isEven(2));
		assertTrue(EvenOrNot.isEven(2632));
	}

}
