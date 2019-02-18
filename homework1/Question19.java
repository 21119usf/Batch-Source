package homework1;

import java.util.ArrayList;


class MathList{
	//method that returns if a number is prime
	 static boolean primeNum(int number) {
	    for(int i = 2; i < number; i++) {
	        if(number % i == 0) {
	            return false;
	        }
	    }
	    return true;
	}
	 
	 //method that removes the prime numbers from a list 
	 	static void primeRemoval(ArrayList<Integer> i)
	{
	 		boolean primer = false;
	 		System.out.println(i.toString());
		for(int g = 1; g < i.size(); g++) {
			primer = primeNum(i.get(g));
		 if (primer) {
			i.remove(g);}
		}
		
	}
	 
	 
}

 
public class Question19 {


	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> howie = new ArrayList <Integer>();
		//ArrayList<Integer> evenList = new ArrayList <Integer>();
		//ArrayList<Integer> oddList = new ArrayList <Integer>();
		
		
		int x=0;
		//Integer k= 0;
		int m = 0;
		int p = 0;
		//adds numbers to an array list
		while (x< 10) {
			x++;
			howie.add(x);
		}
		//enhanced for loop to check if even or odd, them add them respectively
		for(int b : howie) {
			
			
			if(b/2 == b*.5) {
			m = m + b;
				 
			}
			
			else {
				p = p+b;
			}
			
				
		}
		System.out.println("Sum of even numbers: ");
		System.out.println(m);
		System.out.println("Sum of odd numbers: ");
		System.out.println(p);
		
		//** leftovers from another method I tried that stored even and odd integers into a separate array and added them together
		//int evenSum = evenList.stream().mapToInt(Integer::intValue).sum();
		//int oddSum = oddList.stream().mapToInt(Integer::intValue).sum();
		
		//System.out.println(evenList.toString());
		//System.out.println(evenSum);
		
		//System.out.println(oddList.toString());
		//System.out.println(oddSum);
		// ** end left overs
		
		System.out.println("Orginal array with Prime Numbers removed: ");
		MathList.primeRemoval(howie);
		System.out.println(howie.toString());
	
		
		}
		
		
	}



