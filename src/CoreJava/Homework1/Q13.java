package com.revature.homework;

public class Q13 {
	
    public static boolean sqrt(int x) { //prints rows
        double a = Math.sqrt(8*x + 1);
        return (a - Math.floor(a) == 0);
    }
    
   public static void printArray(int[] runArray) { //run array
       for (int i=1; i<=runArray.length; i++) {
           System.out.print(runArray[i-1] + " ");
           if (sqrt(i)) {
               System.out.println();
           }
       }
   }
       public static void main(String[] args) { //print array
          int[] array1 = {0, 1, 0, 1, 0, 1, 0, 1, 0, 1};
          printArray(array1);
       }
    }