package com.danilomaia.workshopspringbootmongodb.repositories;

import com.danilomaia.workshopspringbootmongodb.entities.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PostRepository extends MongoRepository<Post, String> {

    List<Post> findByTitleContainingIgnoreCase(String text);

}
