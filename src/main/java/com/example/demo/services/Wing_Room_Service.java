package com.example.demo.services;

import java.util.List;

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
	

}
