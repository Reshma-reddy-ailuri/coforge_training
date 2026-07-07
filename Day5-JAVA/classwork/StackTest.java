package com.coforge.day5;

import java.util.Stack;

public class StackTest {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack();
		stack.push(10); // adds element to stack
		stack.push(20);
		stack.push(30);
		System.out.println(stack);
		stack.pop();
		System.out.println(stack); // removes top element (last pushed element)
		System.out.println(stack.peek()); // displays top element
        
		
	}

}
