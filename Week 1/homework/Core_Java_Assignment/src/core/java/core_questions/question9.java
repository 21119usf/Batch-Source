//current package
package core.java.core_questions;
//import arrayList class
import java.util.ArrayList;
//create a class for question 9
public class question9 {
	
	//this method checks if an integer is prime or not
	public static boolean Is_Prime(int n) {
		if(n <= 1)
			return false; 
		
		for(int i = 2; i < n; i++) {
			if(n % i == 0)
				return false;
		}
		return true; 
	}
	//this static returns an Arraylist with only prime numbers
	public static ArrayList<Integer> Stores(int n) {
		ArrayList<Integer> arr = new ArrayList<Integer>(); 

		for(int i = 1; i <= n; i++) {
			if(Is_Prime(i))
				arr.add(i);
		}
	return arr; 
	}
	
	//Main method to 
	public static void main(String[] args) {
		//store values in array list that are only prime
		ArrayList<Integer> temp; 
		temp = Stores(100);
		//display array by unboxing 
		for(int p : temp) 
			System.out.print("" + p + " "); 	
		}
}