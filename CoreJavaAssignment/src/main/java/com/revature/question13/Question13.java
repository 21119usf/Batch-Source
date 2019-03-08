package com.revature.question13;

public class Question13 {

	//Display the triangle on the console as follows using any type of loop.  
	//Do NOT use a simple group of print statements to accomplish this.
	//0
	//1 0
	//1 0 1
	//0 1 0 1
	
	static boolean value = false;
	public static final int max = 4;
	
	
	public static void pyramid() {
		for(int i = 0; i < max; i++) {
			for(int j = 0; j < i+1; j++) {
				if(value == true) {
					System.out.print("1 ");
					value = false;
				}else if(value == false) {
					System.out.print("0 ");
					value = true;
				}
			}
			
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		pyramid();
	}

}
