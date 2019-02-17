package com.revature.homework;

import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;



public class Q7 implements Comparator<Q7> {
    public static void main(String[] args) {
        List<Q7>Q7List= new ArrayList<Q7>();
        Q7List.addAll(Arrays.asList(
        new Q7[] {
                new Q7(" Matt", " Marketing", 32),
                new Q7(" Lenny", " Accounting", 36),
            }));
        System.out.println("Employee List: ");
        for(Q7 e:Q7List) {
            System.out.println(e);
        }
        }
    //1st Method
    private String employeeName;
    private String department;
    private int age;
    public String getEmployeeName() {
        return employeeName;
    }
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public Q7() {
        super();
        // TODO Auto-generated constructor stub
    }
    public Q7(String employeeName, String department, int age) {
        super();
        this.employeeName = employeeName;
        this.department = department;
        this.age = age;
    }
    @Override
    public String toString() {
        return "Q7 [employeeName =" + employeeName + ", department =" + department + ", age = " + age + "]";
    }
    @Override
    public int compare(Q7 arg0, Q7 arg1) {
        // TODO Auto-generated method stub
        return 0;
    }



}