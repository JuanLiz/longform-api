package com.juanliz.longform.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.juanliz.longform.customRepository.UserCustomRepository;
import com.juanliz.longform.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>, UserCustomRepository{

}
