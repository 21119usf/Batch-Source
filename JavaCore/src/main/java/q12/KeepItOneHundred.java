// David Lavoie Revature Assignment 1 Q12
package q12;

public class KeepItOneHundred {
	/**
	 * makes an array of integers from 1 to n stored in ascending order
	 * @param n
	 * @return
	 */
	static int[] range(int n) {
		int[] fu = new int[n];
		for(int i = 0; i<n; i++) {
			fu[i] = i+1;
		}
		return fu;
	}
	
	public static void main(String[] args) {
		int[] arrrg = range(100);
		for(int r: arrrg) {
			if (r%2 == 0) {
				System.out.println(r);
			}
		}
	}
}
