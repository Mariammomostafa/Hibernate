package com.selenium;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

public class SQL {
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
		// SQL in Hibernate called Native Queries

		System.out.println("*******************************************************");

		// SQLQuery<Student> query = session.createSQLQuery("select * from student");

			NativeQuery<Student> query = session.createSQLQuery("select * from student");

			query.addEntity(Student.class);
			
			List<Student> list = query.getResultList();
			
			for (Student student : list) {
				
				System.out.println(student);
			}
			

		System.out.println("*******************************************************");

//		
//		NativeQuery query = session.createSQLQuery("select * from student");
//
//		query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
//
//		List list = query.getResultList();
//
//		for (Object student : list) {
//
//			System.out.println(student);
//		}

		System.out.println("*******************************************************");

//			SQLQuery query = session.createSQLQuery("select sname , marks from student");
//			query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
//			
//			
//			List resultList = query.getResultList();
//			
//			for (Object student : resultList) {
//				
//				Map m = (Map) student ;
//				
//				System.out.println(m.get("sname") + " : " + m.get("marks"));
//			}

		transaction.commit();
		session.close();

	}
}
