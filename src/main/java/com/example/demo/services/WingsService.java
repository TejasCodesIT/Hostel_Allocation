package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.Model.Wings;
import com.example.demo.repository.WingsRepo;

@Service
public class WingsService {
	
	
	@Autowired
	private WingsRepo wingsRepo;
	
	
	public List<Wings> getWings() {
		
		
		return wingsRepo.findAll();
	}
	
	public String insertWing(Wings wing) {
		
		return "Inserted : "+wingsRepo.save(wing) ;
		
	}
	
	
	
	public String update(Wings w) {
				
		return "Updated Wings: "+wingsRepo.save(w) ; 
	}
	
	public String delete(String id) {
		
		wingsRepo.deleteById(id);
		return "Deleted Wing ";
	}
	
	
	
	
	
	
	

}
