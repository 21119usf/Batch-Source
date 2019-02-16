package homework1;
//DONE
import java.util.Scanner;

public class Q03 {
	//Reverse a string without using a temporary variable.
	//Do NOT use reverse() in the StringBuffer or the StringBuilder APIs.
	public static String recursiveReverse(String s) {
		if (s.length() == 1)
			return s;
		else
			return recursiveReverse(s.substring(1)) + s.charAt(0);
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Please input a string to reverse: ");
		String string = input.nextLine();
		
		System.out.println(recursiveReverse(string));
		input.close();
	}
}
