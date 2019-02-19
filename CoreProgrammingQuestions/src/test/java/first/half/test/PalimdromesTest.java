package first.half.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import first.half.Palindromes;

class PalimdromesTest {

	@Test
	void isPalimdromeTest() {
		
		assertTrue(Palindromes.isPalimdrome("ehe"));
		assertTrue(Palindromes.isPalimdrome("racecar"));
		assertFalse(Palindromes.isPalimdrome("tdrgsfrefsd"));
		assertFalse(Palindromes.isPalimdrome("cat"));
		
	}

}
