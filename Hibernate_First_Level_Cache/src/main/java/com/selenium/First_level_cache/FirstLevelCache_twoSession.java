package com.selenium.First_level_cache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


public class FirstLevelCache_twoSession 
{
    public static void main( String[] args )
    {
    	// insert data in Student table

//      Student student = new Student();
//  	student.setSname("mrmr");
//  	student.setMarks(66);
    	
    	Student student = null ;
    	
    	Configuration configuration = new Configuration().configure();
    	configuration.addAnnotatedClass(Student.class);
    	
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();

    	
    	SessionFactory factory = configuration.buildSessionFactory(reg);
        	
    	// in different Sessions
    	
    	Session session1 = factory.openSession();
    	Transaction transaction = session1.getTransaction();
    	transaction.begin();
    	
    	// this query will hit DB to get the data for first time & save data in first-level-cache of session 1
    	 student = (Student) session1.get(Student.class, 1);
       	student = (Student) session1.get(Student.class, 1);
      	 
       	transaction.commit();
    	session1.close();
    	
    	System.out.println("**************************************************************");
       	 
    	// as session 2 can NOT get data from first-level-cache of session 1 , this query will hit DB to get the data for first time & save data in first-level-cache of session 2
        Session session2 = factory.openSession();
    	Transaction transaction2 = session2.getTransaction();
    	transaction2.begin();
    	
    	 student = (Student) session2.get(Student.class, 1);
    	 student = (Student) session2.get(Student.class, 1);
    	 
    	transaction2.commit();
    	session2.close();
    	
   
    }
}
