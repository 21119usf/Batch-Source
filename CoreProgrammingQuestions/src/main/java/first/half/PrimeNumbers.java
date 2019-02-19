package first.half;

import java.util.ArrayList;

public class PrimeNumbers {
	
	private ArrayList<Integer> ints = new ArrayList<Integer>();
	
	public PrimeNumbers(int first, int last) {
		for(int i = first; i <= last; i++) {
			ints.add(i);
		}
	}
	
	public void printPrimeNumbers(){
		
		for(int x: ints) {
			if(isPrime(x))
				System.out.print(x + " ");
		}
	}
	
	public static boolean isPrime(int x) {
		for(int i = 2; i <= (int) (x/2) + 1; i++) {
			if(x % i == 0)
				return false;
		}
		return true;
	}

}
