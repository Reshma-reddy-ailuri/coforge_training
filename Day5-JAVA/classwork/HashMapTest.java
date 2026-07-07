package com.coforge.day5;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapTest {

	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<>();
		map.put(10, "Java");
		map.put(5, "Python");
		map.put(20, "Angular");
		map.put(30, "React");
		System.out.println(map); // no order for hashmap
		map.put(30, "C++"); // if you give existing key it updates
		System.out.println(map);
		map.remove(20); // removes complete key
		System.out.println(map);

		System.out.println(map.get(10));
		
		// Traversing map --easy way
		Set<Integer> keys = map.keySet();
		for(Integer key : keys) {
			System.out.println(key + "=>" + map.get(key));
		}
		
		// Traversing map collection using entry set --returns both key and values
		Set<Entry<Integer, String>> entries = map.entrySet();
		for (Entry entry : entries) {
			System.out.println(entry.getKey()+ "=>" + entry.getValue());
		}
		
	}

}
