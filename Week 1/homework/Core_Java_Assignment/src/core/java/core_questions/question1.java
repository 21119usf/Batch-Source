//package where the current file is 
package core.java.core_questions;
//crate your class
public class question1 {
	//constructor with not arguments
	question1(){
		super(); 
	}
	//out bubble-sort method
	public void bubbleSort(int[] arr) {
		int n = arr.length; 
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n-i-1; j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
	//this will print the array
	public void print(int[] num) {
		for(int i = 0; i < num.length; i++) {
			System.out.print("" + num[i] + " ");
		}
		System.out.println(); 
	}
	//main method
	public static void main(String[] args) {
		//instantiate your object 
		question1 q1 = new question1();
		//our array to be passed in the bubble sort method
		int[] intArray = {1,0,5,6,3,2,3,7,9,8,4}; 
		//sort the array
		q1.bubbleSort(intArray);
		//print array sorted 
		q1.print(intArray);
	}
}
