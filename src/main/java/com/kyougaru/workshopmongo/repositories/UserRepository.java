package com.kyougaru.workshopmongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.kyougaru.workshopmongo.domain.User;

public interface UserRepository extends MongoRepository<User, String> {

}
