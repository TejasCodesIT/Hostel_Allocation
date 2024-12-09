package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.example.demo.Model.User;

@Controller
public class MainMenuController {
	
	
	 @GetMapping("/mainMenu")
	    public String showMainMenu( User dbuser) {
	        if (dbuser != null) {
	            return "mainMenu"; // Make sure you have a mainMenu.html in the templates folder
	        } else {
	            return "redirect:/user/login"; // Redirect to login if user is not found in session
	        }
	    }

}
