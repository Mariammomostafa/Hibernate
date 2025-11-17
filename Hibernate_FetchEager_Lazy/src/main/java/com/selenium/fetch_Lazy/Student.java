package com.selenium.fetch_Lazy;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
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
    
    // by default fetch is Lazy --> means will NOT fetch related laptops
    
   @OneToMany(mappedBy = "student" , fetch = FetchType.LAZY )
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

	// when print student with laptop --> it'll fire select query for laptop to get laptops specific to this student
//	@Override
//	public String toString() {
//		return "Student [studentId=" + studentId + ", sname=" + sname + ", marks=" + marks + ", Laptop=" + Laptop + "]";
//	}
	
	
	// when print student without laptop --> it'll NOT fire any select query for laptop until getLaptop() & print them 

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", sname=" + sname + ", marks=" + marks + "]";
	}


	
	

	

	
    

}
