//package com.revature.core;

import java.util.*; 
import java.lang.*; 
import java.io.*; 

class employees implements  Comparator<employees>{
    String name;
    int age;
    String department;

    public String getName(){
        return this.name;
    }

    public int getAge(){
        return this.age;
    }

    public String getDepartment(){
        return this.department;
    }

    employees(String name, int age, String department){
        this.name = name;
        this.age = age;
        this.department = department;
    }

    public int compare(employees a, employees b){
        if(a.getName().compareTo(b.getName()) != 0){
            return a.getName().compareTo(b.getName());
        }else if(a.getAge() != b.getAge()){
            return a.getAge() - b.getAge();
        }else if(a.getDepartment().compareTo(b.getDepartment()) != 0){
            return a.getDepartment().compareTo(b.getDepartment());
        }else{//same
            return 0;
        }
    }

    public int compare(employees b){
        if(this.getName().compareTo(b.getName()) != 0){
            return this.getName().compareTo(b.getName());
        }else if(this.getAge() != b.getAge()){
            return this.getAge() - b.getAge();
        }else if(this.getDepartment().compareTo(b.getDepartment()) != 0){
            return this.getDepartment().compareTo(b.getDepartment());
        }else{//same
            return 0;
        }
    }
}

public class CoreJava {

    public static void  Q1(){
        Integer[] array = {1,0,5,6,3,2,3,7,9,8,4};
        Arrays.sort(array);
        for( Integer number : array){
            System.out.print(number + " ");
        }
        System.out.println();
    }

    public static void  Q2(){
        int start = 0;
        int last = 1;
        int holder;


        for(int i = 0; i < 25; i++){
            System.out.print(start + " ");
            holder = start + last;
            start = last;
            last = holder;
        }
        System.out.println();
    }

    public static void  Q3(){
        String thing = "happy birthday";
        int length = thing.length();

        for(int i = length - 1 ; i >= 0; i--){
            thing += thing.charAt(i);
        }

        //sub string begin is inclusive end is exclusive
        thing = thing.substring(length, thing.length());
        System.out.println(thing);
    }
    public static void  Q4(int N){
        long holder = 1;
        for(int i = N; i > 0; i--){
            holder *= i;
        }
        System.out.println(holder);
    }

    public static void  Q5(String passed_string,int inclusive_start, int inclusive_end){
        //check to make sure start is < end
        //do a check to make sure end is < str.len
        String new_string = "";
        for(int i = inclusive_start; i <= inclusive_end; i++){
            new_string += passed_string.charAt(i);
        }
        System.out.println(new_string);
    }
    public static void  Q6(int i){
        double holder = i/2.0f;
        if((holder - (int)holder) == 0){
            System.out.println("EVEN");
        }else{
            System.out.println("ODD");
        }

        int bitwise = 1;
        bitwise = bitwise & i;
        if(bitwise == 0){
            System.out.println("EVEN");
        }else{
            System.out.println("ODD");
        }
    }
    public static void  Q7(){
        employees e1 = new employees("mark", 23, "HR");
        employees e2 = new employees("mark", 23, "HR");
        employees e3 = new employees("tom", 42, "QC");

        System.out.println("emp comp " + e1.compare(e1, e2));
        System.out.println("emp comp " + e3.compare(e2));
    }

    public static boolean checkPalandromes(String str){
        for(int i = 0; i < str.length() / 2; i++){
            if(str.charAt(i) != str.charAt(str.length() - (1 + i))){
                return false;
            }
        }

        return true;
    }

    public static void  Q8(){
        String [] names = {"karan", "madam", "tom", "civic", "radar", "jimmy", "kayak", "john",  "refer", "billy", "did", "helleh"};
        List<String> strings = new ArrayList<String>(Arrays.asList(names));
        List<String> palandromes = new ArrayList<String>();

        for(String name: strings){
            if(checkPalandromes(name)){
                palandromes.add(name);
            }
        }

        for(String name :palandromes){
            System.out.print(name + " ");
        }
        System.out.println();
    }

    public static void  Q9(int prime){
        for(int i = 2; i < prime ;i++){
            if(prime % i == 0){
                System.out.println("Not Prime");
                return;
            }
        }
        System.out.println("Is Prime");
    }

    public static void  Q10(double num1, double num2){
        double low = num1 < num2 ? num1 : num2;
        System.out.println(low);
    }

    public static void  Q11(){ //FINISH
        
        try {
            Class<?> fields = Class.forName("com.revature.other");

        } catch (Exception e) {
            //TODO: handle exception
        }
    }
    public static void Q12(){
        int arr [] = new int[100];

        for (int i = 1; i <= 100; i++) {
            arr[i-1] = i;
        }

        for(int num : arr){
            if(num % 2 == 0){
                System.out.print(num + " ");
            }
        }
        System.out.println();
    }

    public static void  Q13(){
        byte num = 0;
        for(int i = 1; i <= 4; i++){
            for(int j = i; j > 0; j--){
                System.out.print(num + " ");
                num = num == 0 ? (byte) 1 : 0;
            }
            System.out.println();
        }
    }

    public static void  Q14(){

    }

    public static void  Q15(){

    }

    public static void  Q16(String name){
        System.out.println(name.length());
    }

    public static void  Q17(){

    }

    public static void  Q18(){

    }

    public static void  Q19(){

    }

    public static void  Q20(){

    }

    public static void main(String [] args){
        Q1();
        Q2();
        Q3();
        Q4(20);
        Q5("this is pretty cool",4,12);
        Q6(9);
        Q7();
        Q8();
        Q9(181);
        Q10(2,3);
        Q11();
        Q12();
        Q13();
        Q14();
        Q15();
        if(args.length > 0){
            Q16(args[0]);
        }
        Q17();
        Q18();
        Q19();
        Q20();
    }
}