package homework1;

public class QuestionOne {

	//method makes the bubble sort
	 void  bubbleSort(int bubby[])
	{
		int place = bubby.length;
		// for loops that iterate through the array
		for (int counter1 = 0; counter1 < place-1; counter1++)
		{
			for (int counter2 = 0; counter2 < place-counter1-1; counter2++)
			{
				//condition that checks value in array, to see if value is greater than value next to it, then swaps if true.
				if (bubby[counter2] > bubby [counter2+1])
				{
					int temp = bubby[counter2];
					bubby[counter2]= bubby [counter2+1];
					bubby[counter2+1] = temp;
				}
			}
		}
		
	}
	 
	  //method that prints array
	  static void printArray(int arr[]) 
	    { 
	        int m = arr.length; 
	        for (int x=0; x<m; ++x) 
	            System.out.print(arr[x] + " "); 
	        System.out.println(); 
	    } 
	  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] makeArray = { 1,0,5,6,3,2,3,7,9,8,4};
	//makes new object to call bubble sort method
	QuestionOne bubbly = new QuestionOne ();
	bubbly.bubbleSort(makeArray);
	//Prints final result of bubble sort
	System.out.println("Here is your sorted list: ");
	printArray(makeArray);
	
	
	} 

}
