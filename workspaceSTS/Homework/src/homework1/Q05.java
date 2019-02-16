package homework1;
//DONE
import java.util.Scanner;

public class Q05 {
	//Write a substring method that accepts a string str and an
	//integer idx and returns the substring contained between 0 and idx-1 inclusive.
	//Do NOT use any of the existing substring methods in the String,
	//StringBuilder, or StringBuffer APIs.
	
	public static String substring(String str, int idx) {
		String output = "";
		if (idx > str.length())
			idx = str.length();
		for (int index = 0; index < idx; index++) {
			output += str.charAt(index);
		}
		return output;
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Please input a string to modify: ");
		String string = input.nextLine();
		
		System.out.print("Please input how many characters to read from the entered string: ");
		int numOfChars = input.nextInt();
		
		
		System.out.println(substring(string, numOfChars));
		input.close();
	}
}
