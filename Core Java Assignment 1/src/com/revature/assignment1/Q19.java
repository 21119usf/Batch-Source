package com.revature.assignment1;

import java.util.ArrayList;

public class Q19 {

	public static void main(String[] args) {
		ArrayList<Integer> intList  = new ArrayList<Integer>();//arrayList
		
		for(int i = 1;i<11;i++) {//method to insert numbers 1 -  10 into arraylist
			intList.add(i);//insert number
		}
		int j=0;
		for(int i = 0;i<10;i+=2) {//method to get even numbers
			j=j+intList.get(i);//adding sum of all even numbers
			System.out.println("Adding "+intList.get(i));//display result
		}
		System.out.println(j);
		int k=0;
		for(int i = 1;i<10;i+=2) {//method to get odd numbers
			k=k+intList.get(i);//adding sum of all odd numbers
			System.out.println("Adding "+intList.get(i));//display result
		}
		System.out.println(k);
		int m = 1;
		for(int i=2;i<intList.size();i++) {
			for(int l = 2;l<=i;l++){
				if(l==i){
					System.out.println("Dropping "+i+" because its prime.");
					break;
				}
				if(i%l==0){
					
					System.out.println("Adding "+ i);
					m+=i;
				}
			}
		}
		System.out.println(m);
	}
}
