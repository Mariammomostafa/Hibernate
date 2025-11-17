package com.selenium.Many_To_Many;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class App {
	public static void main(String[] args) {

		Laptop laptop1 = new Laptop();
		laptop1.setLapName("Dell");

		Laptop laptop2 = new Laptop();
		laptop2.setLapName("Dell");

		List<Laptop> laptops = new ArrayList<>();
		laptops.add(laptop1);
		laptops.add(laptop2);

		Student student1 = new Student();
		student1.setSname("mrmr");
		student1.setMarks(66);
		student1.setLaptop(laptops);

		Student student2 = new Student();
		student2.setSname("mrmr");
		student2.setMarks(66);
		student2.setLaptop(laptops);

		List<Student> studs = new ArrayList<>();
		studs.add(student1);
		studs.add(student2);

		laptop1.setStudents(studs);
		laptop2.setStudents(studs);

		Configuration configuration = new Configuration().configure();
		configuration.addAnnotatedClass(Laptop.class).addAnnotatedClass(Student.class);

		ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(configuration.getProperties())
				.buildServiceRegistry();

		SessionFactory factory = configuration.buildSessionFactory(registry);
		
		Session session = factory.openSession();
		Transaction transaction = session.getTransaction();
		transaction.begin();

		session.save(student1);
		session.save(student2);

		session.save(laptop1);
		session.save(laptop2);

		transaction.commit();
		session.close();

	}
}
