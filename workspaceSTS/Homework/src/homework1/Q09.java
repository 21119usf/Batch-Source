package homework1;

import java.util.ArrayList;
//DONE
public class Q09 {
	//Create an ArrayList which stores numbers from
	//1 to 100 and prints out all the prime numbers to the console.
	
	public static boolean isPrime(int x) {
		if (x == 1)
			return false;
		boolean isPrime = true;
		double sqrt = Math.sqrt((double)x);
		for (int i = 2; i <= sqrt; i++) {
			//System.out.println(x%1);
			if ((x%i) == 0) {
				isPrime = false;
				break;
			}
		}
		return isPrime;
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> array = new ArrayList<Integer>();
		
		for (int i = 1; i <= 100; i++)
			array.add(i);
		System.out.print("Numbers 1-100: ");
		for (int i: array)
			System.out.print(i + " ");
		System.out.print("\nPrimes: ");
		for (int i: array) {
			if (isPrime(i))
				System.out.print(i + " ");
		}
	}
}
