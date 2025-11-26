package com.spring_hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.spring_hibernate.entity.Student;

@Component
public class StudentDao {

	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Transactional
	public void saveStudent(Student student) {

		Session session = sessionFactory.getCurrentSession();
		session.persist(student);
		System.out.println("student saved successfully");	
	}
	
	 @Transactional 
		public List<Student> getAllStudents(){
			
			Session session = sessionFactory.getCurrentSession();
			List<Student> list = session.createQuery("from Student" , Student.class).list();	
			return list;	
		}
	 
	   @Transactional 
	   	public Student getStudent(int id){
	   		
	   		Session session = sessionFactory.getCurrentSession();
	   		
	   		Student student = session.find(Student.class ,id); 		
	   		return student;	
	   	}
	   	
	    @Transactional 
	   	public void removeStudent(int id){   		
   		Session session = sessionFactory.getCurrentSession();   		
	   		Student s = getStudent(id);
	   		session.remove(s);   		
	   	}
	 

}
