package com.revature.loops;

public class ControlStatements {
static String controltype;
	public static void controls(int p,String controltype){
		
		if(p>9) {
			System.out.println("p should be less than 10");
		}
		else if(p<1) {
			System.out.println("p should be greater than zero");
		}
		else {
		switch (controltype) {
		case "forloop":
			System.out.println("======== For Loop: ========");
			for (int i=1;i<p;i++) {
				System.out.println(i);
			}
		case "dowhile":
			System.out.println("====== Do While Loop ======");
			int j=0;
			do {
				System.out.println(j);
				j++;
			}while (j<p);
			
			default:
				System.out.println("============================");
			}
	}
	}
	
	public static void main(String[] args) {
		controls(9,"forloop");
	}
}
