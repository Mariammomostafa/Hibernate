package com.selenium.Second_level_cache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class SecondLevelCache_oneSession 
{
    public static void main( String[] args )
    {
    	// insert data in Student table

//      Student student = new Student();
//    	student.setSname("mrmr");
//    	student.setMarks(66);

    	Student student = null ;
    	
    	Configuration configuration = new Configuration().configure();
    	configuration.addAnnotatedClass(Student.class);
    	
       // ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
    	SessionFactory factory = configuration.buildSessionFactory();
        	
    	Session session1 = factory.openSession();
    	
    	Transaction transaction = session1.getTransaction();
    	transaction.begin();
    	
    	// in the same Session
    	// this query will hit DB to get the data for first time & save data in second-level-cache
    	 student = (Student) session1.get(Student.class, 1);
       	 System.out.println(student);
    	 
       	 // to get the same data for second time , it'll get it from second-level-cache
       	 student = (Student) session1.get(Student.class, 1);
       	 System.out.println(student);
       	 
       	 
       	transaction.commit();
    	session1.close();
    	    	
   
    }
}
