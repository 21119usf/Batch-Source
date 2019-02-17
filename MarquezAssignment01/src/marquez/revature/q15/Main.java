package marquez.revature.q15;

import java.util.Scanner;

/* Write a program that defines an interface having the following methods: addition,
 * subtraction, multiplication, and division. Create a class that implements this interface
 * and provides appropriate functionality to carry out the required operations. Hard code
 * two operands in a test class having a main method that calls the implementing class.
 */

public class Main 
{	
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Input two numbers:");
		int num1 = scan.nextInt();
		int num2 = scan.nextInt();
		Operation op = new Operation();
		op.addOperator(num1, num2);
		op.subOperator(num1, num2);
		op.multOperator(num1, num2);
		op.divOperator(num1, num2);
		System.out.println("The results with " + num1 + " & " + num2 + ":");
		op.results();
		scan.close();
	}
}
class Operation implements Operators
{
	int addResult, subResult, multResult, divResult;
	@Override
	public void addOperator(int a, int b) {
		addResult = a + b;
	}

	@Override
	public void subOperator(int a, int b) {
		subResult =  a - b;
	}

	@Override
	public void multOperator(int a, int b) {
		multResult = a * b;
	}

	@Override
	public void divOperator(int a, int b) {
		divResult = a / b;
	}
	public void results()
	{
		System.out.println("Addition: " + addResult +
						   "\nSubtraction: " + subResult +
						   "\nMultiplicaion: " + multResult +
						   "\nDivison: " + divResult);
	}
}
