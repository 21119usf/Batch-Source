package com.revature.homework;

public class Q12 {
	 
	public static void main(String[] args) {

		int array[] = new int [102];
		for(int i = 0 ; i < array.length ; i++){
		    array[i] = i;
		 }
		 for(int x : array){
			if(array[x]%2==0) {
		   System.out.println(x);
		  }
	}
	
  } 
}
