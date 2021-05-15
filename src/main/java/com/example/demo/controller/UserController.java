package com.example.demo.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.User;
import com.example.demo.form.UserForm;
import com.example.demo.repository.UserRepository;

@Controller
public class UserController {
	@Autowired
	UserRepository repository;
	
	@GetMapping("/")
	public String top(HttpSession session, Model model) {
//		Integer id = (Integer)session.getAttribute("id");
//		if (id == null) {
//			model.addAttribute("loginCheck", "ログアウト中");
//		}else {
//			model.addAttribute("loginCheck", "ログイン中");
//		}
		return "/layout/top";
	}
	
	@GetMapping("/users")
	public String index(Model model) {
		model.addAttribute("users", repository.findAll());
		return "/users/index";
	}
	
	@GetMapping("/users/{id}")
	public String show(@PathVariable int id, Model model) {
		model.addAttribute("user", repository.getOne(id));
		return "users/show";
	}
	
	@GetMapping("/users/{id}/edit")
	public String edit(@PathVariable int id, Model model) {
		model.addAttribute("user", repository.getOne(id));
		return "users/edit";
	}
	
	@PatchMapping("/users/{id}")
	public String update(@Valid @ModelAttribute UserForm form, BindingResult result, 
			@PathVariable int id) {
		if (result.hasErrors()) {
			return "users/edit";
		}
		User user = repository.getOne(id);
		user.setName(form.getName());
		user.setPassword(form.getPassword());
		repository.save(user);
		return "redirect:/users/" + id;
	}
	
	// 退会する
	@PatchMapping("/users/{id}/reject")
	public String rejectUser(@PathVariable int id, HttpSession session) {
		User user = repository.getOne(id);
		user.setDeleted(true);
		repository.save(user);
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("/users/login")
	public String login(@ModelAttribute UserForm form) {
		return "session/login";
	}
	
	// ログイン
	@PostMapping("/users/login")
	public String login(@Valid @ModelAttribute UserForm form, BindingResult result, 
			HttpSession session, RedirectAttributes flash) {
		if (result.hasErrors()) {
			flash.addFlashAttribute("org.springframework.validation.BindingResult.userForm", result);
			flash.addFlashAttribute("userForm", form);
			return "session/login";
		}
		Integer id = (Integer)session.getAttribute("id");
		if (id == null) {
			session.setAttribute("id", form.getId());
		}
		return "redirect:/users/" + form.getId();
	}
	
	// ログアウト
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	// 新規登録
	@GetMapping("/users/registration")
	public String registration(@ModelAttribute UserForm form) {
		return "/session/registration";
	}
	
	@PostMapping("/users/registration")
	public String registration(@Valid @ModelAttribute UserForm form, 
			BindingResult result, HttpSession session, RedirectAttributes flash) {
		if (result.hasErrors()) {
			flash.addFlashAttribute("org.springframework.validation.BindingResult.userForm", result);
			flash.addFlashAttribute("userForm", form);
			return "/session/registration";
		}
		User user = new User();
		user.setName(form.getName());
		user.setPassword(form.getPassword());
		repository.save(user);
		session.setAttribute("id", user.getId());
		return "redirect:/users/" + user.getId();
	}
}



