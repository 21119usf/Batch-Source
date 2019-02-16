package homework1;
//DONE
import java.util.Date;
import java.util.Scanner;

public class Q14 {
	//Write a program that demonstrates the switch case. Implement the following
	//functionalities in the cases:java
	//Case 1: Find the square root of a number using the Math class method.
	//Case 2: Display today�s date.
	//Case 3: Split the following string and store it in a string array.
	//       	 �I am learning Core Java�
	public static void caseSelect(int option) {
			switch(option) {
			case 1:
				Scanner inputNum = new Scanner(System.in);
				System.out.print("Please enter a number to find the square root of: ");
				int num = inputNum.nextInt();
				System.out.println("The square root of " + num + " is " + Math.sqrt(num));
				break;
			case 2:
				Date time = new Date();
				System.out.println("The current date is:\n\t" + time);
				break;
			case 3:
				String str = "I am learning Core Java";
				String[] strArr = str.split(" ");
				for (String a: strArr)
					System.out.println(a);
				break;
			}
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter the number of the option you wish to perform:\n"
							+ "\t(1) - Find the square root of a number\n"
							+ "\t(2) - Display today's date\n"
							+ "\t(3) - Split the following string and store it in a string array.\n" + 
							"\t\t'I am learning Core Java'\n> ");
		int num = input.nextInt();
		caseSelect(num);
		input.close();
	}
}
