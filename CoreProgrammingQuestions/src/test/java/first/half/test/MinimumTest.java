package first.half.test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import first.half.Minimum;

class MinimumTest {

	@Test
	void minimumOfTest() {
		assertEquals(5, Minimum.minimumOf(10,5));
		assertEquals(0, Minimum.minimumOf(0,1));
		assertEquals(-1, Minimum.minimumOf(-1,0));
	}

}
