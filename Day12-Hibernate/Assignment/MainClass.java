package com.coforge.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.coforge.model.Course;
import com.coforge.model.Student;

public class MainClass {

	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Student s1= new Student(101,"Reshma");
		Student s2 = new Student(102,"Srima");
		Student s3 = new Student(103,"Keerthi");
		
		Course c1= new Course(1,"Java");
		Course c2 = new Course(2,"Spring Boot");
		Course c3 = new Course(3,"Hibernate");
		Course c4 = new Course(4,"Angular");
		
		
		s1.getCourses() .add(c1);
		s1.getCourses() .add(c2);
		s1.getCourses() .add(c3);
		
		
		s2.getCourses() .add(c4);
		s2.getCourses() .add(c3);
		s2.getCourses() .add(c1);
		
		s3.getCourses() .add(c2);
		s3.getCourses() .add(c3);
		s3.getCourses() .add(c1);
		
		session.save(s1);
		session.save(s2);
		session.save(s3);
		
		transaction.commit();
		
		session.close();
		factory.close();
		
		System.out.println("Data Inserted Successfully");
	}

}
