//Q13. Display the triangle on the console as follows using any type of loop. Do NOT use a
//simple group of print statements to accomplish this.
//0
//1 0
//1 0 1
//0 1 0 1

package com.revature.cja;

public class DisplayTriangle {
	
	// method to display 0 and 1 triangle
	public void displayTriangle () {
		int numRows = 4;
		boolean bool = true;
		
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < i + 1; j++) {
				if (bool) {
					System.out.print(0 + " ");
					bool = false;
				} else {
					System.out.print(1 + " ");
					bool = true;
				}
			}
			System.out.println();
		}
	}
}
