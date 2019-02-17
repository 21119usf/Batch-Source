package com.revature.cja;

import java.util.ArrayList;

public class ArrayListIntegers {
	
	private ArrayList<Integer> al = new ArrayList<>();
	
	public ArrayListIntegers() {
		insertNums();
	}
	
	private void insertNums() {
		for (int i = 1; i <= 10; i++) {
			al.add(i);
		}
	}
	
	public void displayArrayList() {
		for (Integer i : al) {
			System.out.print(i + " ");
		}
	}
	
	public int sumEvenNumbers() {
		int evenNums = 0;
		
		for (Integer i : al) {
			if (i % 2 == 0) {
				evenNums += i;
			}
		}
		
		return evenNums;
	}
	
	public int sumOddNumbers() {
		int oddNums = 0;
		
		for (Integer i : al) {
			if (i % 2 == 1) {
				oddNums += i;
			}
		}
		
		return oddNums;
	}
	
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
