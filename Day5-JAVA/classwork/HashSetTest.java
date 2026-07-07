package com.coforge.day5;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetTest {

	public static void main(String[] args) {
		Set<Integer> set = new HashSet<>();
		set.add(new Integer(10)); //Boxing
		set.add(20); //Auto Boxing
		set.add(30);
		set.add(40);
		set.add(50);
		set.add(20); //allows duplicates
		System.out.println(set);
		
		//Remove the Element
		set.remove(40); //in set we give object in remove method
		
		//Traverse without index (Enhanced for loop)
		for(Integer i : set) {
			System.out.println(i);
		}
		
		//Traverse using Iterator(used to traverse a collection one element at a time.)
		Iterator<Integer> it = set.iterator();
		while(it.hasNext()) {
			System.out.println(it.next()); // methods of iterator : hasnext(),next(),remove()
		}
		
		

	}

}
