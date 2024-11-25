package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.User;
import com.example.demo.Model.Wings;
import com.example.demo.services.UserService;
import com.example.demo.services.WingsService;

@RestController
public class WingsController {
	
	@Autowired
	private WingsService wingsService;
	
	@Autowired
	private UserService userService;

	
	@GetMapping("Wings")
	public List<Wings> getWings(@RequestParam String username , @RequestParam String password) {
		User user = userService.cheakUseer(username, password);
		
		
		if(user!=null) {
			String role = user.getRole();
		
		if(role.equals("admin")||role.equals("clerk")||role.equals("viewer") )	
		{
			
			  return wingsService.getWings();
		}
		
		else return null;
	}
	else return null;
		
		
	}
	
	@PostMapping("Wings")
	public String insertWing(@RequestBody Wings room,@RequestParam String username , @RequestParam String password) {
		
		User user = userService.cheakUseer(username, password);
		
		if(user!=null) {
			String role = user.getRole();
			
			if(role.equals("admin")||role.equals("clerk"))
				
			{
				
				  return  "Inserted Wing :  " +wingsService.insertWing(room);
			}
			
			else return "User does not have authority to insert ...";
		}
		else return "User not found ... ";
		
	}
	
	@PutMapping("Wings")
     public String update(@RequestBody Wings wings,@RequestParam String username , @RequestParam String password) {
		User user = userService.cheakUseer(username, password);
		
		
		if(user!=null) {
			String role = user.getRole();
			
			if(role.equals("admin")||role.equals("clerk"))
				
			{
	         	return "Updated :"+wingsService.update(wings);
			}
			
			else return "User does not have authority to update ...";
		}
		else return "User not found ...";
		
	}
	
	@DeleteMapping("Wings")
	public String  delete(@RequestParam String id,@RequestParam String username , @RequestParam String password) {
		

        User user = userService.cheakUseer(username, password);

	if(user!=null) {
		String role = user.getRole();
		
		if(role.equals("admin"))
			
		{
			
			wingsService.delete(id) ;
			return "Deleted" ;
		}
		
		else return "User does not have authority to delete ...";
	}
	else return "User not found ...";
		
		
	}
	
	
	
	
	
	
}










