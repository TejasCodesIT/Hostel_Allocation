package com.example.demo.services;

import java.util.List;
import java.util.Optional;

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
	
	
	
//	public boolean cheakWingEligibility(String windid, String gender) {
//		
//		Optional<Wings> optionalwings= wingsRepo.findById(windid);
//		
//		if(optionalwings!=null) {
//			
//			Wings wing = optionalwings.get();
//			
//			String dbgender = wing.getGender_allowed();
//			
//			if(dbgender.equals(gender)) {
//				
//				return true;
//							
//			}
//			else return false;
//			
//		}
//		else return false ; 		
//		
//		
//		
//
//	}
	
	
	

}
