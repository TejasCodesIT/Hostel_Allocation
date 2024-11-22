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

import com.example.demo.Model.Wing_rooms;
import com.example.demo.services.Wing_Room_Service;

@RestController
public class WingRoomController {
				
			@Autowired
			private Wing_Room_Service wing_Room_Service;
		
	
	
			@GetMapping("Room")
			public List<Wing_rooms> getRoom() {
				
				
				return wing_Room_Service.getAllWings();
							
			}
			
			@PostMapping("Room")
			public String insertRoom(@RequestBody Wing_rooms room) {
				
				
				 return "Inserted : "+wing_Room_Service.insertRoom( room);
			}
			
			
			@PutMapping("Room")
			public void updateRoom( @RequestBody Wing_rooms room ) {
		  
				   
				wing_Room_Service.update(room);
				
				
			}
			
			@DeleteMapping("Room")
			public String delete(@RequestParam String id) {
				
				wing_Room_Service.delete(id);
				
				return "Deleted   ";
				
			}

}














