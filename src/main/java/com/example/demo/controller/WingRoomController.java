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

import com.example.demo.Model.Student;
import com.example.demo.Model.User;
import com.example.demo.Model.Wing_rooms;
import com.example.demo.services.UserService;
import com.example.demo.services.Wing_Room_Service;

@RestController
public class WingRoomController {
				
			@Autowired
			private Wing_Room_Service wing_Room_Service;
		
			@Autowired
			private UserService userService;
	
			@GetMapping("Room")
			public List<Wing_rooms> getRoom(@RequestParam String username , @RequestParam String password) {
				
				User user = userService.cheakUseer(username, password);
				
				
				if(user!=null) {
					String role = user.getRole();
				
				if(role.equals("admin")||role.equals("clerk")||role.equals("viewer") )	
				{
					
					 return wing_Room_Service.getAllWings();
				}
				
				else return null;
			}
			else return null;
			
				
							
			}
			
			@PostMapping("Room")
			public String insertRoom(@RequestBody Wing_rooms room, @RequestParam String username , @RequestParam String password) {
				
				User user = userService.cheakUseer(username, password);
				
				if(user!=null) {
					String role = user.getRole();
					
					if(role.equals("admin")||role.equals("clerk"))
						
					{
						
						  return "Inserted : "+wing_Room_Service.insertRoom( room);
					}
					
					else return "User does not have authority to insert ...";
				}
				else return "User not found ... ";
				
			}
			
			
			@PutMapping("Room")
			public String updateRoom( @RequestBody Wing_rooms room,@RequestParam String username , @RequestParam String password ) {
		  
				User user = userService.cheakUseer(username, password);
				
						
				if(user!=null) {
					String role = user.getRole();
					
					if(role.equals("admin")||role.equals("clerk"))
						
					{
			         	return "Updated :"+wing_Room_Service.update(room);
					}
					
					else return "User does not have authority to update ...";
				}
				else return "User not found ...";
				
				
				
			}
			
			@DeleteMapping("Room")
			public String delete(@RequestParam String id , @RequestParam String username , @RequestParam String password) {
				
				
	                User user = userService.cheakUseer(username, password);
		
				if(user!=null) {
					String role = user.getRole();
					
					if(role.equals("admin"))
						
					{
						
						wing_Room_Service.delete(id);
						return "Deleted   ";
					}
					
					else return "User does not have authority to delete ...";
				}
				else return "User not found ...";
			
				
			}

}














