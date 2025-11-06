package com.selenium;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.selenium.entity.Song;


public class App 
{
    public static void main( String[] args )
    {
    	Configuration configuration = new Configuration();
    	configuration.configure("hibernate.cfg.xml");
    	configuration.addAnnotatedClass(Song.class);
    	  	
    	
    	SessionFactory factory = configuration.buildSessionFactory();
    	Session session = factory.openSession();
    
        System.out.println( "Hello World!" );
        
        Song song = new Song();
        
        song.setId(1);
        song.setName("hello");
        song.setArtist("mohamed");
        
        session.beginTransaction();
        session.persist(song);
        session.getTransaction().commit();
    }
}
