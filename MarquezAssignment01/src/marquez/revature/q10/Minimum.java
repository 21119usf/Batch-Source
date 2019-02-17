package marquez.revature.q10;

import java.util.Scanner;

//Find the minimum of two numbers using ternary operators.

public class Minimum
{
	public static void main(String[] args) 
	{
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println("Input two numbers:");
		int num1 = scan.nextInt();
		int num2 = scan.nextInt();
		// Using ternary operators to find the minimum of num1 and num2
		int min = (num1 < num2) ? num1 : num2;
		System.out.println("The smallest number between " + num1 
							+ " and " + num2 + " is " + min);
	}
}
