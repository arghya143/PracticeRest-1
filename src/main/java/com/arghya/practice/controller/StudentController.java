package com.arghya.practice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.arghya.practice.dao.MyRepository;
import com.arghya.practice.model.Student;

@RestController
public class StudentController {
	
	@Autowired
	MyRepository repo;
	
	@RequestMapping("/")
	public ModelAndView home()
	{
		ModelAndView mv=new ModelAndView("StudentInput.jsp");
		return mv;
		
	}
	@RequestMapping("/home")
	public ModelAndView home2()
	{
		ModelAndView mv=new ModelAndView("StudentPost.jsp");
		return mv;
		
	}
	
	@GetMapping(path="/getStudent")
	public ModelAndView getStud(@RequestParam String roll)
	{
		ModelAndView mv = new ModelAndView("ShowStudent.jsp");
		
		mv.addObject("obj",repo.findById(Integer.parseInt(roll)));
		return mv;
	}
	
	
	@GetMapping(path="/students")
	public List<Student>  getStudents()
	{
		return repo.findAll();
	}

	@GetMapping(path="/student/{roll}")
	public Optional<Student> getStudent(@PathVariable("roll") int roll)
	{
		return repo.findById(roll);
	}
	
	@PostMapping(path="/postStudent")
	public Student addStud(Student student)
	{
		repo.save(student);
		return student;
	}
	
	@PostMapping(path="/student")
	public Student addStudent(@RequestBody Student student)
	{
		repo.save(student);
		return student;
	}
	
	@PutMapping(path="/student")
	public Student saveOrUpdateStudent(@RequestBody Student student)
	{
		repo.save(student);
		return student;
	}
	
	@DeleteMapping(path="/student/{roll}")
	public String deleteStudent(@PathVariable("roll") int roll)
	{
		repo.deleteById(roll);
		return "deleted";
	}
}
