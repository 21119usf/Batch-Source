package first.half.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import first.half.BubbleSort;

class BubbleSortTest {

	@Test
	@DisplayName("Check bubble sort method for integers")
	void sortTest() {
		Integer[] start = {10,2,8,1,4,0};
		Integer[] result = BubbleSort.sort(start);
		Integer[] expected = {0,1,2,4,8,10};
		
		for(int i = 0; i < result.length; i++) {
			assertEquals(expected[i], result[i]);
		}
	}
	
	@Test
	@DisplayName("Check bubble sort method for integers with required data")
	void sortTestWithRequiredData() {
		Integer[] start = {1,0,5,6,3,2,3,7,9,8,4};
		Integer[] result = BubbleSort.sort(start);
		Integer[] expected = {0,1,2,3,3,4,5,6,7,8,9};
		
		for(int i = 0; i < result.length; i++) {
			assertEquals(expected[i], result[i]);
		}
	}

}
