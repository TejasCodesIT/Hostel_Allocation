package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.Model.User;
import com.example.demo.services.UserService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
@SessionAttributes("dbuser")
public class UserController {
	
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping
	public List<User> getUser() {
		
		return userService.getUsers();
			
	}
	
	@PostMapping
	public ModelAndView insertUser(User user) {
		
		 userService.insertUser(user);
			
		ModelAndView modelAndView = new ModelAndView();
		
		
		modelAndView.setViewName("user-data");
		 modelAndView.addObject("alluser", userService.getUsers());
		 modelAndView.addObject("message", "User saved successfully!");
		
		return modelAndView;
				
		
	}
	
//	@PutMapping
//	public String updateUser(@RequestBody User user) {
//		
//		return userService.updateUser(user);
//		
//	}
//	
	@DeleteMapping
	public String deleteUser(int id) {
		
		return userService.deleteUser(id);
		
	}
	
	@PostMapping("/login")
	public ModelAndView login(User user,HttpSession session) {
		
		User dbuser = userService.cheakUseer(user.getUsername(), user.getPassword());
		
		
		ModelAndView modelAndView = new ModelAndView();
		
		
		
		if(dbuser!=null) {
			 session.setAttribute("dbuser", dbuser);
			 modelAndView.setViewName("redirect:/mainMenu");
			modelAndView.addObject("dbuser", dbuser);
			modelAndView.addObject("message","Login Successfully...!");
		
		
		}
		else {
			modelAndView.setViewName("index");
			modelAndView.addObject("message", "Faild to login");
			
			
			
		}
	  
		return modelAndView;
		
		
		
		
	}
	
	
	

}
