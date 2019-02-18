//current package 
package core.java.core_questions;
//import scanner class
import java.util.Scanner;
//create class for question 5
public class question5 {
	//constructor
	question5(){
		super();
	}
	//static method to split a string at a determined index 
	//no String, StringBuilder or Stringbuilder APIs where used
	public static String stringSplit(String str, int idx) {
		if(str.isEmpty() || idx > str.length()) {
			System.out.print("Error: Either you string is empty or " + 
						"your substring index is larger than the size of the string");
			return "";
		}
		
		String new_string = "";
		for(int i = 0; i < str.length(); i++) {
			if(i == idx)
				break;
			new_string += str.charAt(i); 
		}
		return new_string; 	
	}
	//main method
	public static void main(String[] args) {
		//input your string
		 Scanner s = new Scanner(System.in);
		    System.out.println("Enter String:");
		    String name = s.next();
		    //input your substring index
		    System.out.println("Now, Enter substring integer:");
		    int num = s.nextInt();
		    //print the substring
		    System.out.println(stringSplit(name, num));
		    //close scanner
		    s.close();
	}
}
