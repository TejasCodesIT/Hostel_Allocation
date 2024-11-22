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
import com.example.demo.Model.Wings;
import com.example.demo.services.WingsService;

@RestController
public class WingsController {
	
	@Autowired
	private WingsService wingsService;
	
	@GetMapping("Wings")
	public List<Wings> getWings() {
		
		return wingsService.getWings();
		
	}
	
	@PostMapping("Wings")
	public String insertWing(@RequestBody Wings room) {
		
		
		return "Inserted Wing :  " +wingsService.insertWing(room);
	}
	
	@PutMapping("Wings")
     public void update(@RequestBody Wings wings) {
		
		wingsService.update(wings);
	}
	
	@DeleteMapping("Wings")
	public String  delete(@RequestParam String id) {
		
		
		wingsService.delete(id) ;
		return "Deleted" ;
		
	}
	
	
	
	
	
	
}










