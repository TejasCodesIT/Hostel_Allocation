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
		
		@Autowired
		private WingsService service;
		
		@Autowired
	     private Wing_Room_Service room_Service;
	
	public List<Student> getStudent(){
		
		return studentRepo.findAll();
		
	}
	
	
	public String insertStudent(Student s) {
		
		
		String dbgender = room_Service.getWing(s.getRoom().getRoom_id());
		
				
		if(dbgender.equals(s.getGender())) {
			
			return "Inserted  Student is "+studentRepo.save(s);
		}
		else return "Please cheak gender or id";
		
		
	 	

	}
	
	public Optional<Student>  getByid(String id) {
		
		
		return studentRepo.findById(id);

	}
	
	public String update(Student s) {
		
		
		
//		String user_wingid = s.getRoom().getWing().getWing_id();
		
		String dbgender = room_Service.getWing(s.getRoom().getRoom_id());
		
		
		//boolean b = service.cheakWingEligibility(dbgender, s.getGender());
		
	    
		
		if(dbgender.equals(s.getGender())) {
			
			return "Updated  Student is "+studentRepo.save(s);
		}
		else return "Please cheak gender or id";
		
		
		
	}
	
	
	public String deleteById(String id) {
		
		studentRepo.deleteById(id); 
		
		return "Deleted" ;
	}

	
	
	
	
	

}
















