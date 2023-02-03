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

import com.juanliz.longform.model.Answer;
import com.juanliz.longform.service.AnswerService;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class AnswerController {

	private final AnswerService answerService;

	@Autowired
	public AnswerController(AnswerService answerService) {
		this.answerService = answerService;
	}

	// Create answer
	@PostMapping("/answers")
	public ResponseEntity<?> save(@RequestBody Answer answer) {
		return ResponseEntity.ok().body(answerService.save(answer));
	}

	// Read all answers and filter if the request has parameters
	@GetMapping("/answers")
	public ResponseEntity<?> read(@RequestParam(required = false) String iduser,
			@RequestParam(required = false) String idquestion, 
			@RequestParam(required = false) String option,
			@RequestParam(required = false) String comment 
			) {
		return ResponseEntity.ok().body(answerService.read(iduser, idquestion, option, comment));
	}
	
	// Read answer by id
	@GetMapping("/answers/{id}")
	public ResponseEntity<?> findByid(@PathVariable String id) {
		return ResponseEntity.ok().body(answerService.findById(id).get());
	}

	// Update answer
	@PutMapping("/answers")
	public ResponseEntity<?> update(@RequestBody Answer answer) {
		return ResponseEntity.ok().body(answerService.save(answer));
	}

	// Delete answer by id
	@DeleteMapping("/answers/{id}")
	public void deleteById(@PathVariable String id) {
		answerService.deleteById(id);
	}
	

}
