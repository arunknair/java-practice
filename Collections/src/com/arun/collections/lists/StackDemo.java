package com.arun.collections.lists;

import java.util.Stack;

public class StackDemo {
	public static void main(String[] args) {
		Stack stack = new Stack<>();
		stack.push("A");
		stack.push("B");
		stack.push("C");
		stack.push("D");
		stack.push("E");
		stack.push("F");
		stack.push("G");
		stack.push("A");
		stack.push("H");
		System.out.println(stack.toString());
		System.out.println(stack.peek());
		System.out.println(stack.search("A"));
	}
}
