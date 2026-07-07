package com.coforge.day5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListTest {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(new Integer(10)); //Boxing
		list.add(20); //Auto Boxing
		list.add(30);
		list.add(40);
		list.add(50);
		list.add(20); //allows duplicates
		System.out.println(list);
		System.out.println(list.get(2)); // o/p=30
		
		//Remove the Element
		list.remove(4);
		System.out.println(list);
		
		//Update the Element
		list.set(3, 90);
		System.out.println(list);
		
		//Traverse (works only for list but not for set because set is not index based)
		for(int i = 0; i<list.size();i++) {
			System.out.println(list.get(i));
		}
		
		//Traverse without index (Enhanced for loop)
		for(Integer i : list) {
			System.out.println(list);
		}
		
		//Traverse using Iterator(used to traverse a collection one element at a time.)
		Iterator<Integer> it = list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next()); // methods of iterator : hasnext(),next(),remove()
		}
		
		

	}

}
