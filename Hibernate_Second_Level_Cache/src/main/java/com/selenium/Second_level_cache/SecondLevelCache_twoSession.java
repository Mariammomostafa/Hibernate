package com.selenium.Second_level_cache;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class SecondLevelCache_twoSession 
{
    public static void main( String[] args )
    {
    	// insert data in Student table

//      Student student = new Student();
//    	student.setSname("mrmr");
//    	student.setMarks(66);

    	
    	Student student = null ;
    	
    	Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
    	configuration.addAnnotatedClass(Student.class);
    	

    	SessionFactory factory = configuration.buildSessionFactory();
        	
    	// in different Sessions
    	
    	Session session1 = factory.openSession();
    	Transaction transaction = session1.getTransaction();
    	transaction.begin();
    	
    	// this query will hit DB to get the data for first time & save data in second-level-cache 
    	 student = (Student) session1.get(Student.class, 1);
       	student = (Student) session1.get(Student.class, 1);
      	 
       	transaction.commit();
    	session1.close();
    	
    	System.out.println("**************************************************************");
       	 
    	// in session 2 : it'll get the same data from second-level-cache which is general for all sessions & NOT hit DB again
        Session session2 = factory.openSession();
    	Transaction transaction2 = session2.getTransaction();
    	transaction2.begin();
    	
    	 student = (Student) session2.get(Student.class, 1);
    	 student = (Student) session2.get(Student.class, 1);
    	 
       	 System.out.println(student);

    	transaction2.commit();
    	session2.close();
    	
   
    }
}
