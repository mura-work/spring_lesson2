package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
//	@Query("DELETE FROM books b WHERE b.id = :id")
//	Book deleteById(int id);
	
	Book getById(int id);
	List<Book> findByTitleLike(String title);
}
