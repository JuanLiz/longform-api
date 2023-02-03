package com.juanliz.longform.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.juanliz.longform.customRepository.AnswerCustomRepository;
import com.juanliz.longform.model.Answer;

@Repository
public interface AnswerRepository extends MongoRepository<Answer, String>, AnswerCustomRepository{

}