package com.juanliz.longform.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juanliz.longform.model.Question;
import com.juanliz.longform.repository.QuestionRepository;

@Service
public class QuestionService {

	private final QuestionRepository questionRepository;

	@Autowired
	public QuestionService(QuestionRepository questionRepository) {
		this.questionRepository = questionRepository;
	}

	// Create question
	public Question save(Question question) {
		return questionRepository.save(question);
	}

	// Read all questions and by properties if specified
	public List<Question> read(String chapter, String title, String content) {
		return questionRepository.filterQuestions(chapter, title, content);
	}

	// Find question by id
	public Optional<Question> findById(String id) {
		return questionRepository.findById(id);
	}

	// Delete question by id
	public void deleteById(String id) {
		questionRepository.deleteById(id);
	}

}
