package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.repository.UserRepository;

@Controller
public class UserController {
	@Autowired
	UserRepository repository;
	
	@GetMapping("/")
	public String top() {
		return "/layout/top";
	}
	
	@GetMapping("/users")
	public String index(Model model) {
		model.addAttribute("users", repository.findAll());
		return "/users/index";
	}
}
