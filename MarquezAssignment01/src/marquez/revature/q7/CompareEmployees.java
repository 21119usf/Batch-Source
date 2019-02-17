package marquez.revature.q7;

import java.util.ArrayList;
import java.util.Collections;

/* Sort two employees based on their name, department, and age using the
 * Comparator interface.
 */

public class CompareEmployees
{
	private String name;
	private String department;
	private int age;
	
	public CompareEmployees(String name, String department, int age)
	{
		this.name = name;
		this.department = department;
		this.age = age;
	}
	
	public String getName() {return name;}

	public String getDepartment() {return department;}

	public Integer getAge() {return age;}
	
	@Override
	public String toString() {
		return "CompareEmployees [name=" + name + ", department=" + department + ", age=" + age + "]";
	}

	public static void main(String[] args) 
	{
		ArrayList<CompareEmployees> employees = new ArrayList<CompareEmployees>();
		employees.add(new CompareEmployees("Miguel", "Revature", 22));
		employees.add(new CompareEmployees("John", "Aveture", 23));
		
		System.out.println("List before sort");
		for(CompareEmployees e : employees)
		{
			System.out.println(e);
		}
		System.out.println("===============================================================");
		System.out.println("List sorted by name");
		Collections.sort(employees, (arg0,arg1)
				->{return arg0.getName().compareTo(arg1.getName());}
				);
		for(CompareEmployees e : employees)
		{
			System.out.println(e);
		}
		System.out.println("===============================================================");
		System.out.println("List sorted by department");
		Collections.sort(employees, (arg0,arg1)
				->{return arg0.getDepartment().compareTo(arg1.getDepartment());}
				);
		for(CompareEmployees e : employees)
		{
			System.out.println(e);
		}
		System.out.println("===============================================================");
		System.out.println("List sorted by age");
		Collections.sort(employees, (arg0,arg1)
				->{return arg0.getAge()-arg1.getAge();}
				);
		for(CompareEmployees e : employees)
		{
			System.out.println(e);
		}
		System.out.println("===============================================================");
	}
}
