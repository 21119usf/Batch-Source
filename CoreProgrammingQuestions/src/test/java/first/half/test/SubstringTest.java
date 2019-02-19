package first.half.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import first.half.Substring;

class SubstringTest {

	@Test
	void test() {
		String start = "start";
		String result = Substring.getSubstring(start, 3);
		assertEquals("sta", result);
	}

}
