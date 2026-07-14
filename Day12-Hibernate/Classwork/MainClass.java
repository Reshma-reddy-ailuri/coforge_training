package com.coforge.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.coforge.model.Employee;

public class MainClass {

	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Employee employee = new Employee(102,"srima",50000,20);
		//session.save(employee); //INSERT
		//session.update(employee); //UPDATE
		//Employee emp = session.get(Employee.class, 109); //SELECT QUERY
		//System.out.println(emp);
		//session.delete(employee); //DELETE QUERY
		transaction.commit();
		session.close();
		factory.close();
		
		System.out.println("Employee Object Deleted");
	}

}
