package homework1;

import java.util.ArrayList;
import java.util.List;

public class Question12 {
	static void evenNumbers() {
		//creates a list to hold the numbers
		List <Integer> evenList = new ArrayList<Integer>();
		int y = 0;
		int n = 0;

		
		//while loop that adds numbers to the array list
		while (n < 100) {
			y++;
			n++;
			evenList.add(y);
			
		}
		System.out.println("Original List: ");
		System.out.println(evenList.toString());
		
		System.out.println("Even Numbers from the List: ");
		//enhanced for loop  that checks if each value in the list is even
		for (int s: evenList)
		{
			
			if(s/2 != s*.5)
			{
				System.out.println(evenList.get(s));
			}
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		evenNumbers();
	}

}
