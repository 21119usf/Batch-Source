// David Lavoie Revature Assignment 1 Q7
package q7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Defines an employee by three fields to be sorted over
 * The comparator interface was implemented in three other classes,
 * defining compare methods for each of the fields of interest
 * @author David Lavoie
 *
 */
public class Employee {
	
	int age;
	String name, department;
	
	// constructor
	public Employee(String name, String department, int age) {
		this.name = name;
		this.department = department;
		this.age = age;
	}
	
	public String toString() {
		return this.name + " " + this.department  + " " + this.age;
	}
}


class SortByName implements Comparator<Employee> {
	// Used for sorting in alphabetic order of name
    public int compare(Employee a, Employee b) 
    { 
        return a.name.compareTo(b.name); 
    }
}

class SortByDepartment implements Comparator<Employee> {
	// Used for sorting in alphabetic order of department
    public int compare(Employee a, Employee b) 
    { 
        return a.department.compareTo(b.department); 
    }
}

class SortByAge implements Comparator<Employee> {
	// Used for sorting in ascending order of age
    public int compare(Employee a, Employee b) 
    { 
        return a.age - b.age; 
    }
}

// Sanity check via driver
class Driver {
	public static void main(String[] args) {
		ArrayList<Employee> fu = new ArrayList<Employee>();
		fu.add(new Employee("David", "CHMS", 26));
		fu.add(new Employee("Arnold", "IEEE", 76));
		fu.add(new Employee("Baker", "Zoo", 22));
		fu.add(new Employee("Christopher", "AMS", 50));
		
		System.out.println("Unsorted");
		for (int i=0; i<fu.size(); i++) 
            System.out.println(fu.get(i));
		

		System.out.println("\nSorted by name");
		Collections.sort(fu, new SortByName());
		for (int i=0; i<fu.size(); i++) 
            System.out.println(fu.get(i));
		
		System.out.println("\nSorted by department");
		Collections.sort(fu, new SortByDepartment());
		for (int i=0; i<fu.size(); i++) 
            System.out.println(fu.get(i));
		
		System.out.println("\nSorted by age");
		Collections.sort(fu, new SortByAge());
		for (int i=0; i<fu.size(); i++) 
            System.out.println(fu.get(i));
	}
}
