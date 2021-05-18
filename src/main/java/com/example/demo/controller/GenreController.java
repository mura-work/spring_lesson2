package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.demo.repository.GenreRepository;

@Controller
public class GenreController {
	@Autowired
	GenreRepository repository;
}
