import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.revature.utilities.ParseString;
import com.revature.utilities.Validation;

class JUnitTest {

	@Test
	void isLessThanZeroTest() {
		assertTrue(Validation.isLessThanZero(-1));
	}
	
	@Test
	void isLessThanZeroTest1() {
		assertFalse(Validation.isLessThanZero(1));
	}
	
	@Test
	void parseD1() {
		assertEquals(Double.NEGATIVE_INFINITY, ParseString.parseD("a"));
	}
	
	@Test
	void parseD2() {
		assertEquals(1.0, ParseString.parseD("1"));
	}
	
	@Test
	void parseI1() {
		assertEquals(Integer.MIN_VALUE, ParseString.parseI("a"));
	}
	
	@Test
	void parseI2() {
		assertEquals(1, ParseString.parseI("1"));
	}
}
