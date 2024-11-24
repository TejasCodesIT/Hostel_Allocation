package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Wing_rooms;
import com.example.demo.Model.Wings;
import com.example.demo.repository.WingRoomRepo;


@Service
public class Wing_Room_Service {
	
	
	@Autowired
	private WingRoomRepo wingRoomRepo;
	
	public List<Wing_rooms> getAllWings() {
		
		return wingRoomRepo.findAll();		

	}
	
	public Wing_rooms insertRoom(Wing_rooms room) {
		
		return wingRoomRepo.save(room);
		
	}
	
	public void getByID(String id) {
		
		wingRoomRepo.findById(id);
	   
	}
	
	
	public Wing_rooms update(Wing_rooms room) {
		
        return wingRoomRepo.save(room); 
        
    }
	public void delete(String id) {
		
		
		wingRoomRepo.deleteById(id);
		
	}
	
	
	public String getWing(String roomid) {
		
		Optional<Wing_rooms> optional =wingRoomRepo.findById(roomid);
		
		
		if(optional!=null) {
			
			Wing_rooms room = optional.get();
			
		      String gender  	= room.getWing().getGender_allowed() ;
		      
		      return gender ; 
			
		}
		else return null;
		
	}
	
	
	
	
	

}
