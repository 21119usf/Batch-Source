package com.revature.Q20;

/*
 * POJO Person 
 */

public class Person {
	private String nameFirst;
	private String nameLast;
	private int age;
	private String state;
	
	public Person() {
		super();
	}
	public Person(String nameFirst, String nameLast, int age, String state) {
		super();
		this.nameFirst = nameFirst;
		this.nameLast = nameLast;
		this.age = age;
		this.state = state;
	}
	public String getNameFirst() {
		return nameFirst;
	}
	public void setNameFirst(String nameFirst) {
		this.nameFirst = nameFirst;
	}
	public String getNameLast() {
		return nameLast;
	}
	public void setNameLast(String nameLast) {
		this.nameLast = nameLast;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Name: "+nameFirst+" "+nameLast+" \nAge:"+age+"\nState: "+state+" State\n";
	}
	@Override
	public boolean equals(Object arg0) {
		if(!(arg0 instanceof Person)) {
			return false;
		}
		Person p = (Person)arg0;
		if(!(this.nameFirst.equals(p.nameFirst))) {
			return false;
		}
		if(!(this.nameLast.equals(p.nameLast))) {
			return false;
		}
		if(!(this.age == p.age)) {
			return false;
		}
		if(!(this.state.equals(p.state))) {
			return false;
		}
		return true;
	}
	
}
