//current package 
package core.java.core_questions;
//import scanner
import java.util.Scanner;
//create you class for question4
public class question4 {
	//create you constructor
	question4(){
		super();
	}
	//method to get the factorial from any positive number
	public static int nFactorial(int num) {
		if(num < 0) 
			return 0;
		if(num == 1 || num == 0)
			return num; 
		return num*nFactorial(num-1);
	}
	//main method 
	public static void main(String[] args) {
		//input the number
		Scanner in = new Scanner(System.in); 
		System.out.println("Enter number: ");
			int N = in.nextInt();
			//print your the number typed and its factorial result
			System.out.print("factorial of " + N + " ==> " + nFactorial(N));
		//close scanner
		in.close();
	}
	
}
