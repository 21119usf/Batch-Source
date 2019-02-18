package com.revature.q13;

public class Q13 {

	public static void main(String[] args) {

		int level = 5;
		boolean check = true;

		for (int i = 0; i < level; ++i) { // prints the levels of the triangle
			
			for (int j = 0; j < i; j++) { // keeps alternating 0s and 1s, but terminates when j is less than current i

				if (check) {
					System.out.print("0 ");
					check = false;
				} else {
					System.out.print("1 ");
					check = true;
				}
			}

			System.out.print("\n");
		}

	}
}
