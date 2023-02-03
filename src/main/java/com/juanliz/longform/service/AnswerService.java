package com.juanliz.longform.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juanliz.longform.model.Answer;
import com.juanliz.longform.repository.AnswerRepository;

@Service
public class AnswerService {
	
	private final AnswerRepository answerRepository;

	@Autowired
	public AnswerService(AnswerRepository answerRepository) {
		this.answerRepository = answerRepository;
	}

	// Create answer
	public Answer save(Answer answer) {
		return answerRepository.save(answer);
	}

	// Read all answers and by properties if specified
	public List<Answer> read(String iduser, String idquestion, String option, String comment){
		return answerRepository.filterAnswers(iduser, idquestion, option, comment);
	}

	// Find answer by id
	public Optional<Answer> findById(String id) {
		return answerRepository.findById(id);
	}

	// Delete answer by id
	public void deleteById(String id) {
		answerRepository.deleteById(id);
	}
	


}
