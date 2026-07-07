package day6.java8.features;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Java8StreamTest {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(11, 12, 13, 14, 15);

		// list is an initial operation,filter is an intermediate operation and collect
		// is a termination operation

		List<Integer> even = list.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
		System.out.println(even);

		long countn = list.stream().filter(n -> n % 2 == 0).count();
		System.out.println(countn);

		list.stream().filter(n -> n % 2 == 0).forEach(System.out::println);

		// using 2 intermediate operations filter,map together
		list.stream().filter(n -> n % 2 == 0).map(n -> n * 2).forEach(System.out::println);

		List<String> names = Arrays.asList("Reshma", "Srima", "madhureddy", "ram");
		// names which have m letter display
		names.stream().filter(s -> s.contains("m")).forEach(System.out::println);

		// names which have m letter their name length
		names.stream().filter(s -> s.contains("m")).map(s -> s.length()).forEach(System.out::println);
		
		// put acts as insert and update in map
		Map<Integer, String> map = names.stream().collect(Collectors.toMap(x -> x.length() , x -> x));
		System.out.println(map);
		Date date = new Date();
		System.out.println(date);
		
		LocalDate dat = LocalDate.now();
		System.out.println(dat);
		
		LocalTime time = LocalTime.now();
		System.out.println(time);
		
		

	}

}
