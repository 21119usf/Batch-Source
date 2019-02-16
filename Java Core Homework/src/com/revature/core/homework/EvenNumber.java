package com.revature.core.homework;
// #6
public class EvenNumber {

	public static boolean isEven(int number) {
		// flag set to true because 0 is even
		boolean isEven = true;
		// loop setting flag to ! of it's current state each time through
		for (int i = 0; i < number; i++) {
			isEven = !isEven;
		}
		return isEven;
	}
	
	public static void main(String[] args) {
		System.out.println(EvenNumber.isEven(10000000));
	}
}
