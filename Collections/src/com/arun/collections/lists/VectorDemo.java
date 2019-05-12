package com.arun.collections.lists;

import java.util.Vector;

public class VectorDemo {
	public static void main(String[] args) {
		Vector v = new Vector<>();
		v.add("ABC");
		v.add(1);
		v.add(new Object());
		System.out.println(v.capacity());
		System.out.println(v.size());
	}
}
