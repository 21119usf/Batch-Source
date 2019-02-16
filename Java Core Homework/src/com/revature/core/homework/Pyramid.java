package com.revature.core.homework;

// #13
public class Pyramid {
	// makes a 01 sequence pyramid based on number of n rows
	public static String makePyramid(int rows) {
		// string to populate pyramid
		String pyramid = "";
		// current row counter
		int currentRow = 1;
		// flag used to keep track of 0 (true) or 1 (false)
		boolean isFirstSeries = true;
		// loop until last row is populated
		while (currentRow <= rows) {
			// reverse flag each iteration after storing 1 or 0
			for (int i = 1; i <= currentRow; i++) {
				if (isFirstSeries) {
					pyramid += "0";
					isFirstSeries = false;
				} else {
					pyramid += "1";
					isFirstSeries = true;
				}
			}
			// at end of row move to next
			currentRow++;
			if (currentRow <= rows) {
				// add endline after pyramid
				pyramid += "\n";
			}
		}
		return pyramid;
	}
	
	public static void main(String[] args) {
		String result = Pyramid.makePyramid(4);
		System.out.println(result);
	}
}
