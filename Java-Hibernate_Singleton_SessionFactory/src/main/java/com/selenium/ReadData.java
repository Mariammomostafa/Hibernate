package com.selenium;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.selenium.entity.Song;


public class ReadData 
{
    public static void main( String[] args )
    {
    	Configuration configuration = new Configuration();
    	configuration.configure("hibernate.cfg.xml");
    	configuration.addAnnotatedClass(Song.class);
    	  	
    	
    	SessionFactory factory = configuration.buildSessionFactory();
    	Session session = factory.openSession();
    
        System.out.println( "Hello World!" );
                      
        session.beginTransaction();
        Song song = session.find(Song.class , 4);
        
        System.out.println(song);
        session.getTransaction().commit();
    }
}
