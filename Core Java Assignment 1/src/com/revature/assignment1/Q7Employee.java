package com.revature.assignment1;

public class Q7Employee implements Comparable<Q7Employee>{
		//class variables
		int age;
		int eID;
		String dept;
		
		public Q7Employee() {//constructor using super
			super();
		}

		public Q7Employee(int age, int eID, String dept) {//constructor using fields
			super();
			this.age = age;
			this.eID = eID;
			this.dept = dept;
		}

		//the following are accessors and mutators to set and retrieve the value of each field for the object	
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public int geteID() {
			return eID;
		}
		public void seteID(int eID) {
			this.eID = eID;
		}
		public String getDept() {
			return dept;
		}
		public void setDept(String dept) {
			this.dept = dept;
		}

		@Override
		public String toString() {//a toString to print the display
			return "Employee [age=" + age + ", eID=" + eID + ", dept=" + dept + "]";
		}


		@Override//this method was an overridden method implementing the comparable interface
		public int compareTo(Q7Employee arg0) {
			// TODO Auto-generated method stub
			return this.getAge()-arg0.getAge();
		}
		
		
	}


