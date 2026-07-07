package com.coforge.day5;

import java.util.Iterator;

public class TreeSetTest {
    public static void main(String[] args) {

        java.util.TreeSet<Integer> set = new java.util.TreeSet<>();

        set.add(10);
        set.add(20);
        set.add(30);
        set.add(40);
        set.add(50);

        System.out.println(set);

        // Remove element
        set.remove(40);

        System.out.println("After removing 40:");
        System.out.println(set);

        // Enhanced for loop
        System.out.println("Using for-each:");
        for (Integer i : set) {
            System.out.println(i);
        }

        // Iterator
        System.out.println("Using Iterator:");
        Iterator<Integer> it = set.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
