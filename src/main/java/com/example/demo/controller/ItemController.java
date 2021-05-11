package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Item;
import com.example.demo.form.ItemForm;
import com.example.demo.repository.ItemRepository;

@Controller
public class ItemController {
 @Autowired
 ItemRepository repository;
 
 @GetMapping("/items/new") 
 public String newItem(ItemForm form) {
	 return "items/new";
 }
 
 @PostMapping("/items")
 public String create(ItemForm form, BindingResult result) {
	 if (result.hasErrors()) {
		 return "items/new";
	 }
	 Item item = new Item();
	 item.setName(form.getName());
	 item.setPrice(form.getPrice());
	 repository.save(item);
	 return "redirect:/items/" + item.getId();
 }
 
 @GetMapping("/items/{id}")
 public String show(@PathVariable int id, Model model) { 
	 model.addAttribute("items", repository.getOne(id));
	 return "items/show";
 }
 
 @GetMapping("/items")
 public String index(Model model) {
	 model.addAttribute("items", repository.findAll());
	 return "items/index";
 }
 
 @GetMapping("/items/{id}/edit")
 public String edit(@PathVariable int id, Model model) {
	 model.addAttribute("items", repository.findById(id));
	 return "items/edit";
 }
 
}




