package com.revature.core.homework;

import com.revature.core.homework.abstracts.AbstractClass;

public class AbstractFun extends AbstractClass {

	@Override
	public boolean anyUpper(String str) {
		for (int i = 0; i < str.length(); i ++) {
			char ch = str.charAt(i);
			if (Character.isUpperCase(ch)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toUpper(String str) {
		return str.toUpperCase();
	}

	@Override
	public int add10(String str) {
		int parsedInt = Integer.parseInt(str);
		parsedInt += 10;
		return parsedInt;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
