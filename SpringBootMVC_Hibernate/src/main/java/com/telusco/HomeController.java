package com.telusco;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.telusco.model.Student;

@Controller
public class HomeController {
	
	@Autowired
	private StudentRepo studentRepo;
	
	
	@RequestMapping("/")
	public String home() {
		
		return "index";
	}
	
	@ModelAttribute
	public void globalAttribute(Model model) {
		
		model.addAttribute("greet", "Welcome Back Students");
		
	}
	
	// use @ModelAttribute which assign student obj automatically to it To be transfered to jsp page
	
	@RequestMapping("/addStudent")
	public String add(@ModelAttribute("output") Student s ) {
		
		Student student = studentRepo.save(s);
		System.out.println(student);
				
		return "result";
	}
	
	@GetMapping("/getAllStudents")
	public String getStudents(Model model) {
		
		List<Student> students = studentRepo.findAll();
		model.addAttribute("studentList", students);
		
		return "viewList";
	}
	
	@GetMapping("/getStudent")
	public String getStudent(Model model ,@RequestParam("id") int id) {
		
		Student student = studentRepo.findById(id).get();
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
	
	
	// using ModelAndView to set data & view together
	
//	@RequestMapping("add")
//	public ModelAndView add(@RequestParam("num1") int x , @RequestParam("num2") int y) {
//			
//		ModelAndView mv = new ModelAndView();
//		
//		int num3 = x + y ;
//		
//		mv.addObject("output", num3);
//		mv.setViewName("result");
//		
//		return mv;
//	}
//	
	
	
	// using HttpServletRequest to fetch params from the URL  & HttpSession to transfer data to jsp page
	
//	@RequestMapping("add")
//	public String add(HttpServletRequest req) {
//		
//		int x = Integer.parseInt(req.getParameter("num1"));
//		int y = Integer.parseInt(req.getParameter("num2"));
//		
//		int num3 = x + y ;
//		
//		HttpSession session = req.getSession();
//		session.setAttribute("output", num3);
//		
//		return "result.jsp";
//	}
	
	

}
