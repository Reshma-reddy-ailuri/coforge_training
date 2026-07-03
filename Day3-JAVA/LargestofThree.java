package com.coforge.day3;

import java.util.Scanner;

public class LargestofThree {

	public static void main(String[] args) {
		int a;
		int b;
		int c;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter three numbers : ");
		a=sc.nextInt();
		b=sc.nextInt();
		c=sc.nextInt();
		if (a>b && a>c) {
			System.out.println(a+ "is greater");
		}
		else if (b<c && a<c) {
			System.out.println(c+ "is greater");
		}
		else {
			System.out.println(b+ "is greater");
		}
		sc.close();
	}

}
