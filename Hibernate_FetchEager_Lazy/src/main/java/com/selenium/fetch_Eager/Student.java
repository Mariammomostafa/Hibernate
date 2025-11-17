package com.selenium.fetch_Eager;

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
    
   @OneToMany(mappedBy = "student" , fetch = FetchType.EAGER)
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

	// whether we print student with laptop or NOT --> it'll fire ONLY one select query for student & laptop to get both
	
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", sname=" + sname + ", marks=" + marks + "]";
	}

//	@Override
//	public String toString() {
//		return "Student [studentId=" + studentId + ", sname=" + sname + ", marks=" + marks + ", Laptop=" + Laptop + "]";
//	}

	

	
    

}
