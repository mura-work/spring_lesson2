package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "genres")
public class Genre {
	private Integer id;
	private String name;
	private boolean isEnabled;
}
