package second.half;

import java.util.ArrayList;

import first.half.EvenOrNot;

public class EvenNumbers {
	
	private ArrayList<Integer> ints = new ArrayList<Integer>();
	
	public EvenNumbers(int first, int last) {
		for(int i = first; i <= last; i++) {
			ints.add(i);
		}
	}
	
	public void printEvenNumbers(){
		
		for(int x: ints) {
			if(EvenOrNot.isEven(x))
				System.out.print(x + " ");
		}
		
		System.out.println();
	}

}
