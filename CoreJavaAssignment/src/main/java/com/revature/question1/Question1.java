package com.revature.question1;

public class Question1 {
	
	static int[] demo = new int[] {1,0,5,6,3,2,3,7,9,8,4};
	static int n = demo.length;
	static int storedValue;
	
	public static void bubbleSort(int arr[]) {
		
		for(int j = 0; j < n-1; j++) {
			for (int i = 0; i < n-1; i++) {
				if(demo[i] > demo[i+1]) {
					storedValue = demo[i];
					demo[i] = demo[i+1];
					demo[i+1] = storedValue;
					
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		System.out.print("Unsorted Array: ");
		for(int i = 0; i < n; i++) {
			if(i < n) {
				System.out.print(demo[i] + " ");
			}
			else{
				System.out.println(demo[i]);
			}
		}
		System.out.println();
		bubbleSort(demo);
		System.out.print("Sorted Array: ");
		for(int i = 0; i < n; i++) {
			if(i < n) {
				System.out.print(demo[i] + " ");
			}
			else{
				System.out.println(demo[i]);
			}
		}
	}

}
