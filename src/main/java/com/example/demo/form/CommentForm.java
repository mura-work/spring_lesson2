package com.example.demo.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.example.demo.entity.Item;

public class CommentForm {
	
	@NotNull
	private Integer id;
	
	@NotNull
	@Size(max = 1000)
	private String text;
	
	private Item item;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	
	
}
