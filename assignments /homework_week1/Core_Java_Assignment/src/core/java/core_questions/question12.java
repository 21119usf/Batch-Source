package core.java.core_questions;

public class question12 {
	
	question12() {
		super(); 
	}
	//this method checks if a number is even
	public boolean isEven(int n) {
		if(n%2 == 0) 
			return true; 
		return false;
	}
	//this method calculate the size for the only-even-number array 
	public int arraySize(int n) {
		int count = 0; 
		for(int i = 1; i <= n; i++) {
			if(isEven(i))
				count++;
		}
		return count; 
	}
	//this method the array with even numbers 
	public int[] storeNumbers(int n) {
		int count = 0; 
		int[] only_even = new int[arraySize(n)];
		for(int i = 1; i <= n; i++) {
			if(isEven(i)) {
				only_even[count] = i;
				count++;
			}
		}
		return only_even; 
	}
	
	public static void main(String[] args) {
		//instantiate class question12
		question12 q = new question12(); 
		//print the array with even numbers
		//ENHANCED FOR LOOP RIGH HERE!!
		for(int integer : q.storeNumbers(100))
			System.out.print("" + integer + " "); 
	}
	
}
