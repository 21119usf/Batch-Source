package first.half;

import java.util.Comparator;

import beans.Employee;

public class EmployeeComparatorByAge implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		return (int)(o1.getAge() * 100 - o2.getAge() * 100);
	}
	
	

}
