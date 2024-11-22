package com.example.demo.Model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
//@ToString(exclude = "wingRooms") 
public class Wings {
	
	@Id
//	@GeneratedValue(strategy = GenerationType.UUID)
	private String wing_id;
	private String wing_name;
	private String gender_allowed;
	private int capacity;
	private int occupied;
	
  @OneToMany(mappedBy = "wing")
    private List<Wing_rooms> rooms;

	
	
	
	
	public Wings() {
		super();
	
	}





	public Wings(String wing_id, String wing_name, String gender_allowed, int capacity, int occupied,
			List<Wing_rooms> rooms) {
		super();
		this.wing_id = wing_id;
		this.wing_name = wing_name;
		this.gender_allowed = gender_allowed;
		this.capacity = capacity;
		this.occupied = occupied;
		this.rooms = rooms;
	}





	
	

}
