//Q19. Create an ArrayList and insert integers 1 through 10. Display the ArrayList. Add
//all the even numbers up and display the result. Add all the odd numbers up and display
//the result. Remove the prime numbers from the ArrayList and print out the remaining
//ArrayList.

package com.revature.cja;

import java.util.ArrayList;

public class ArrayListIntegers {
	
	private ArrayList<Integer> al = new ArrayList<>();
	
	public ArrayListIntegers() {
		insertNums();
	}
	
	// method to insert number into ArrayList
	private void insertNums() {
		for (int i = 1; i <= 10; i++) {
			al.add(i);
		}
	}
	
	// method to display ArrayList
	public void displayArrayList() {
		for (Integer i : al) {
			System.out.print(i + " ");
		}
	}
	
	// method to sum even numbers
	public int sumEvenNumbers() {
		int evenNums = 0;
		
		for (Integer i : al) {
			if (i % 2 == 0) {
				evenNums += i;
			}
		}
		
		return evenNums;
	}
	
	// method to add odd numbers
	public int sumOddNumbers() {
		int oddNums = 0;
		
		for (Integer i : al) {
			if (i % 2 == 1) {
				oddNums += i;
			}
		}
		
		return oddNums;
	}
	
	// method to remove prime numbers from ArrayList
	public void removePrimeNumbers() {
		int i = 0;
		
		while (i < al.size()) {
			if (isPrime(al.get(i))) {
				al.remove(i);
				continue;
			}
			i++;
		}
	}
	
	// method to check if number is prime
	public boolean isPrime(int num) {
		if (num <= 1) {
			return false;
		}
		
		for (int i = 2; i < num; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		
		return true;
	}

}
