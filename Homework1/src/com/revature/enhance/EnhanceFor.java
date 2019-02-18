package com.revature.enhance;

public class EnhanceFor {

	public static void main(String[] args) {
		int[] list = Array(100);
		int[] even = getEven(list);
		for( int i : even) {
			System.out.println(i + " ");
		}
		System.out.println();

	}
	//create the array
	public static int[] Array(int n) {
		int[] list = new int[n];
		for(int i = 0; i<n; i++) {
			//adding 1 to the array
			list[i] = i+1;
			
		}
		return list;
	}
	
	//get the evens
	public static int[] getEven(int[] list) {
		//gets the size of the array length
		int[] even = new int[list.length/2];
		int index = 0;
		for(int i : list) {
			//if statement to find the even checking if it can be divided by two
			if(i%2 == 0) {
				even[index] = i;
				index++;
			}
			
		}
		return even;
	}


}
