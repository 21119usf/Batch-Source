package first.half;

import java.util.Comparator;

import beans.Employee;

public class EmployeeComparatorByName implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		return (o1.getName().compareTo(o2.getName()));
	}
	
	

}
