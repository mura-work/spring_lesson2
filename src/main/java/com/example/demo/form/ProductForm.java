package com.example.demo.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.example.demo.entity.Genre;

public class ProductForm {
	
	@NotNull
	@Size(max = 20)
	private String name;
	
	@NotNull
	@Size(max = 10000, min = 100)
	private int price;
	
	@NotNull
	private Genre genre;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Genre getGenre() {
		return genre;
	}
	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	
	
}
