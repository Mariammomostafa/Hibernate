package com.selenium.One_To_Many_Many_To_One;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int studentId;
	
	private String sname;
	
    private int marks ;
    
   @OneToMany(mappedBy = "student")
    private List<Laptop> Laptop;
    
    

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public List<Laptop> getLaptop() {
		return Laptop;
	}

	public void setLaptop(List<Laptop> laptop) {
		Laptop = laptop;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", sname=" + sname + ", marks=" + marks + ", Laptop=" + Laptop + "]";
	}

	
    

}
