package marquez.revature.q4;

import java.util.Scanner;

//Write a program to compute N factorial.

public class NFactorial 
{
	static int factorial(int x)
	{
		int fac = 1, i;
		for(i = 2; i <= x; i++)
		{
			fac *= i;
		}
		return fac;
	}
	public static void main(String[] args) 
	{
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println("Give me a number:");
		int num = scan.nextInt();
		System.out.println("The factorial of the number inputted is " + factorial(num));
			
	}
}
