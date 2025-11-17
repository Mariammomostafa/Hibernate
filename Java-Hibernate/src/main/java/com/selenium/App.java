package com.selenium;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.selenium.entity.Song;


public class App 
{
    public static void main( String[] args )
    {
    	Configuration configuration = new Configuration();
    	configuration.configure("hibernate.cfg.xml");
    	configuration.addAnnotatedClass(Song.class);
    	
    	ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
    	
    	SessionFactory factory = configuration.buildSessionFactory(registry);
    	Session session = factory.openSession();
    	  
        System.out.println( "Hello World!" );
        
        Song song = new Song();
        
       
        song.setName("hello");
        song.setArtist("mohamed");
        
        session.beginTransaction();
        session.save(song);
        session.getTransaction().commit();
    }
}
