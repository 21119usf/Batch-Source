package second.half;

import java.util.ArrayList;
import java.util.Iterator;

import first.half.EvenOrNot;
import first.half.PrimeNumbers;

public class ArrayListOfInts {
	
	public static void doStuff() {
		ArrayList<Integer> arli = new ArrayList<Integer>();
		int evenSum = 0;
		int oddSum = 0;
		
		for(int i = 1; i <= 10; i++) {
			arli.add(i);
		}
		
		for(int i : arli) {
			if(EvenOrNot.isEven(i)) {
				evenSum += i;
			} else {
				oddSum += i;
			}
		}
		
		System.out.println("Even Sum: " + evenSum);
		System.out.println("Odd Sum: " + oddSum);
		
		Iterator<Integer> itr = arli.iterator();
		while(itr.hasNext()) {
			int x = (int) itr.next();
			if(PrimeNumbers.isPrime(x))
				itr.remove();
		}
	
		for(Integer i : arli) {
			System.out.print(i + " ");
		}
		System.out.println();
		
	
		
	}

}
