//current package
package core.java.core_questions;
//import collections
import java.util.ArrayList;
import java.util.Collections;
//import inner classes
import core.java.extra_classes_interfaces.*;
//create class for question7
public class question7 {
	  //create your fields
	  public String name;
	  public int age;
	  public String department;
	  //create your contructor to implement name, age, department
	  question7(String name, int age, String department){
		  this.name = name; 
		  this.age = age; 
		  this.department = department; 
	  }
	  //print your objects, very import at the moment of printing out
	  public String toString(){
		    return this.name + " " + this.age + " " + this.department;
		  }
	//main method to execute the sorting according to the type of field
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		  ArrayList<question7> ar = new ArrayList<question7>();
		  	//fill your array list with two employees
		    ar.add(new question7("zeorge", 19, "109 Semoran Av"));
		    ar.add(new question7("Hanz", 21, "108 Colonial Av"));
		    
		    //print unsorted array list
		    System.out.println("\nUnsorted");
		    for(int i = 0; i < ar.size(); i++){
		      System.out.println(ar.get(i));
		    }
		    
		    //print array list by name
		    Collections.sort(ar, new SortByName_question7());
		    System.out.println("\nSorted by Name");
		    for(int i = 0; i < ar.size(); i++){
		      System.out.println(ar.get(i));
		    }
		    //print array list by department
		    Collections.sort(ar, new SortByDepartment_question7());
		    System.out.println("\nSorted by Department");
		    for(int i = 0; i < ar.size(); i++){
		      System.out.println(ar.get(i));
		    }
		    //print array list by age
		    Collections.sort(ar, new SortByAge_question7());
		    System.out.println("\nSorted by Age");
		    for(int i = 0; i < ar.size(); i++){
		      System.out.println(ar.get(i));
		    }
	}
}
