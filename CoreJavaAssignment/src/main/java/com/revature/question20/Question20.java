package com.revature.question20;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Question20 {

	private static final String inFile = "Data.txt";
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		InputStream is = null;
		File file = new File(inFile);
		StringBuilder s = new StringBuilder();
		try {
			is = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int b = 0;
		try {
			while((b = is.read())!= -1) {
				char c = (char)b;
				s.append(c);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		if(is!=null) {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		String[] subs = s.toString().split("\n");
		String[] one = subs[0].split(":");
		String[] two = subs[1].split(":");
		String[] three = subs[2].split(":");
		String[] four = subs[3].split(":");
		int strlength = one.length;
		for(int i = 0; i < strlength ; i++) {
			switch(i) {
			case 0:
				System.out.print("Name: " + one[i]);
				break;
			case 1:
				System.out.println(" " + one[i]);
				break;
			case 2:
				System.out.println("Age: " + one[i] + " years");
				break;
			case 3:
				System.out.println("State: " + one[i] + " State");
				break;
			}
		}
		for(int i = 0; i < strlength ; i++) {
			switch(i) {
			case 0:
				System.out.print("Name: " + two[i]);
				break;
			case 1:
				System.out.println(" " + two[i]);
				break;
			case 2:
				System.out.println("Age: " + two[i] + " years");
				break;
			case 3:
				System.out.println("State: " + two[i] + " State");
				break;
			}
		}
		for(int i = 0; i < strlength ; i++) {
			switch(i) {
			case 0:
				System.out.print("Name: " + three[i]);
				break;
			case 1:
				System.out.println(" " + three[i]);
				break;
			case 2:
				System.out.println("Age: " + three[i] + " years");
				break;
			case 3:
				System.out.println("State: " + three[i] + " State");
				break;
			}
		}
		for(int i = 0; i < strlength ; i++) {
			switch(i) {
			case 0:
				System.out.print("Name: " + four[i]);
				break;
			case 1:
				System.out.println(" " + four[i]);
				break;
			case 2:
				System.out.println("Age: " + four[i] + " years");
				break;
			case 3:
				System.out.println("State: " + four[i] + " State");
				break;
			}
		}
	}

}
