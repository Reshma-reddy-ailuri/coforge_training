package com.coforge.day5;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

// vector is a legacy once,we don't use it much nowadays
public class VectorTest {

	public static void main(String[] args) {
		Vector<Integer> vector = new Vector<>();
		Vector<Integer> Vector;
		vector.add(new Integer(10)); // Boxing
		vector.add(20); // Auto Boxing
		vector.add(30);
		vector.add(40);
		vector.add(50);
		vector.add(20); // allows duplicates
		System.out.println(vector);
		System.out.println(vector.get(2)); // o/p=30

		// Remove the Element
		vector.remove(4);
		System.out.println(vector);

		// Update the Element
		vector.set(3, 90);
		System.out.println(vector);

		// Traverse (works only for list but not for set because set is not index based)
		for (int i = 0; i < vector.size(); i++) {
			System.out.println(vector.get(i));
		}

		// Traverse without index (Enhanced for loop)
		for (Integer i : vector) {
			System.out.println(vector);
		}

		// Traverse using Iterator(used to traverse a collection one element at a time.)
		Iterator<Integer> it = vector.iterator();
		while (it.hasNext()) {
			System.out.println(it.next()); // methods of iterator : hasnext(),next(),remove()
		}

		// Traverse using enumeration
		Enumeration<Integer> e = vector.elements();

	}

}
