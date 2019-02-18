package homework1;
//DONE, but try to get it to work on command prompt
public class Q16 {
	//Write a program to display the number of characters for a string input.
	//The string should be entered as a command line argument using (String [ ] args).
	public static void main(String[] args) {
		//My input string is 'pneumonoultramicroscopicsilicovolcanoconi osis'
		System.out.println("There are " + args[0].length() + " characters in this string");
	}
}
