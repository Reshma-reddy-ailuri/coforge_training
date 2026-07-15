package com.coforge.config;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.coforge.model.Address;
import com.coforge.model.Student;

@Configuration
public class BeanConfiguration {
	
	@Bean(name="address")
	public Address address() {
		Address address = new Address();
		address.setCity("City-1");
		address.setState("State-1");
		return address;
	}
	@Bean(name="student")
	public Student getStudent() {
		Student student = new Student();
		student.setSid(101);
		student.setSname("Rahul Sharma");
		student.setAddress(address());
		student.setSubjects(Arrays.asList("Java","Spring Core","Hibernate","MySQL","React"));
		student.setTechnicalSkills(new HashSet<String> (
				Arrays.asList("Communication","Problem Solving","Team Work","Java")));
		Map<String,Integer> marks = new HashMap <String,Integer>();
		marks.put("Java" , 95);
		marks.put("Spring Core" , 90);
		marks.put("Hibernate" , 88);
		marks.put("My SQL" , 92);
		marks.put("React" , 85);
		
		student.setMarks(marks);
		return student;
	}

}
