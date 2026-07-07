package com.coforge.day5;

import java.util.Map.Entry;
import java.util.Collections;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapTest {

	public static void main(String[] args) {
		TreeMap<Integer, String> map = new TreeMap<>(Collections.reverseOrder());//collections.reverseOrder help us sort in descending order
		map.put(10, "Java");
		map.put(5, "Python");
		map.put(20, "Angular");
		map.put(30, "React");
		System.out.println(map); 
		map.put(30, "C++"); 
		System.out.println(map);
		map.remove(20);
		System.out.println(map);

		System.out.println(map.get(10));
		
		// Traversing map --easy way
		Set<Integer> keys = map.keySet();
		for(Integer key : keys) {
			System.out.println(key + "=>" + map.get(key)); //sorts in ascending orders
		}
		
		// Traversing map collection using entry set --returns both key and values
		Set<Entry<Integer, String>> entries = map.entrySet();
		for (Entry entry : entries) {
			System.out.println(entry.getKey()+ "=>" + entry.getValue());
		}
		
	}

}
