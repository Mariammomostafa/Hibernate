package com.selenium;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.selenium.entity.Song;


public class updateData 
{
    public static void main( String[] args )
    {
    	
    	SessionFactory factory = HibernateUtils.getSessionFactory();
    	Session session = factory.openSession();
              
        Song song = session.find(Song.class , 2);
        song.setName("hello>??????.....nnnn....world hello!!!world");
        
        session.beginTransaction();
        session.persist(song);
        session.getTransaction().commit();
    }

	
}
