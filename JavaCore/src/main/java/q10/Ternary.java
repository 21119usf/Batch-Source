// David Lavoie Revature Assignment 1 Q10
package q10;

public class Ternary {

	/**
	 * the format for ternary operator is object name = (conditional) ? (argument 1) : (argument 2)
	 * and name will return argument 1 if true and argument 2 if false
	 * @param args
	 */
	public static void main(String[] args) {
		int x = 5;
		int y = 2;
		int min_value = (x < y) ? ( x ) : ( y );
		System.out.println(min_value);

	}

}
