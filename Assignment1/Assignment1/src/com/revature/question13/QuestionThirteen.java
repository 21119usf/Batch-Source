package com.revature.question13;


//Q13. Display the triangle on the console as follows using any type of loop.  
//Do NOT use a simple group of print statements to accomplish this.
//   0
//  1 0
// 1 0 1
//0 1 0 1

public class QuestionThirteen {

	public static void main(String[] args) {
		String space = " ";
		int n = 4;
		int ONE = 1;
		int ZERO = 0;
		for (int j = 0; j < n; j++) {
			
		for (int i = 0; i<n-j-1;i++) {
			System.out.print(space);
			
		}
		if (j == 0) {
			System.out.println(ZERO);
		}
		else if (j == 1) {
			System.out.print(ONE);
			System.out.print(space);
			System.out.println(ZERO);
		}
		else if (j == 2) {
			for (int k = 1;k <= n-1; k++) {
				if (k%2 == 0) {
					System.out.print(space + ZERO + space);
				}
				else {
					System.out.print(ONE);
				}
			}
		}
		else {
			System.out.println();
			for (int k = 1;k <= n; k++) {
				if (k%2 == 0) {
					System.out.print(ZERO + space);
				}
				else {
					System.out.print(ONE + space);
				}
			}
		}
	}

}
}
