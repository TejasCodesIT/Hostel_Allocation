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

import com.example.demo.Model.User;
import com.example.demo.services.UserService;

@RestController
@RequestMapping("user")
public class UserController {
	
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping
	public List<User> getUser() {
		
		return userService.getUsers();
			
	}
	
	@PostMapping
	public String insertUser(@RequestBody User user) {
		
		return userService.insertUser(user);
		
	}
	
	@PutMapping
	public String updateUser(@RequestBody User user) {
		
		return userService.updateUser(user);
		
	}
	
	@DeleteMapping
	public String deleteUser(int id) {
		
		return userService.deleteUser(id);
		
	}
	
	
	

}
