package com.arun.collections.lists;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorDemo {
	public static void main(String[] args) {
		List list = new ArrayList<String>();
		list.add("Arun");
		list.add("Kiran");
		list.add("Charlie");
		list.add("Tom");
		list.add("Sam");
		System.out.println("Initial List : "+list);
		ListIterator<String>  i1 = list.listIterator();
		
		System.out.println("Going Forward : ");
		while(i1.hasNext())
		{
			System.out.println(">>"+i1.next());
		}
		
		System.out.println("Going Backward : ");
		while(i1.hasPrevious())
		{
			System.out.println(">>"+i1.previous());
		}
		
		System.out.println("GOing to 2 steps");
		int k=1;
		while(i1.hasNext()&&k<=2)
		{
			k++;
			i1.next();
		}
		System.out.println(list.get(i1.nextIndex()));
		System.out.println("Inserting John here");
		i1.add("John");
		System.out.println("Expecting John after Kiran");
		System.out.println(list);
		System.out.println("What is the previous element? Expecting : Kiran");
		System.out.println(i1.previous());
		System.out.println("Printed John beacuse pointer must have moved after inserting into position");
		
		while(i1.hasPrevious())
		{
			if(i1.previous().equals("Kiran"))
			{
				i1.set("Bedi");
			}
		}
		System.out.println("After replcing Kiran result : ");
		System.out.println(list);
	}
}
