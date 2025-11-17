package com.selenium.Second_level_cache;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


public class SecondLevelCache_query 
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
    	
        // alternative way of get() --> custom query    
    	//student = (Student) session1.get(Student.class, 1);
    	
    	Query<Student> q1 = session1.createQuery("from Student where studentId=1" , Student.class);
    	q1.setCacheable(true);
    	student= (Student) q1.getSingleResult();
    	         	 
       	transaction.commit();
    	session1.close();
    	
    	System.out.println("**************************************************************");
       	 
    	// in session 2 : it'll get the same data from second-level-cache which is general for all sessions & NOT hit DB again
        Session session2 = factory.openSession();
    	Transaction transaction2 = session2.getTransaction();
    	transaction2.begin();
    	
    	Query<Student> q2 = session2.createQuery("from Student where studentId=1" , Student.class);
    	q2.setCacheable(true);
    	student= (Student) q2.getSingleResult();
    	
    	 
       	 System.out.println(student);

    	transaction2.commit();
    	session2.close();
    	
   
    }
}
