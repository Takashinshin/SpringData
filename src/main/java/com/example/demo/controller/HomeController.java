package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.model.User;
import com.example.demo.service.UserService;


@Controller
public class HomeController {
	@Autowired
	UserService userService;

	
	
	@GetMapping("/userList")
	public String getUserList(Model model) {
		List<User> userList = userService.selectMany();
		
		
		model.addAttribute("userList", userList);
		
		return "redirect:/userList";
	}

}
