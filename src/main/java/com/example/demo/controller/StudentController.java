package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Student;
import com.example.demo.services.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService  studentService;
	
	
	
	@GetMapping("Student")
	public List<Student> getMapping(){
		
		
		return studentService.getStudent();
		
	}
	@PostMapping("Student")
	public String insert(@RequestBody Student s) {

		Student student = new Student();
		student = s; 
		return studentService.insertStudent(s);
	}
	
	
	
	
	

}


