package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.form.EmployeeForm;
import com.example.demo.repository.EmployeeRepository;

@Controller
public class EmployeeController {
	@Autowired
	EmployeeRepository repository;
	
	@GetMapping("/employee/new")
	public String empNew(EmployeeForm form, Model model) {
		model.addAttribute("employeeForm", form);
		return "emp/new";
	}
}
