package com.juanliz.longform.customRepository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.juanliz.longform.model.Answer;

public class AnswerCustomRepositoryImpl implements AnswerCustomRepository{
	
	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public List<Answer> filterAnswers(String iduser, String idquestion, String option, String comment) {

		final Query query = new Query();
		final List<Criteria> criteria = new ArrayList<>();

		// Check if filter parameters exists
		if (iduser != null && !iduser.isEmpty())
			criteria.add(Criteria.where("iduser").is(iduser));

		if (idquestion != null && !idquestion.isEmpty())
			criteria.add(Criteria.where("idquestion").is(idquestion));

		if (option != null && !option.isEmpty())
			criteria.add(Criteria.where("option").is(option));
		
		if (comment != null && !comment.isEmpty())
			criteria.add(Criteria.where("comment").is(comment));

		if (!criteria.isEmpty())
			query.addCriteria(new Criteria().andOperator(criteria.toArray(new Criteria[criteria.size()])));
		
		return mongoTemplate.find(query, Answer.class);

	}

}
