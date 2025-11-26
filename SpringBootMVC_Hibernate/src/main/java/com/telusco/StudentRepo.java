package com.telusco;

import org.springframework.data.jpa.repository.JpaRepository;

import com.telusco.model.Student;


public interface StudentRepo extends JpaRepository<Student, Integer>{

}
