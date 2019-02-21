//current package
package core.java.core_questions;
//import Scanner class
import java.util.Scanner;
//created a public class for question 6
public class question6 {
	//constructor
	question6(){
		super();
	}
	//this method checks is an integer is even or odd
	public static void isEven(int n) {
		//convert integer to string
		String n_string = "" + n; 
		//check the length of the string
		if(n_string.length() != 0) {
		//store the last char of the string
		//if last char has an even value, then the string its an even value
		char last_digit = n_string.charAt(n_string.length() - 1); 
		//this switch condition will print if the number is odd or even
		 switch (last_digit){
	        case '0':
	          System.out.println("This number is even");
	          break;
	        case '2':
	          System.out.println("This number is even");
	          break;
	        case '4':
	          System.out.println("This number is even");
	          break;
	        case '6':
	          System.out.println("This number is even");
	          break;
	        case '8':
	          System.out.println("This number is even");
	          break;
	        default:
	          System.out.println("This number is odd!!");
	      }
		}
	}
	//main method to perform our program
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//input a number
		Scanner s = new Scanner(System.in);
	    System.out.println("Enter number:");
	    int n = s.nextInt();
	    //check if the number is even or odd
	    isEven(n);
	    s.close();
	}

}
