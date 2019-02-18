package com.revature.assignment1;

public class Q2 {

	public static void main(String[] args) {
				int n = 25;//hard coded 25 since instructions were to retrieve the first 25 fibonacci numbers
				findFibo(n);//method call to find the fibonacci numbers passing the int through

	}
	
	public static void findFibo(int n) {
		for(int i = 0;i<n;i++) {//for loop going from 0 to 25
			if(i<=1) {//this takes care of both 0 and i
				System.out.println(i);
			}else {
				int a = 0;//initialized within block 
				int b = 1;//since 0 and 1 were already accounted for we skip through them to the2
				int c = 1;
				for(int j = 2;j<=i;j++) {//inner for loop
					c = a+b;//the sum of the two preceding numbers is what makes the fibonacci series
					a = b;//shifting to the next two digits
					b = c;
				}
				System.out.println(c+" ");//display the fibonacci numbers
			}
		}
	}
}