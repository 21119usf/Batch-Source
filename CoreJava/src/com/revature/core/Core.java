package com.revature.core;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.revature.other.SubClass;
import com.revature.other.ToImplement;
import com.revature.other.TwoFloats;
import com.revature.other.arithmetic;
import com.revature.other.employees;
import com.revature.other.implementer;

public class Core {
	 public static void bubbleSort(Integer[] toSort){
	        for(int i = 0; i < toSort.length; i++){
	            for(int j = 1; j < toSort.length - i; j++){
	                if(toSort[j-1] > toSort[j]){
	                    int tmp = toSort[j-1];
	                    toSort[j-1] = toSort[j];
	                    toSort[j] = tmp;
	                }
	            }
	        }
	    }

	    public static void  Q1(){ //Finished
	        Integer[] array = {1,0,5,6,3,2,3,7,9,8,4};
	        //Arrays.sort(array);
	        bubbleSort(array);
	        for( Integer number : array){
	            System.out.print(number + " ");
	        }
	        System.out.println();
	    }

	    public static void  Q2(){ //Finished
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

	    public static void  Q3(){ //Finished
	        String thing = "happy birthday";
	        int length = thing.length();

	        for(int i = length - 1 ; i >= 0; i--){
	            thing += thing.charAt(i);
	        }

	        //sub string begin is inclusive end is exclusive
	        thing = thing.substring(length, thing.length());
	        System.out.println(thing);
	    }
	    public static void  Q4(int N){ //Finished
	        long holder = 1;
	        for(int i = N; i > 0; i--){
	            holder *= i;
	        }
	        System.out.println(holder);
	    }

	    public static void  Q5(String passed_string,int inclusive_start, int inclusive_end){ //Finished 
	        //check to make sure start is < end
	        //do a check to make sure end is < str.len
	        String new_string = "";
	        for(int i = inclusive_start; i <= inclusive_end; i++){
	            new_string += passed_string.charAt(i);
	        }
	        System.out.println(new_string);
	    }

	    public static void  Q6(int i){ //Finished
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

	    public static void  Q7(){ //Finished
	        employees e1 = new employees("mark", 23, "HR");
	        employees e2 = new employees("mark", 23, "HR");
	        employees e3 = new employees("tom", 42, "QC");

	        System.out.println("emp comp " + e1.compare(e1, e2));
	        System.out.println("emp comp " + e3.compareTo(e2));
	    }

	    public static boolean checkPalandromes(String str){
	        for(int i = 0; i < str.length() / 2; i++){
	            if(str.charAt(i) != str.charAt(str.length() - (1 + i))){
	                return false;
	            }
	        }

	        return true;
	    }

	    public static void  Q8(){ //Finished
	        String [] names = {"Karan", "madam", "tom", "civic", "radar", "jimmy", "kayak", "john",  "refer", "billy", "did", "helleh"};
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

	    public static boolean IsPrime(int prime){
	        for(int i = 2; i < prime ;i++){
	            if(prime % i == 0){
	                return false;
	            }
	        }
	        return true;
	    }

	    public static void Q9(){ //Finished
	        System.out.println("Q9");
	        List<Integer> one_onehundred = new ArrayList<Integer>();
	        for(int i = 1; i <= 100; i++){
	            one_onehundred.add(i);
	        }
	        for(Integer num : one_onehundred){
	            if(IsPrime(num)){
	                System.out.print(num + " ");
	            }
	        }
	        System.out.println();
	    }

	    public static void  Q10(double num1, double num2){ //Finished
	        double low = num1 < num2 ? num1 : num2;
	        System.out.println(low);
	    }

	    public static void  Q11(){ //Finished
	        System.out.println("f1 " + TwoFloats.f1);
	        System.out.println("f2 " + TwoFloats.f2);
	    }
	    public static void Q12(){ //Finished
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

	    public static void  Q13(){ //Finished
	        byte num = 0;
	        for(int i = 1; i <= 4; i++){
	            for(int j = i; j > 0; j--){
	                System.out.print(num + " ");
	                num = num == 0 ? (byte) 1 : 0;
	            }
	            System.out.println();
	        }
	    }

	    public static void  Q14(){ // Finished
	        Random rn = new Random(System.currentTimeMillis()); // creates new random number generator seeded by time 
	        int rand = rn.nextInt(3);

	        switch(rand){
	            case 0:
	                System.out.println("Sqrt: " + Math.sqrt(rand));
	                break;
	            case 1:
	                java.util.Date date = new Date();
	                System.out.println("Date " + date);
	                break;
	            case 2:
	                String[] stringer = "I am learning core Java".split(" ");
	                System.out.print("Split ");
	                for(String s : stringer) {
	                	System.out.print(" " + s);
	                }
	                System.out.println();
	                break;
	            default:
	                System.out.println("Can never be printed");
	        }
	    }

	    public static void  Q15(){ //FINISHED
	    	arithmetic ar = new implementer();
	    	ar.addition();
	    	ar.division();
	    	ar.multiplication();
	    	ar.division();
	    }

	    public static void  Q16(String name){ //Finished
	        System.out.println("Q16 " + name.length());
	    }

	    public static void  Q17(){ //Finished
	        Scanner in = new Scanner(System.in);

	        double principle = 0.0f;
	        double rate = 0.0f;
	        int years = 0;

	        do{
	            System.out.println("Principle");
	            String inputString = in.next();

	            try {
	                principle = Double.parseDouble(inputString);
	                break;
	            }catch (NumberFormatException | NullPointerException e) {
	                continue;
	            }

	        }while(true);

	        do{
	            System.out.println("Rate");
	            String inputString = in.next();

	            try {
	                rate = Double.parseDouble(inputString);
	                break;
	            }catch (NumberFormatException | NullPointerException e) {
	                continue;
	            }

	        }while(true);
	        
	        do{
	            System.out.println("Time");
	            String inputString = in.next();

	            try {
	                years = Integer.parseInt(inputString);
	                break;
	            }catch (NumberFormatException e) {
	                continue;
	            }

	        }while(true);

	        double interset = principle * rate * years;

	        System.out.println("Interest " + interset);

	        interset = principle * (1 + years * rate);

	        System.out.println("Total " + interset);
	    }

	    public static void  Q18(){ //FINISHED
	    	ToImplement t1 = new SubClass("hmmm");
	    	t1.isUppercase();
	    	t1.toUpper("HASDKJBASD");
	    	t1.convertAddTen("10");
	    	try {
	    		t1.convertAddTen("catchme");
	    	}catch(Exception e) {
	    		e.printStackTrace();
	    	}
	    	
	    }

	    public static void  Q19(){ // Finished
	        List<Integer> li = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
	        int even = 0;
	        int odd = 0;
	        for(Iterator<Integer> i = li.iterator(); i.hasNext();){
	        	int val = i.next();
	        	if(val % 2 == 0) {
	        		even += val;
	        	}else {
	        		odd += val;
	        	}
	        	if(IsPrime(val)) {
	        		i.remove();
	        	}
	        }
	        
	        System.out.println("Even " + even);
	        System.out.println("Odd " + odd);
	        for(int i : li) {
	        	System.out.print(" " + i);
	        }
	        System.out.println();
	    }

	    public static void  Q20(){ //Finished
	        BufferedReader bf = null;
	        try {
	            bf = new BufferedReader(new FileReader("Data.txt"));
	            String line;
	            while((line = bf.readLine()) != null){
	                String[] options = line.split(":");
	                if(options.length != 4){
	                    System.out.println("HMMM");
	                    continue;
	                }
	                System.out.println("Name: " + options[0] + " " + options[1] );
	                System.out.println("Age: " + options[2]);
	                System.out.println("State: " + options[3] + " State");
	            }
	        }catch (FileNotFoundException e) {
	            e.printStackTrace();
	        }catch (IOException e){
	            e.printStackTrace();
	        }

	        try{
	            bf.close();            
	        }catch(IOException | NullPointerException e){
	            e.printStackTrace();
	        }

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
	        Q9();
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
