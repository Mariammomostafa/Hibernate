package springmvctest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import springmvctest.dao.StudentDao;
import springmvctest.model.Student;


@Controller
public class HomeController {
	
	@Autowired
	private StudentDao dao;
	
	@RequestMapping("/")
	public String home() {
		
		
		return "index";
	}
	
	
	@ModelAttribute
	public void globalAttribute(Model model) {
		
		model.addAttribute("greet", "Welcome Back Students");
		
	}
	
	// use @ModelAttribute which assign student obj automatically to it To be transfered to jsp page
	
	@PostMapping("addStudent")
	public String add(@ModelAttribute("output") Student s ) {
				
		dao.save(s);
		
		return "result";
	}
	
	@GetMapping("getAllStudents")
	public String getStudents(Model model) {
		
		List<Student> students = dao.getAllStudents();
		model.addAttribute("studentList", students);
		
		return "viewList";
	}
	
	
	@GetMapping("getStudent")
	public String getStudent(Model model ,@RequestParam("id") int id ) {
		
        Student student = dao.getStudent(id);
		model.addAttribute("student", student);
		
		return "viewList";
	}
	
	
//	@RequestMapping("addStudent")
//	public String add(@RequestParam("id") int id ,@RequestParam("name") String name , Model model ) {
//		
//		Student s = new Student();
//		s.setId(id);
//		s.setName(name);
//		
//		model.addAttribute("output", s);
//			
//		return "result";
//	}
	
	
	

}
