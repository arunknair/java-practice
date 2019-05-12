package com.arun.collections.lists;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorDemo {
	public static void main(String[] args) {
		ArrayList list = new ArrayList<>();
		for(int i=0;i<11;i++)
		{
			list.add(i);
		}
		System.out.println("List : "+list);
		Iterator i = list.iterator();
		while(i.hasNext())
		{
			int k = (int)i.next();
			if(k%2==0)
			{
				System.out.println(k);
				i.remove();
			}
		}
		System.out.println("Odd List : "+list);
		Iterator<Integer> i2 = list.iterator();
		System.out.println(i2.hasNext());
//		i2.remove();
		System.out.println(list);
	}
}
