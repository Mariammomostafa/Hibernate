package com.selenium;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.selenium.entity.Song;

public class ObjectStatesInHibernate {

	public static void main(String[] args) {

		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();

		Transaction transaction = session.getTransaction();

		try {
			// song obj is in Transient state (NOT managed by session)
			Song song1 = new Song();

			song1.setName("mom's kids");
			song1.setArtist("yasser");
			System.out.println("Transient state : Does song obj managed by session --> " + session.contains(song1));

			transaction.begin();

			// song obj is in Persistent state (hold & managed by session)
			session.persist(song1);
			System.out.println("Persistent state : Does song obj managed by session --> " + session.contains(song1));

			// song obj is in Persistent state (hold & managed by session)
			Song song2 = session.find(Song.class, 5);
			System.out.println("Persistent state : Does song obj managed by session --> " + session.contains(song2));

			System.out.println(song2);

			// song2 obj is in Detached state (NOT hold & NOT managed by session)
			session.detach(song2);
			System.out.println("Detached state : Does song obj managed by session --> " + session.contains(song2));
			
			transaction.commit();
			 session.close();

		} catch (Exception e) {
			transaction.rollback();
		}
	}
}
