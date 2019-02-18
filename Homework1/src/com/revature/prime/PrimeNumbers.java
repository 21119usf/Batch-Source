package com.revature.prime;

public class PrimeNumbers {

public static void main(String[] args) {
        
        //define limit
        int limit = 100;
        
        System.out.println("Prime numbers: ");
        
        //loop through the numbers one by one
        for(int i=1; i < 100; i++){
            
            boolean Prime = true;
            
            //check to see if the number is prime
            for(int j=2; j < i ; j++){
                
                if(i % j == 0){
                    Prime = false;
                    break;
                }
            }
            // print the number
            if(Prime)
                System.out.print(i + " ");
        }
    }
}
