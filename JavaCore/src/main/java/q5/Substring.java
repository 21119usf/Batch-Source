// David Lavoie Revature Assignment 1 Q5
package q5;

public class Substring {
	/**
	 * Append each character in myString from 0 to len - 1 to a blank String, then return that String
	 * @param myString
	 * @param len
	 * @return
	 */
	static String substring(String myString, int len) {
		String fu = "";
		for (int i = 0; i < len; i++) {
			fu += myString.charAt(i);
		}
		return fu;
	}
	
	public static void main(String[] args) {
		String test = "This is a test";
		System.out.println(substring(test,6));
	}
	

}
