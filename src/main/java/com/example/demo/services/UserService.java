package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.User;
import com.example.demo.repository.UserRepo;

@Service
public class UserService {
	
	@Autowired
	private UserRepo repo ;
	
	
	
	public List<User> getUsers() {
		
		
		return repo.findAll();
		
	}
	
	
	public String insertUser(User user) {
		
		return "Inserted : "+repo.save(user);
		
	}
	
	
	public String updateUser(User user) {
		
		
		return "Updated : "+repo.save(user);
	}
	
	
	
	public Optional<User> findByID(int id) {
		
		
		return repo.findById(id);
		
	}
	
	public String deleteUser(int id) {
		
		repo.deleteById(id);
		
		return "Deleted";
		
	}
	
	
	public User cheakUseer(String username,String password) {
		
		
		Optional<User> optional = repo.findByUsername(username);
		
		if(optional!=null) {
			
			User user = optional.get();
			
			
			if(user.getPassword().equals(password)) {
				
				return user ;
				
			}
			else return null;	
			
		}
		
		else 	return null;
		
		
		
	}
	
	
	
	
	

}
