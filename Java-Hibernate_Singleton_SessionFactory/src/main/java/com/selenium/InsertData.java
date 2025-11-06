package com.selenium;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.selenium.entity.Song;


public class InsertData 
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
        
        song.setName("every one know");
        song.setArtist("hanan");
        
        session.beginTransaction();
        session.persist(song);
        session.getTransaction().commit();
    }
}
