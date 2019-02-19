// David Lavoie Revature Assignment 1 Q19
package q19;

import java.util.ArrayList;

public class IntArrayList {

	// I did this whole problem in main, their didn't seem to be many
	// opportunities to classify the behavior 
	public static void main(String[] args) {
		// Initialize ArrayList
		ArrayList<Integer> ten = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			ten.add(i+1);
		}
		// Print ArrayList
		System.out.println("Array List: ");
		for(int i: ten) {
			System.out.print(" " + i);
		}
		// initialize sum of the even numbers
		int sum = 0;
		for (int i: ten) {
			if (i % 2 == 0) {
				sum += i;
			}
		}
		System.out.println("\n\nSum of the Even numbers: " + sum);
		
		sum = 0;
		for (int i: ten) {
			if (i % 2 != 0) {
				sum += i;
			}
		}
		System.out.println("\n\nSum of the Odd numbers: " + sum);
		
		ArrayList<Integer> P = new ArrayList<Integer>();
		P.add(2);
		for (int i = 2; i <= 10; i++) {
			boolean isP = true;
			for(Integer p: P) {
				if (i % p == 0) {
					isP = false;	
				}
			} if (isP) {
				P.add(i);
			}
		}
		
		for (Integer p: P) {
			ten.remove(p);
		}
				
		System.out.println("\n\n NonPrimes:");
		for(int i: ten) {
			System.out.print(" " + i);
		}
	}
	
}
