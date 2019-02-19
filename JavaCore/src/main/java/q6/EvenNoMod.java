// David Lavoie Revature Assignment 1 Q6
package q6;

public class EvenNoMod {

	/**
	 * Hardcoding the modulus operator n%i involves a while loop, substracting i from n until n < i
	 * Since we are specifically checking if a number is even, we simply check if n 
	 * @param n
	 * @return
	 */
	static boolean isEven(int n) {
		if (n < 0) {
			n = n * -1;
		}
		while (n > 2) {
			n += -2;
		}
		if (n == 1) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(isEven(12));
		System.out.println(isEven(13));
		System.out.println(isEven(-2));
		System.out.println(isEven(-1));
		System.out.println(isEven(0));
		System.out.println(isEven(1));
	}
}
