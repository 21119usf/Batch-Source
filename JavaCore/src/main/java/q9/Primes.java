// David Lavoie Revature Assignment 1 Q9
package q9;

import java.util.ArrayList;

public class Primes {
	/**
	 * returns an ArrayList<Integer> of all primes less than int n.
	 * The ArrayList is constructed via the standard prime builder algorithm, i.e.
	 * start with the seed prime (2)
	 * for each number i from 2 to the target, check if i%p == 0 for each p in prime
	 * if this is true, i isn't prime, move on
	 * if this is not true for the entire set of primes constructed so far, add i to the set of primes
	 * 
	 * @param n
	 * @return
	 */
	static ArrayList<Integer> printPrimes(int n) {
		ArrayList<Integer> Z = new ArrayList<Integer>();
		ArrayList<Integer> P = new ArrayList<Integer>();
		Z.add(1);
		P.add(2);
		for (int i = 2; i <= n; i++) {
			Z.add(i);
			boolean isP = true;
			for(Integer p: P) {
				if (i % p == 0) {
					isP = false;	
				}
			} if (isP) {
				P.add(i);
			}
		}
		for(Integer p: P) {
			System.out.println(p);
		}
		return Z;
	}
	// do the specific thing requested in the assignment statement
	public static void main(String[] args) {
		ArrayList<Integer> myArray = printPrimes(100);
		System.out.println("\n" + myArray.size());
	}
}
