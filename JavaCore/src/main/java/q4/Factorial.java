// David Lavoie Revature Assignment 1 Q4
package q4;

import java.util.Scanner;

public class Factorial {
	/**
	 * N! = 1 * 2 * ... * N
	 * I was very tempted to import org.apache.commons.math3.special.Gamma
	 * and just run Gamma(n+1) to pass in doubles. But this will suffice for
	 * integer arguments
	 * @param n
	 * @return
	 */
	static int factorial(int n) {
		int base = 1;
		for (int i = 1; i <= n; i++) {
			base = base * i;
		}
		return base;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		System.out.println(factorial(a));
		in.close();
	}
}
