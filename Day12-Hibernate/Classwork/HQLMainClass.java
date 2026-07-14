package com.coforge.main;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.coforge.model.Employee;

public class HQLMainClass {

    public static void main(String[] args) {

        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        SessionFactory factory = configuration.buildSessionFactory();
        Session session = factory.openSession();

        Transaction transaction = session.beginTransaction();
        /*
        //HQL SELECT QUERY 
        Query query = session.createQuery("from Employee");

        List<Employee> list = query.list();
        */
        
        /* 
         //HQL STATIC SELECT
         Query query = session.createQuery("from Employee where eid = 201");
        List<Employee> list = query.list();
        */
        
        /*
        //HQL Dynamic SELECT
        Query query = session.createQuery("from Employee where eid = :Id");
        query.setParameter("Id",109);
        List<Employee> list = query.list();
		*/
        
        /*
        // HQL SPECIFIC COLUMN SELECT
        Query query = session.createQuery("select ename from Employee"); 
        List<Employee> list = query.list();
        */
        
        /*
        //HQL UPDATE 
        Query query = session.createQuery(
        	    "update Employee set ename = :name where eid = :id");

        	query.setParameter("name", "ramesh");
        	query.setParameter("id", 109);

        	int n = query.executeUpdate();

        	if (n == 1)
        	    System.out.println("Employee Object Updated");
        	else
        	    System.out.println("Employee Object Not Updated");
		*/
        
        //HQL DELETE
        
        Query query = session.createQuery("delete from Employee where eid = :id");
        	query.setParameter("id", 109);

        	int n = query.executeUpdate();

        	if (n == 1)
        	    System.out.println("Employee Object Deleted");
        	else
        	    System.out.println("Employee Object Not Deleted");

        transaction.commit();
        session.close();
        factory.close();
    }

}