package com.coforge.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.coforge.config.BeanConfiguration;
import com.coforge.model.Customer;
import com.coforge.model.Employee;

public class MainClass2 { //assume - this is main application it is depends on customer
	//we will create customer (dependent object) in IOC container by java code based config
	public static void main(String[] args) {
		
		//this application context is nothing but IOC container which is a type of
		//global memory where u can store all the common code (just like context in react)
		//objects are stored here and get injected when we access or use it.
		//which enables loosely coupled classes (MainClass and Employee)
		ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class);
		Customer customer = (Customer) context.getBean("customer1");
		System.out.println(customer);
		
	}
}