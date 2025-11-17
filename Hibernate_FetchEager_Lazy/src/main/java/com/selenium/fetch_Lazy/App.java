package com.selenium.fetch_Lazy;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


public class App 
{
    public static void main( String[] args )
    {
    	   	
//    	Laptop laptop1 = new Laptop();
//    	laptop1.setLapName("Dell");
//    	
//    	Laptop laptop2 = new Laptop();
//    	laptop2.setLapName("Nokia");
//    	
//    	List<Laptop> laptops = new ArrayList<>();
//    	laptops.add(laptop1);
//    	laptops.add(laptop2);
//    	
//        Student student = new Student();
//    	student.setSname("mrmr");
//    	student.setMarks(66);
//    	student.setLaptop(laptops);
//    	
//    	laptop1.setStudent(student);
//    	laptop2.setStudent(student);
    	
    	Configuration configuration = new Configuration().configure();
    	configuration.addAnnotatedClass(Laptop.class).addAnnotatedClass(Student.class);
    	
    	ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();

    	SessionFactory factory = configuration.buildSessionFactory(registry);        	
    	Session session = factory.openSession();
    	
    	Transaction transaction = session.getTransaction();
    	transaction.begin();
    	
    	Student student = (Student) session.get(Student.class, 1);
    	System.out.println(student);

    	   	
       	List<Laptop> laps = student.getLaptop();
    	
    	for(Laptop lap :laps) {
    		
    		System.out.println(lap);
    	}
    	transaction.commit();
    	session.close();
    	
   
    }
}
