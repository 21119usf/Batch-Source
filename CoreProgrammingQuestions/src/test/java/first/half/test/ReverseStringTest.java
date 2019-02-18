package first.half.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import first.half.ReverseString;

class ReverseStringTest {

	@Test
	void reverseStringTest() {
		
		String start = "start";
		String result = ReverseString.reverseString(start);
		assertEquals("trats", result);
		
		
	}

}
