package com.example.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.Survey;

public interface SurveyRepository extends JpaRepository<Survey, Integer> {
	List<Survey> findAll();
	List<Survey> findById(int id);
	List<Survey> findByComment(String comment);
}
