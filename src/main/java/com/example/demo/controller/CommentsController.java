package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Comments;
import com.example.demo.form.CommentForm;
import com.example.demo.repository.CommentsRepository;
import com.example.demo.repository.ItemRepository;

@Controller
public class CommentsController {
	@Autowired
	CommentsRepository repository;
	
	@Autowired
	ItemRepository itemRepository;
	
	@PostMapping("/items/{id}/comments")
	public String create(@Valid @ModelAttribute CommentForm form, @PathVariable int id) {
		Comments comment = new Comments();
		comment.setText(form.getText());
		comment.setItem(itemRepository.getOne(id));
		repository.save(comment);
		return "redirect:/items/" + id;
	}
	
	@DeleteMapping("/items/{item_id}/comments/{id}")
	public String delete(@PathVariable int item_id, @PathVariable int id) { 
		repository.delete(repository.getOne(id));
		return "redirect:/items/" + item_id;
	}
	
}
