package homework1;
//DONE
import java.util.Scanner;

public class Q04 {
	//Write a program to compute N factorial.
	
	public static int factorial(int n) {
		int product = 1;
		while (n > 0) {
			product *= n--;
		}
		return product;
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Please input a number: ");
		int N = input.nextInt();
		System.out.print(N + " factorial is " + factorial(N));
		input.close();
	}
}
