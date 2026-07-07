package com.coforge.day5;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LinkedListTest {

	public static void main(String[] args) {
		List<Integer> list = new LinkedList<>();
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
		
		
		/*
		 Interview Answer

         Question: Why do we need both ArrayList and LinkedList if the code and output are the same?

         Answer:

         The code and output can be the same because both implement the List interface, but their internal data structures are different.

         ArrayList uses a dynamic array, so accessing elements by index is fast, but inserting or deleting elements in the middle is slower because other elements must be shifted.
         LinkedList uses a doubly linked list, so inserting or deleting elements is faster because only node links are updated, but accessing elements by index is slower because it must traverse the list.

         So, we have both classes because each is optimized for different types of operations. Choosing the right one depends on your application's needs, not on whether the code or output looks the same.
		 */

	}

}
