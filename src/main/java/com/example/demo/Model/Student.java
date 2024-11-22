package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Student {
	
	@Id
//	@GeneratedValue(strategy = GenerationType.UUID)
	private String student_id;
	private String name;
	private int age;
	private String gender;
	private String phone_number;
	private String email;
	
	
	  @ManyToOne
	  @JsonBackReference
	  @JoinColumn(name = "room_id")
	  private Wing_rooms room;

	
	
	public Student() {
		super();
		
	}



	public Student(String student_id, String name, int age, String gender, String phone_number, String email,
			Wing_rooms room) {
		super();
		this.student_id = student_id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.phone_number = phone_number;
		this.email = email;
		this.room = room;
	}



	@Override
	public String toString() {
		return "Student [student_id=" + student_id + ", name=" + name + ", age=" + age + ", gender=" + gender
				+ ", phone_number=" + phone_number + ", email=" + email + ", room=" + room + "]";
	}


	
	
	
	
	

}
