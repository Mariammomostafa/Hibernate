package com.selenium;


import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.selenium.entity.Song;


public class DeleteData 
{
    public static void main( String[] args )
    {
    	
    	SessionFactory factory = HibernateUtils.getSessionFactory();
    	Session session = factory.openSession();
              
        Song song = session.find(Song.class , 12);
               
        session.beginTransaction();
        session.remove(song);
        System.out.println("Song deleted successfully");
        session.getTransaction().commit();
    }

	
}
