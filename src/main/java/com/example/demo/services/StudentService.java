package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Student;
import com.example.demo.repository.StudentRepo;

@Service
public class StudentService {
	
		@Autowired
		private StudentRepo studentRepo;
	
	public List<Student> getStudent(){
		
		return studentRepo.findAll();
		
	}
	
	
	public String insertStudent(Student s) {
		
		
	
		return "Inserted Student is "+studentRepo.save(s);

	}
	
	public Optional<Student>  getByid(String id) {
		
		
		return studentRepo.findById(id);

	}
	
	public Student update(Student s) {
		
		return studentRepo.save(s) ;
		
		
	}
	
	
	public String deleteById(String id) {
		
		studentRepo.deleteById(id); 
		
		return "Deleted" ;
	}

	
	
	
	
	

}
















