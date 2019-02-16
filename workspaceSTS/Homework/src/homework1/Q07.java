package homework1;
//DONE
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Q07 {
	//Sort two employees based on their name, department, and age using the Comparator interface.
	
	public static class Employee {
		String name;
		String department;
		int age;

		public Employee(String name, String department, int age) {
			this.name = name;
			this.department = department;
			this.age = age;
		}
		
		public String toString() {
			return "Name:\t" + this.name
					+ "\nDept:\t" + this.department
					+ "\nAge:\t" + this.age;
		}
	}
	
	public static class compareNames implements Comparator<Employee> {
		public int compare(Employee a, Employee b) {
			return a.name.compareTo(b.name);
		}
	}
	
	public static class compareDepartments implements Comparator<Employee> {
		public int compare(Employee a, Employee b) {
			return a.department.compareTo(b.department);
		}
	}
	
	public static class compareAges implements Comparator<Employee> {
		public int compare(Employee a, Employee b) {
			return a.age - b.age;
		}
	}
	
	public static void main(String[] args) {
		ArrayList<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee("Mark Venegas", "Computer Science", 24));
		employees.add(new Employee("Erik Venegas", "Mathematics", 17));
		employees.add(new Employee("Mark Merril", "Aerospace Engineering", 23));
		employees.add(new Employee("Elisa Venegas", "Computer Engineering", 42));
		employees.add(new Employee("Luis Venegas", "Math", 42));
		
		System.out.println("Unsorted");
		for (Employee e: employees)
			System.out.println(e);
		
		Collections.sort(employees, new compareNames());
		System.out.println("\nSorted by Name");
		for (Employee e: employees)
			System.out.println(e);

		Collections.sort(employees, new compareDepartments());
		System.out.println("\nSorted by Department");
		for (Employee e: employees)
			System.out.println(e);
		
		Collections.sort(employees, new compareAges());
		System.out.println("\nSorted by Age");
		for (Employee e: employees)
			System.out.println(e);
		
	}
}
