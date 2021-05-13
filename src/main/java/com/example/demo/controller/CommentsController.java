package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Comments;
import com.example.demo.form.CommentForm;
import com.example.demo.repository.CommentsRepository;

@Controller
public class CommentsController {
	@Autowired
	CommentsRepository repository;
	
	@PostMapping("/items/{id}/comments")
	public String create(@Valid @ModelAttribute CommentForm form, @PathVariable int id) {
		Comments comment = new Comments();
		comment.setText(form.getText());
		comment.setItem(form.getItem());
		repository.save(comment);
		return "redirect:/items/" + comment.getId();
	}
}
