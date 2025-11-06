package com.selenium;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	
	static SessionFactory factory = null;
	
	public static SessionFactory getSessionFactory() {
		
		//Singleton Design Pattern
		// this condition to return always the same SessionFactory & NOT create new one every call
		if(factory == null) {
			
			Configuration configuration = new Configuration();
	    	configuration.configure("hibernate.cfg.xml");
	    	//configuration.addAnnotatedClass(Song.class);
	    	  	
	    	
	    	factory = configuration.buildSessionFactory();
		}
		
		return factory;
	}

}
