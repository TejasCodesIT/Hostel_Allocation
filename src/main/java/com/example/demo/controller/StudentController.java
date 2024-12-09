package com.example.demo.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.Model.Student;
import com.example.demo.Model.User;
import com.example.demo.services.StudentService;
import com.example.demo.services.UserService;

import lombok.Delegate;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService  studentService;
	
	@Autowired
	private UserService userService;
	
	
	
	@GetMapping()
	public List<Student> getMapping(@RequestParam String username , @RequestParam String password){
		
		User user = userService.cheakUseer(username, password);
		
				
			if(user!=null) {
				String role = user.getRole();
			
			if(role.equals("admin")||role.equals("clerk")||role.equals("viewer") )	
			{
				
				return studentService.getStudent();
			}
			
			else return null;
		}
		else return null;
	
		
	}
	
	
	@PostMapping()
	public ModelAndView insert( Student s) {
		
		String username= "tejas";
		String password="123";
		
		User user = userService.cheakUseer(username, password);
		
		ModelAndView modelAndView = new  ModelAndView();

		if(user!=null) {
			String role = user.getRole();
			
			if(role.equals("admin")||role.equals("clerk"))
				
			{
				Student student = new Student();
				student = s; 
				
				modelAndView.setViewName("student_data");
				modelAndView.addObject("allstudent",studentService.getStudent());
				 modelAndView.addObject("message", "Student saved successfully!");
				return modelAndView;
			}
			
			else {
				
				return modelAndView.addObject("message", "Dont have access");		
				
			}
		}
		else {
			
			 return  modelAndView.addObject("message",  "User not found ... ");
			
			
		}
	
				
		
	}	
	
	@PutMapping()
	public String update(@RequestBody Student s,@RequestParam String username , @RequestParam String password) {
		
		
	
			User user = userService.cheakUseer(username, password);
		
			
		
			
			if(user!=null) {
				String role = user.getRole();
				
				if(role.equals("admin")||role.equals("clerk"))
					
				{
		         	return "Updated :"+studentService.update(s);
				}
				
				else return "User does not have authority to update ...";
			}
			else return "User not found ...";
		
	}
	
	
	@DeleteMapping()
	public String delete(@RequestParam String id,@RequestParam String username , @RequestParam String password) {
		
				User user = userService.cheakUseer(username, password);
		
				
				
				if(user!=null) {
					String role = user.getRole();
					
					if(role.equals("admin"))
						
					{
						return studentService.deleteById(id);
					}
					
					else return "User does not have authority to delete ...";
				}
				else return "User not found ...";
				
		
		
	
		
	}
	
	
	
	
	

}


