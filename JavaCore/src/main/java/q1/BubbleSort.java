// David Lavoie Revature Assignment 1 Q1
package q1;

import java.util.Arrays;

public class BubbleSort {
	
	// bubble sort is a terrible sorting algorithm, but I guess it's easy to implement?
	// for i in length M
	// for m_i \in M, compare m_i to m_j, s.t. j > i. if m_i > m_j, swap positions.
	// That's it.
	
	public static void bubble(int ... sequence) {
		for (int i = 0; i < sequence.length - 1; i++) {
			for (int j = 0; j < sequence.length - i - 1; j++) {
				if (sequence[j] > sequence[j+1] ) {
					int temp = sequence[j];
					sequence[j] = sequence[j+1];
					sequence[j+1] = temp;
				}
				
			}
			
		}
	}

	public static void main(String[] args) {
		int[] mySequence = {1,0,5,6,3,2,3,7,9,8,4}; //given array
		bubble(mySequence);
		System.out.println(Arrays.toString(mySequence));
	}
}