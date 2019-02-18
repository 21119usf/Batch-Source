package com.revature.hw1;
import java.util.ArrayList;

public class Prob9PrimeRib {

    public static void main(String[] args) {

        ArrayList<Integer> numbers = new ArrayList<Integer>();
        
        System.out.println("Prime numbers below");
        System.out.println("=========================");
        for(int i = 1; i <= 100; i++) {
            numbers.add(i);
            //prints out what is true
            if(isPrime(i)) {
                System.out.println(i);
            }
        }

    }

    //checks for prime number
    private static boolean isPrime(int x) {
        //checking for 2
        if(x == 2) {
            return true;
        }

        //check x is a multiple of 2
        if (x % 2 == 0) { 
            return false;
        }

        //check the odds
        for(int i = 3; i * i <= x; i += 2) {
            if(x % i == 0)
                return false;
        }
        return true;
    }

}

