package com.revature.core.homework;

import com.revature.core.homework.floatPack.MyFloatClass;

// #11
public class FloatTest {
	public static float getXFloat() {
		return MyFloatClass.x;
	}
	
	public static float getYFloat() {
		return MyFloatClass.y;
	}
	
	public static void main(String[] args) {
		System.out.println(FloatTest.getXFloat());
		System.out.println(FloatTest.getYFloat());
	}
}
