// David Lavoie Revature Assignment 1 Q2
package q2;

import java.util.Arrays;

public class Fibonacci {
	/**
	 *  fibonacci sequence starts 0,1, then folows the rule that x_n = x_(n-1) + x_(n-2)
	 * @param size
	 * @return
	 */
	public static int[] fibonacci(int size) {
		int[] mySequence = new int[size];
		mySequence[0] = 0;
		mySequence[1] = 1;
		for (int n = 2; n < size; n++) {
			mySequence[n] = mySequence[n-1] + mySequence[n-2];	
			}
		
		return mySequence;
	}

	public static void main(String[] args) {
		int[] fu = fibonacci(12);
		System.out.println(Arrays.toString(fu));
	}

}
