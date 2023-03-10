package com.danilomaia.workshopspringbootmongodb.repositories;

import com.danilomaia.workshopspringbootmongodb.entities.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {

}
