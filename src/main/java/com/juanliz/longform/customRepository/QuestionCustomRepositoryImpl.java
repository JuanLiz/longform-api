package com.juanliz.longform.customRepository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.juanliz.longform.model.Question;

public class QuestionCustomRepositoryImpl implements QuestionCustomRepository{
	
	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public List<Question> filterQuestions(String chapter, String title, String content) {

		final Query query = new Query();
		final List<Criteria> criteria = new ArrayList<>();

		// Check if filter parameters exists
		if (chapter != null && !chapter.isEmpty())
			criteria.add(Criteria.where("chapter").is(chapter));

		if (title != null && !title.isEmpty())
			criteria.add(Criteria.where("title").is(title));

		if (content != null && !content.isEmpty())
			criteria.add(Criteria.where("content").is(content));

		if (!criteria.isEmpty())
			query.addCriteria(new Criteria().andOperator(criteria.toArray(new Criteria[criteria.size()])));
		
		return mongoTemplate.find(query, Question.class);

	}

}
