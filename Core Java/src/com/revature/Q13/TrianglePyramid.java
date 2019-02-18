package com.revature.Q13;

public class TrianglePyramid {
	public static final int NUM_LINES = 4;		//Set number of lines for pyramid
	
	public static void main(String[] args) {
		printPyramid();							//print the great pyramid of binary
	}
	/*printPyramid
	 * Input	: none
	 * Output	: void
	 * Algo		: A each pass of the while loop either a 0 or 1 is printed based
	 * 			  on boolean boo. If boo is false print 0, true 1. if the line 
	 * 			  counter is the same as the numbers in the line we go to the next line
	 * 			  and reset our numbers in line counter. This occurs until our line 
	 * 			  counter is equal to the number of line 
	 * 			  constant. 
	 */
	public static void printPyramid() {
		int lineCounter = 1;
		int numsInLine = 0;
		boolean boo = false;
		while(lineCounter <= NUM_LINES) {
			if(!boo) {
				System.out.print("0 ");
				boo = true;
			}
			else {
				System.out.print("1 ");
				boo = false;
			}
			numsInLine++;
			if(numsInLine == lineCounter) {
				System.out.println();
				numsInLine = 0;
				lineCounter++;
			}
		}
	}

}
