package com.example.demo.controller;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Item;
import com.example.demo.form.ItemForm;
import com.example.demo.repository.CommentsRepository;
import com.example.demo.repository.ItemRepository;

@Controller
public class ItemController {
 @Autowired
 ItemRepository repository;
 
 @Autowired
 CommentsRepository commentRepository;
 
 @GetMapping("/items/new") 
 public String newItem(@ModelAttribute ItemForm form) {
	 return "items/new";
 }
 
 @PostMapping("/items")
 public String create(@Valid @ModelAttribute ItemForm form, BindingResult result) {
	 if (result.hasErrors()) {
		 return newItem(form);
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
	 model.addAttribute("comments", commentRepository.findByItemId(id));
	 return "items/show";
 }
 
 @GetMapping("/items")
 public String index(Model model) {
	 model.addAttribute("items", repository.findAll());
	 return "items/index";
 }
 
 @GetMapping("/items/{id}/edit")
 public String edit(@PathVariable int id, Model model) {
	 model.addAttribute("item", repository.getOne(id));
	 return "items/edit";
 }
 
 @PatchMapping("/items/{id}")
 public String update(@PathVariable int id, ItemForm form, BindingResult result) {
	 Item item = repository.getOne(id);
	 item.setName(form.getName());
	 item.setPrice(form.getPrice());
	 repository.save(item);
	 return "redirect:/items/" + form.getId();
 }
 
 @DeleteMapping("/items/{id}")
 public String delete(@PathVariable int id) {
	 repository.delete(repository.getOne(id));
	 return "redirect:/items";
 }
 
 @GetMapping("/items/search")
 public String itemSearch(ItemForm form, Model model) {
	 model.addAttribute("items", repository.findByNameLike("%" + form.getName() + "%"));
	 return "items/index";
 }
 
}




