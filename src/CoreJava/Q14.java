package com.revature.homework;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Q14 {
	public static void main (String args[]) {

		int y;
		y = 5;
		
		switch(y) {
		case 4:
			System.out.println(Math.sqrt(y));
			break;
		case 5:
			SimpleDateFormat sdf=new SimpleDateFormat("yyy/MM/dd HH:mm:ss");
	    	Date date=new Date();
	    	System.out.println(sdf.format(date));
			break;
		case 6:
			String x = "I am learning Core Java";
			String [] myJava = x.split(" ");
			System.out.println(myJava[3]);
			break;
		}
	}
}
