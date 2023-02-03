package com.juanliz.longform.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.juanliz.longform.customRepository.QuestionCustomRepository;
import com.juanliz.longform.model.Question;

@Repository
public interface QuestionRepository extends MongoRepository<Question, String>, QuestionCustomRepository{

}
