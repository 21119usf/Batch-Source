package com.revature.homework;

import java.util.Scanner;
public class Q17 
{
    public static void main(String args[]) {
        float p, r, t;
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the principal: ");
        p = s.nextFloat();
        System.out.print("Enter the rate of interest: ");
        r = s.nextFloat();
        System.out.print("Enter the time period: ");
        t = s.nextFloat();
        float si;
        si = (r * t * p) / 100;
        System.out.println("Your Simple Interest = " + si);
        System.out.println("Don't you go and spend it all on some fancy record player. :D");
    }
}