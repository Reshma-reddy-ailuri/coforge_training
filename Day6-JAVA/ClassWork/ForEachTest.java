package day6.java8.features;

import java.util.Arrays;
import java.util.List;

public class ForEachTest {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(11,20,30,40);
		// for one statement
		list.forEach(n -> System.out.println(n));
		System.out.println("---------");
		
		//for multiple statements
		list.forEach(n -> {
			if(n%2==0)
				System.out.println(n);
		});
		
		System.out.println("---------");
		
		//method reference
		list.forEach(System.out::println);
	}

}
