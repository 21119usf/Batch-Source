package com.revature.homework1;

public class Q13_Pyramid {

	public void pyramid(int x) {
		// create an array for deciding to print 1 or 0 first
		int[] intArray = new int[x];
		int count = 0;	//to decide whether to start with 1 or 0
		
		// fill the array
		for(int i=0; i<intArray.length;i++) {
			intArray[i] = i+1;
		}
		
		// iterate through
		for(int i=0;i<intArray.length;i++) {
			// create sequence depending on element number
			for(int n=1; n<=intArray[i];n++) {
				
				// decide to start sequence with 1
				if(count>0 && count<3) {
					if(n%2!=0) {
						System.out.print(1);	// ADD A 1
					}else{
						System.out.print(0);	// ADD A 0
						}
				//System.out.print("count " + count + " ");
				}else{
					// continue sequence with 0
					if(n%2==0) {
						System.out.print(1);	// ADD A 1
					}else{
						System.out.print(0);	// ADD A 0
						};
					}
				// reset sequence to start with a zero again
				if(count>2) {
					count=0;	// reset counter
				}
			}count++;			// increase 
			
			System.out.println(); // new line
		}
	}
	public static void main(String[] args) {
		Q13_Pyramid p = new Q13_Pyramid();
		p.pyramid(4);	// print the pyramid
	}

}
