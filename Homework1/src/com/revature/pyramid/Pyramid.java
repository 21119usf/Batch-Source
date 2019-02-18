package com.revature.pyramid;

public class Pyramid {

	//prints out the amount of rows
		public static boolean isTriangular(int n) {
			double d = Math.sqrt(8*n + 1);
			return (d - Math.floor(d) == 0);
		}
		
	   public static void printArray(int[] testArray) {
		   for (int i=1; i<=testArray.length; i++) {
			   System.out.print(testArray[i-1] + " ");
			   if (isTriangular(i)) {
				   System.out.println();
			   }
		   }
	   }
		   /*int i, j;
		      for(i = 0; i<testArray.length; i++) {
		    	  for(j=0; j<=i; j++) {
		    		  System.out.println(testArray[i][j]);
		        
		      }
		    	  System.out.println();
		      }
		   }*/
		   public static void main(String[] args) {
		      //String[][] testArray = {{ "0", "1", "0", "1", "0", "1", "0", "1", "0", "1"} };
		      int[] testArray = {0, 1, 0, 1, 0, 1, 0, 1, 0, 1};
		      printArray(testArray);
		   }
		}