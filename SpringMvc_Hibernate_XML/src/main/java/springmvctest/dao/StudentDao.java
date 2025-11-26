package springmvctest.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import springmvctest.model.Student;


@Component
public class StudentDao {
	

	@Autowired
	private SessionFactory sessionFactory;
	
   @Transactional 
	public List<Student> getAllStudents(){
		
		Session session = sessionFactory.getCurrentSession();
		List<Student> list = session.createQuery("from Student" , Student.class).list();
		
		return list;
		
	}
	
    @Transactional 
	public void save(Student student) {
		
		Session session = sessionFactory.getCurrentSession();
		session.persist(student);

		System.out.println("student saved Successfully....");
		
	}
    
    
    @Transactional 
   	public Student getStudent(int id){
   		
   		Session session = sessionFactory.getCurrentSession();
   		
   		Student student = session.get(Student.class ,id);
   		
   		return student;
   		
   	}
   	
    

}
