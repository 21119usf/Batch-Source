package marquez.revature.q17;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

/* Write a program that calculates the simple interest on the principal, rate of interest
 * and number of years provided by the user. Enter principal, rate and time through the
 * console using the Scanner class.
 * Interest = Principal* Rate* Time
 */

public class Interest 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		NumberFormat formatter = new DecimalFormat("#0.00");
		System.out.println("Input principal, interest rate and year in this order:");
		double principal = scan.nextDouble();
		double interestRate = scan.nextDouble();
		int year = scan.nextInt();
		double interest = principal*interestRate*year;
		System.out.println("Your interest is $" + formatter.format(interest));
		scan.close();
	}
}
