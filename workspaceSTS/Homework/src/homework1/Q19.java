package homework1;

import java.util.ArrayList;

public class Q19 {
	//Create an ArrayList and insert integers 1 through 10. Display the ArrayList.
	//Add all the even numbers up and display the result. Add all the odd numbers up
	//and display the result. Remove the prime numbers from the ArrayList and print out
	//the remaining ArrayList.
	public static void sumUp(ArrayList<Integer> arr, int option) {
		int sum = 0;
		for (int i: arr) {
			if (i%2 == option) {
				sum += i;
			}
		}
		System.out.println(sum);
	}
	
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
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (int i = 1; i <= 10; i++)
			arr.add(i);
		for (int i: arr)
			System.out.print(i + " ");
		
		System.out.print("\nThe sum of the even numbers is: ");
		sumUp(arr, 0);
		System.out.print("The sum of the odd numbers is: ");
		sumUp(arr, 1);
		
		for (int i: arr) {
			if (isPrime(i))
				arr.remove(i);
		}
		
		System.out.println("The list with primes removed: ");
		for (int i: arr)
			System.out.print(i + " ");
		
		
	}
}
