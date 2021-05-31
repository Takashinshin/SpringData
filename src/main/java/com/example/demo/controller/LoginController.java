package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
	
	@GetMapping("/login")
	public String getSignUp(Model model) {
		return "login";
	}
	
	@PostMapping("/login")
	public String postSignUp(Model model) {
		
		return "userList";
	}
}
