package com.selenium.One_To_One;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.selenium.One_To_One.Laptop;
import com.selenium.One_To_One.Student;

public class App 
{
    public static void main( String[] args )
    {
    	   	
    	Laptop laptop = new Laptop();
    	laptop.setLapName("Dell");
    	
    	Student student = new Student();
    	student.setSname("mrmr");
    	student.setMarks(66);
    	student.setLaptop(laptop);
    	
    	
    	Configuration configuration = new Configuration();
    	configuration.configure();
    	configuration.addAnnotatedClass(Laptop.class);
    	configuration.addAnnotatedClass(Student.class);
    	
    	ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();

    	
    	SessionFactory factory = configuration.buildSessionFactory(registry);
        	
    	Session session = factory.openSession();
    	
    	Transaction transaction = session.getTransaction();
    	transaction.begin();
    	
    	session.save(laptop);
    	session.save(student);
   	
    	transaction.commit();
    	session.close();
    	
   
    }
}
