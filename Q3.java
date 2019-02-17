package com.revature.homework;
import java.util.Scanner;

public class Q3 {

		public static void main(String ... args) {
			Scanner sc=new Scanner(System.in);
			String name;
			System.out.println("Enter a name: ");
			name=sc.next();
			int length=name.length();
			String arr[] = new String[length];
			for(int i=0;i<length;i++) {
				arr[i]=String.valueOf(name.charAt(i));
			}
			System.out.print("String reverse:");
			for(int j=length-1;j>=0;j--) {
				System.out.print(arr[j]+" ");
			}
			System.out.println("\n This will only reverse the first word inputted");
		}
	}

