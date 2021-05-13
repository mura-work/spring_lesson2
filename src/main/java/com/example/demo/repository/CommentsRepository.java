package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Comments;

public interface CommentsRepository extends JpaRepository<Comments, Integer> {
//	@Query("(SELECT c FROM Comments.c WHERE c.item.id = :id ORDER BY c.id ASC)")
	List<Comments> findByItemId(int id);
	List<Comments> findByTextLike(String text);
}
