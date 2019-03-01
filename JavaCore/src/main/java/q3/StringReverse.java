// David Lavoie Revature Assignment 1 Q3
package q3;

public class StringReverse {

	/**
	 * Take in a string, append each character in the string to the end of the string in reverse order
	 * Then take the substring starting from the original length of the string
	 * @param myString
	 * @return
	 */
	static String reverse(String myString) {
		for (int i = myString.length() - 1; i >= 0; i--) {
			myString += myString.charAt(i);
		}
		myString = myString.substring(myString.length()/2);
		return myString;
	}
	
	public static void main(String[] args) {
		String forward = "Nascar"; 
		String backward = reverse(forward);
		System.out.println(forward);
		System.out.println(backward);
	}
}
