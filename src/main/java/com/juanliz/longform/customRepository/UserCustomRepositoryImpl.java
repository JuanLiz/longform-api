package com.juanliz.longform.customRepository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.juanliz.longform.model.User;

public class UserCustomRepositoryImpl implements UserCustomRepository {

	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public List<User> filterUsers(String email, String name, String role, String finished) {

		final Query query = new Query();
		final List<Criteria> criteria = new ArrayList<>();

		// Check if filter parameters exists
		if (email != null && !email.isEmpty())
			criteria.add(Criteria.where("email").is(email));

		if (name != null && !name.isEmpty())
			criteria.add(Criteria.where("name").is(name));

		if (role != null && !role.isEmpty())
			criteria.add(Criteria.where("role").is(role));

		if (finished != null && !finished.isEmpty())
			criteria.add(Criteria.where("finished").is(finished));

		if (!criteria.isEmpty())
			query.addCriteria(new Criteria().andOperator(criteria.toArray(new Criteria[criteria.size()])));
		
		return mongoTemplate.find(query, User.class);

	}

}
