package com.juanliz.longform.customRepository;

import java.util.List;

import com.juanliz.longform.model.Question;

public interface QuestionCustomRepository {
	
	public List<Question> filterQuestions(String chapter, String title, String content);

}
