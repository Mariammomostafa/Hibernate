package com.spring_hibernate;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring_hibernate.config.DBConfig;
import com.spring_hibernate.dao.StudentDao;
import com.spring_hibernate.entity.Student;


public class App {
	
		
    public static void main( String[] args )
    
    {
    	AnnotationConfigApplicationContext container = new AnnotationConfigApplicationContext(DBConfig.class);
    	
    	StudentDao studentDao=container.getBean("studentDao",StudentDao.class );

		
    	List<Student> students = studentDao.getAllStudents();
    	
    	for (Student student : students) {
			
    		System.out.println(student);
		}
    	
    	container.close();
    }
}
