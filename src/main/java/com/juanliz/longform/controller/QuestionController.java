package com.juanliz.longform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.juanliz.longform.model.Question;
import com.juanliz.longform.service.QuestionService;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class QuestionController {

	private final QuestionService questionService;

	@Autowired
	public QuestionController(QuestionService questionService) {
		this.questionService = questionService;
	}

	// Create question
	@PostMapping("/questions")
	public ResponseEntity<?> save(@RequestBody Question question) {
		return ResponseEntity.ok().body(questionService.save(question));
	}

	// Read all questions and filter if the request has parameters
	@GetMapping("/questions")
	public ResponseEntity<?> read(@RequestParam(required = false) String chapter,
			@RequestParam(required = false) String title, 
			@RequestParam(required = false) String content
			) {
		return ResponseEntity.ok().body(questionService.read(chapter, title, content));
	}
	
	// Read question by id
	@GetMapping("/questions/{id}")
	public ResponseEntity<?> findByid(@PathVariable String id) {
		return ResponseEntity.ok().body(questionService.findById(id).get());
	}

	// Update question
	@PutMapping("/questions")
	public ResponseEntity<?> update(@RequestBody Question question) {
		return ResponseEntity.ok().body(questionService.save(question));
	}

	// Delete question by id
	@DeleteMapping("/questions/{id}")
	public void deleteById(@PathVariable String id) {
		questionService.deleteById(id);
	}
	

}
