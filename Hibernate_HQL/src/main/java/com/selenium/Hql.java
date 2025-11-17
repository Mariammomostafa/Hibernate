package com.selenium;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class Hql {
	public static void main(String[] args) {

		Configuration configuration = new Configuration().configure();
		configuration.addAnnotatedClass(Student.class);

		SessionFactory factory = configuration.buildSessionFactory();

		Session session = factory.openSession();

		Transaction transaction = session.getTransaction();
		transaction.begin();

		// to insert some data

//    	Random r= new Random();
//    	
//    	for (int i = 1; i <10; i++) {
//			
//    		Student student =new Student();
//    		student.setSname("Name "+ i);
//    		student.setMarks(r.nextInt(100));
//    		
//    		session.persist(student);
//		}
//    	

		System.out.println("*******************************************************");

		// return all rows of table

    	Query<Student> query = session.createQuery("from Student" , Student.class);
    	List<Student> list = query.list();
    	
    	for (Student student : list) {
			
    		System.out.println(student);
		}
    	

		System.out.println("*******************************************************");

		// select specific columns which return List of array of Object

//    	Query<Object[]> q = session.createQuery("select studentId ,  sname , marks from Student " , Object[].class);
//
//    	 List<Object[]> list = q.list();
//    	
//    	for (Object[] obj : list) {
//			
//    		System.out.println(obj[0] + " : " + obj[1] +" : " + obj[2]);
//		}

		System.out.println("*******************************************************");

		// to return sum of some marks which is single value
		Query<Object> q = session.createQuery("select sum(marks) from Student where marks > 50", Object.class);
		Object marks = q.uniqueResult();

		System.out.println(" total marks : " + marks);

		System.out.println("*******************************************************");

		// use dynamic values

//		int a = 50;
//
//		// to return sum of some marks which is single value
//		Query<Object> q = session.createQuery("select sum(marks) from Student where marks > :value", Object.class);
//
//		q.setParameter("value", a);
//
//		Object marks = q.uniqueResult();
//
//		System.out.println(" total marks : " + marks);

		transaction.commit();
		session.close();

	}
}
