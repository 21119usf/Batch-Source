package homework1;

import java.util.ArrayList;
import java.util.List;

public class Question9 {

	static class MathList{
		//method that returns if a number is prime
		private static boolean primeNum(int number) {
		    for(int i = 2; i < number; i++) {
		        if(number % i == 0) {
		            return false;
		        }
		    }
		    return true;
		}
		
		// method that make fills the list with 100 numbers and prints the prime numbers
		static void arrAdd(List<Integer> numStore ){
			
		
	
		int v= numStore.size();	
		int n = 0;
		int y = 0;
	
		//fills the list with 100 numbers
		while (n < 100) {
			y++;
			n++;
			numStore.add(y);
			
		}
		//converts Arraylist to an array
		Integer[] k = numStore.toArray(new Integer[v]);
		
		//iterates through array to determine if each value is prime or not by calling the primeNum method above
		System.out.println("Prime Numbers:");
		for (int g = 1; g < numStore.size(); g++ ) {
				
				 //System.out.println(k[g]);
				 if (!primeNum(k[g])){
			            
					
			            }
				 else {
					
					  System.out.println(k[g]);
				 }
				 
			        }
		
			}
		
		
		
			}
			
	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		List <Integer> mathvalc = new ArrayList<Integer>();
		MathList.arrAdd(mathvalc);
		System.out.println("Original List: ");
		System.out.println(mathvalc);
		
    
	}

}
