package homework1;

import java.util.Scanner;

public class Question17 {

	static double interestCalc(int a, int b, double c) {
		 double v =c/100;
		 double interest = a*b*v;
		
		 return interest;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Interest rate calculator: First, enter your principal amount: ");
		int princ=sc.nextInt();
		System.out.println("Now Enter How many years do you have on your loan: ");
		int time=sc.nextInt();
		System.out.println("Finally, what is your interest rate? ");
		double rate=sc.nextDouble();
		sc.close();
		System.out.println("This is the amount of interest you will  pay over the next " + time + " years");
		double m = interestCalc(princ,time, rate);

		System.out.println(m);
	}
	
	
	
	
}
