package core.java.core_questions;
import java.util.Scanner;

/*class able with fields for num of years
 * rate of interest
 * and principal amount
 */
public class question17 {
	private int num_of_years; 
	private double rate_of_interest;
	private double principal; 
	//constructor
	private question17(int noy, double roi, double pr) {
		this.num_of_years = noy; 
		this.rate_of_interest = roi; 
		this.principal = pr; 
	}
	//this method calculates the interest
	public double simpleInterestCalculator() {
		return this.rate_of_interest*this.num_of_years*this.principal;
	}
	
	public static void main(String[] args) {
		System.out.println("Simple Interest Calculator");
		System.out.println("===========================\n");
		//Scanner to read values inputed by user
		Scanner in = new Scanner(System.in);
		System.out.println("Enter Principal Amount:");
		//Principal amount 
		double principal = in.nextDouble();
		in.nextLine();
		//Interest amount
		System.out.println("Enter Rate of Interest:");
		double rate0fInterest = in.nextDouble();
		in.nextLine();
		//Number of years
		System.out.println("Enter Number of Years:");
		int numberOfYears = in.nextInt();
		in.nextLine();
		in.close();
		//Initialize object to hold values
		question17 q = new question17(numberOfYears, rate0fInterest, principal); 
		//Print the interest amount
		System.out.println("Calculating Interest ....\n");
		System.out.printf("Interest Amount: " + q.simpleInterestCalculator());
	}
}
