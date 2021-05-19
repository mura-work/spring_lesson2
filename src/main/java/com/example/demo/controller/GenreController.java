package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.Genre;
import com.example.demo.form.GenreForm;
import com.example.demo.repository.GenreRepository;

@Controller
public class GenreController {
	@Autowired
	GenreRepository repository;
	
	@GetMapping("/genres")
	public String index(GenreForm form, Model model) {
		model.addAttribute("genres", repository.findAll());
		return "genres/index";
	}
	
	@PostMapping("/genres")
	public String create(@Validated @ModelAttribute GenreForm form, 
			BindingResult result, RedirectAttributes flash) {
		if (result.hasErrors()) {
			flash.addFlashAttribute("flash", "エラーが発生しました");
			return "genres/index";
		}
		Genre genre = new Genre();
		genre.setName(form.getName());
		repository.save(genre);
		return "redirect:/genres";
	}
	
	@GetMapping("/genres/{id}/edit")
	public String edit(@ModelAttribute GenreForm form, 
			@PathVariable int id, Model model) {
		model.addAttribute("genres", repository.getById(id));
		return "genres/edit";
	}
	
	@PatchMapping("/genres/{id}")
	public String update(@PathVariable int id, GenreForm form, 
			BindingResult result) {
		if (result.hasErrors()) {
			return "genres/edit";
		}
		Genre genre = repository.getById(id);
		genre.setName(form.getName());
		repository.save(genre);
		return "redirect:/genres";
	}
	
	@DeleteMapping("/genres/{id}")
	public String delete(@PathVariable int id) {
		repository.deleteById(id);
		return "redirect:/genres";
	}
}
