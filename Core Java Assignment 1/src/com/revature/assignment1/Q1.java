package com.revature.assignment1;

public class Q1 {

	public static void main(String[] args) {
		
		int[] a = {1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4};//hard coded series of integers in int array
		bubSort(a);//call to static method
		
	}
	//method created to take in int array and pass it through a nested for loop
	public static void bubSort(int[] intArr) {
		
		//nested for loop
		for(int i = 0;i<intArr.length;i++) {	//'i' will hold a position, while 'j' will iterate through	
			for(int j = 0;j<intArr.length-1;j++) {//once j iterates through, i moves to the next position
				if(intArr[j]>intArr[j+1]) {// the object is to bubble the larger number to the right position with each iteration
					int temp = intArr[j];//temp var to initiate swap
					intArr[j]=intArr[j+1];//if j's value is in fact greater than j+1's, then j+1 will shift to j's place
					intArr[j+1] = temp;//and j which was the temp value will now switch
				}
			}
		}
		for(int x : intArr) {//enhanced for loop to display result of intArr
			System.out.print(x+" ");
		}
		
	}

}
