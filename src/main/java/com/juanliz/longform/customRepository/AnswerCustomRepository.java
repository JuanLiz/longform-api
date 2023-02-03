package com.juanliz.longform.customRepository;

import java.util.List;

import com.juanliz.longform.model.Answer;

public interface AnswerCustomRepository {
	
	public List<Answer> filterAnswers(String iduser, String idquestion, String option, String comment);

}
