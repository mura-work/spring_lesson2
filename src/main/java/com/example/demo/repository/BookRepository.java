package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
//	@Query("DELETE FROM books b WHERE b.id = :id")
//	Book deleteById(int id);
	
	Book getById(int id);
}
