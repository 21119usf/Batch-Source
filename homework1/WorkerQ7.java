package homework1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//Everything is in this one class
public class WorkerQ7 {
	//sets constant variables
		private int age;
	private String name;
	private String department;
	
	 public void setAge(int age) {
		this.age = age;
	}



	public void setName(String name) {
		this.name = name;
	}



	public void setDepartment(String department) {
		this.department = department;
	}


//calls super class
	public WorkerQ7() {
		super();
		// TODO Auto-generated constructor stub
	}


// redefines Worker constructor
	 WorkerQ7(int x, String y, String z ) {
		this.age = x;
		this.name = y;
		this.department = z;
		
	}
	 
	public int getAge() {
		return age;
	}
	
	public String getName() {
		return name;
	}

	public String getDepartment() {
		return department;
	}

@Override
	public String toString() {
		return "Workers: [age=" + age + ", name=" + name + ", department=" + department + "]";
	}







// comparator  to determine which age is least
 static class Comp implements Comparator<WorkerQ7>{
		
		
		@Override
	public int compare(WorkerQ7 o1, WorkerQ7 o2) {
		// TODO Auto-generated method stub
		return (int)(o1.getAge()-o2.getAge());
		}
}
 //comparator that sorts names
 static class Comp2 implements Comparator<WorkerQ7>{  

	@Override
	public int compare(WorkerQ7 o1, WorkerQ7 o2) {
		// TODO Auto-generated method stub
		return o1.name.compareTo(o2.name);
	}  
	 }  
 //comparator that sorts department
 static class Comp3 implements Comparator<WorkerQ7>{  

	@Override
	public int compare(WorkerQ7 o1, WorkerQ7 o2) {
		// TODO Auto-generated method stub
		return o1.department.compareTo(o2.department);
	}  
	 } 
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Makes the list of workers
		List<WorkerQ7>workerList = new ArrayList<WorkerQ7>();
		workerList.addAll(Arrays.asList( new WorkerQ7 []
				{
						
						new WorkerQ7(57, "Martha","Human Resources"),
						new WorkerQ7(23, "Pam","Newsroom"),
						new WorkerQ7(44, "Hank","Financing"),
						new WorkerQ7(35, "Arnold","Marketing")}
				));
		
		
		//Prints the lists of sorted works using the defined comparator classes		
		System.out.println("Original List");
		for(WorkerQ7 s : workerList)
		{
			System.out.println(s);
	}
		System.out.println("===============");
		Collections.sort(workerList, new Comp());
		System.out.println("Sorted by AGE:");
		for(WorkerQ7 s:workerList){
			System.out.println(s);
		}
		System.out.println("===============");
		System.out.println("Sorted by name");
		Collections.sort(workerList, new Comp2 ());
		for(WorkerQ7 s:workerList){
			System.out.println(s);
		}
		
		
		System.out.println("===============");
		System.out.println("Sorted by Department");
		Collections.sort(workerList, new Comp3());
		for(WorkerQ7 s:workerList){
			System.out.println(s);
		}
		
		
		
	}
		
		
	}

	
	
