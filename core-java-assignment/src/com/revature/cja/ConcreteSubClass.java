package com.revature.cja;

public class ConcreteSubClass extends AbstractSuperClass {

	@Override
	public boolean isUppercase(String str) {
		return !str.equals(str.toLowerCase());
	}

	@Override
	public String toUppercase(String str) {
		return str.toUpperCase();
	}

	@Override
	public int addTen(int num) {
		return num + 10;
	}

}
