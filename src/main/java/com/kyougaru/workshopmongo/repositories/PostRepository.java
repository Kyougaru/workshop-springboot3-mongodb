package com.kyougaru.workshopmongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.kyougaru.workshopmongo.domain.Post;

public interface PostRepository extends MongoRepository<Post, String> {

}