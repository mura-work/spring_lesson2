package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.form.CountForm;

@Controller
public class CountController {
	
	@GetMapping("/count/number")
	public String count() {
		return "count/new"; 
	}
	
	@PostMapping("/count/number")
	public String count(HttpSession session, CountForm form) {
		int sessionCount = 0;
		try {
			sessionCount = (int)session.getAttribute("number");
		}catch (NullPointerException e) {	
			
		}finally {
			sessionCount += form.getNumber();
			session.setAttribute("number", sessionCount);
		}
		return "redirect:/index/number";
	}
	
	@GetMapping("/index/number")
	public String countIndex(HttpSession session, Model model) {
		model.addAttribute("number", session.getAttribute("number"));
		return "count/index";
	}
	
	
}
