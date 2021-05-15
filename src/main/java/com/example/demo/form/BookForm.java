package com.example.demo.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.example.demo.entity.User;

public class BookForm {
	
	private Integer id;
	
	@NotBlank
	@Size(max = 100, min = 1)
	private String title;
	
	@NotBlank
	@Size(max = 1000, min = 1)
	private String text;
	
	private User user;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
