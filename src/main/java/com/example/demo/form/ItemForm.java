package com.example.demo.form;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class ItemForm {
	
	@Max(value = 999)
	@NotNull
	private int id;
	
	@NotNull
	@Pattern(regexp="^[a-zA-Z0-9]+$")
	private String name;
	
	@NotNull
	private Integer price;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}
}
