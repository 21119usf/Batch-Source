package com.revature.other;

import java.util.Comparator;

public class employees implements Comparator<employees>, Comparable<employees>{
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

    public employees(String name, int age, String department){
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

    public int compareTo(employees a){
        if(a.getName().compareTo(this.getName()) != 0){
            return a.getName().compareTo(this.getName());
        }else if(a.getAge() != this.getAge()){
            return a.getAge() - this.getAge();
        }else if(a.getDepartment().compareTo(this.getDepartment()) != 0){
            return a.getDepartment().compareTo(this.getDepartment());
        }else{//same
            return 0;
        }
    }

}
