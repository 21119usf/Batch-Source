package homework1;
//DONE
import java.util.Scanner;

public class Q17 {
	//Write a program that calculates the simple interest on the principal,
	//rate of interest and number of years provided by the user.
	//Enter principal, rate and time through the console using the Scanner class.
	//
	//Interest = Principal* Rate* Time
	public static double calculateInterest(int principal, double rate, int time) {
		return principal * rate * time;
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the principal amount: ");
		int principal = input.nextInt();
		System.out.println("Please enter the interest rate amount: ");
		double rate = input.nextDouble();
		System.out.println("Please enter the number of years: ");
		int years = input.nextInt();
		
		System.out.println("Your simple interest will be $"
							+ calculateInterest(principal, rate, years));
		input.close();
	}
}
