package com.revature.assignment1;

import java.io.Serializable;

public class Q20Person implements Serializable{
	
	String first;
	String last;
	int age;
	String state;
	public Q20Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Q20Person(String first, String last, int age, String state) {
		super();
		this.first = first;
		this.last = last;
		this.age = age;
		this.state = state;
	}
	public String getFirst() {
		return first;
	}
	public void setFirst(String first) {
		this.first = first;
	}
	public String getLast() {
		return last;
	}
	public void setLast(String last) {
		this.last = last;
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
		return "Q20Person [first=" + first + ", last=" + last + ", age=" + age + ", state=" + state + "]";
	}
	
	

}
