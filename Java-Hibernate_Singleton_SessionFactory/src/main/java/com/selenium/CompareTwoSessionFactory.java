package com.selenium;

import org.hibernate.SessionFactory;

public class CompareTwoSessionFactory {

	
	public static void main(String[] args) {
		
		// without condition inside getSessionFactory() , two factories are different
		SessionFactory factory1 = HibernateUtils.getSessionFactory();
		SessionFactory factory2 = HibernateUtils.getSessionFactory();
		
	    System.out.println(factory1 +" -- "+ factory2);
	}
}
