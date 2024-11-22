package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Wing_rooms {
	
	@Id
//	@GeneratedValue(strategy = GenerationType.UUID)
	private String room_id;
	
	
	 @ManyToOne
	 @JoinColumn(name = "wing_id")  
	 @JsonBackReference
	 private Wings wing;
    private String roomNumber;
	private String capacity;
	private int occupied ;
	
	
	
	public Wing_rooms() {
		super();
		
	}



	public Wing_rooms(String room_id, Wings wing, String roomNumber, String capacity, int occupied) {
		super();
		this.room_id = room_id;
		this.wing = wing;
		this.roomNumber = roomNumber;
		this.capacity = capacity;
		this.occupied = occupied;
	}



	


	
	
	
	

}
