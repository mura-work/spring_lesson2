package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.form.EmployeeForm;
import com.example.demo.repository.EmployeeRepository;

@Controller
public class EmployeeController {
	@Autowired
	EmployeeRepository repository;
	
	@RequestMapping("/employee/new")
	public String empNew(EmployeeForm form, Model model) {
		model.addAttribute("employeeForm", form);
		return "emp/new";
	}
	
	@PostMapping("/employee/new_confirm")
	public String empNewConfirm(@Validated @ModelAttribute EmployeeForm form, BindingResult result,
			RedirectAttributes flash) {
		if (result.hasErrors()) {
			return "redirect:/employee/new";
		}
		return "emp/confirm";
	}
}
