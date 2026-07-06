package com.coforge.day4.abstraction;

public class Test implements C{

	public static void main(String[] args) {
		Test test = new Test();
		test.sum();

	}
	@Override
	public void sum() {
		System.out.println(A.a+B.a);//static method can be called without an object(calling it with help of interface)
	}
	

}
